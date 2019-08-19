package com.example.solrsearch.service.Imp;

import com.example.solrsearch.dto.*;
import com.example.solrsearch.entity.Category;
import com.example.solrsearch.entity.Video;
import com.example.solrsearch.repository.VideoRepository;
import com.example.solrsearch.service.VideoSearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class VideoSearchServiceImp implements VideoSearchService {


    @Autowired
    VideoRepository videoRepository;

    ObjectMapper mapper = new ObjectMapper();


    @Override
    public Video addVideos(Program program) throws JsonProcessingException {
        log.debug("Video is getting added");
        Video video = Video.builder()
                .crewList(program.getCrewList())
                .keywords(Arrays.asList(program.getKeywords().split(" ")))
                .languages(Arrays.asList(program.getLanguages().split(" ")))
                .description(program.getDescription())
                .id(program.getId())
                .name(program.getName())
                .type(program.getType())
                .imgUrls(mapper.writeValueAsString(program.getImgUrls()))
                .startDate(program.getStartDate())
                .expiryDate(program.getExpiryDate())
                .creationDate(program.getCreationDate())
                .parentalRating(program.getParentalRating())
                .categoriesList(new ArrayList<>()).build();

        Category category = program.getCategory();


        if (category != null) {
            do {
                video.getCategoriesList().add(category.getCategoryName());
                category = category.getParent();
            } while (null != category);
        }
        StringBuilder pathVariable = new StringBuilder();
        pathVariable.append("home/");
        Collections.reverse(video.getCategoriesList());
        for (String s : video.getCategoriesList()) {
            pathVariable.append(s + "/");
        }
        video.setPath(pathVariable.toString());
        video.getCategoriesList().add("home");


        return videoRepository.save(video);
    }

    @Override
    public Page<Video> getAllVideos(int pageNumber, int pageSize) {
        log.debug("Got all videos");
        return videoRepository.getAllVideos(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public boolean deleteAll() {
        log.debug("Deleted");
        videoRepository.deleteAll();
        return true;
    }

    @Override
    public Map<String,Page<VideoResponse>> search(String searchTerm, String videoType, String categoryFilter, int pageNumber, int pageSize) throws Exception {
        log.debug("Searched");
        Page<Video> videoPage = videoRepository.search(searchTerm, videoType, categoryFilter, PageRequest.of(pageNumber, pageSize));
        List<VideoResponse> dtoList = new ArrayList<>();
        for (Video video : videoPage.getContent()) {
            dtoList.add(this.convertToDto(video));
        }
        Map<String,Page<VideoResponse>> videoResponseMap= new HashMap<String,Page<VideoResponse>>();
        List<VideoResponse> dtoList1 = new ArrayList<>();
        List<VideoResponse> dtoList2 = new ArrayList<>();
        List<VideoResponse> dtoList3 = new ArrayList<>();
        for(VideoResponse videoResponse : dtoList)
        {
            if(videoResponse.getType().equals("Seasonal-video-program"))
            {
                dtoList1.add(videoResponse);
            }
            else if(videoResponse.getType().equals("Multi-video-program"))
            {
                dtoList2.add(videoResponse);
            }
            else
                dtoList3.add(videoResponse);
        }
        Page<VideoResponse> videoResponsePage1=new PageImpl<>(dtoList1,videoPage.getPageable(),dtoList1.size());
        Page<VideoResponse> videoResponsePage2=new PageImpl<>(dtoList2,videoPage.getPageable(),dtoList2.size());
        Page<VideoResponse> videoResponsePage3=new PageImpl<>(dtoList3,videoPage.getPageable(),dtoList3.size());
        videoResponseMap.put("Seasonal-video-program",videoResponsePage1);
        videoResponseMap.put("Multi-video-program",videoResponsePage2);
        videoResponseMap.put("Single-video-program",videoResponsePage3);
        //return new PageImpl<>(dtoList, videoPage.getPageable(), videoPage.getTotalElements());
        return videoResponseMap;
    }

    @Override
    public Map<String,Page<VideoResponse>> autoSuggest(String word, int pageNumber, int pageSize) throws Exception {
        log.debug("Auto suggest");
        //return videoRepository.autoSuggest(word, pageNumber, pageSize);

        Page<Video> videoPage = videoRepository.autoSuggest(word, pageNumber, pageSize);
        List<VideoResponse> dtoList = new ArrayList<>();
        for (Video video : videoPage.getContent()) {
            dtoList.add(this.convertToDto(video));
        }
        Map<String,Page<VideoResponse>> videoResponseMap= new HashMap<String,Page<VideoResponse>>();
        List<VideoResponse> dtoList1 = new ArrayList<>();
        List<VideoResponse> dtoList2 = new ArrayList<>();
        List<VideoResponse> dtoList3 = new ArrayList<>();
        for(VideoResponse videoResponse : dtoList)
        {
            if(videoResponse.getType().equals("Seasonal-video-program"))
            {
                dtoList1.add(videoResponse);
            }
            else if(videoResponse.getType().equals("Multi-video-program"))
            {
                dtoList2.add(videoResponse);
            }
            else
                dtoList3.add(videoResponse);
        }
        Page<VideoResponse> videoResponsePage1=new PageImpl<>(dtoList1,videoPage.getPageable(),dtoList1.size());
        Page<VideoResponse> videoResponsePage2=new PageImpl<>(dtoList2,videoPage.getPageable(),dtoList2.size());
        Page<VideoResponse> videoResponsePage3=new PageImpl<>(dtoList3,videoPage.getPageable(),dtoList3.size());
        videoResponseMap.put("Seasonal-video-program",videoResponsePage1);
        videoResponseMap.put("Multi-video-program",videoResponsePage2);
        videoResponseMap.put("Single-video-program",videoResponsePage3);
        //return new PageImpl<>(dtoList, videoPage.getPageable(), videoPage.getTotalElements());
        return videoResponseMap;
    }

    @Override
    public Video update(Video video) {

        log.debug("Updated");
        return videoRepository.save(video);

    }
    @Override
    public boolean deleteById(String id) {
        videoRepository.deleteById(id);
        return true;
    }

    @Override
    public Video addSingleVideo(SingleVideoDto singleVideoDto) throws JsonProcessingException {

        Video video = Video.builder()
                .id(singleVideoDto.getId())
                .episodeTitle(singleVideoDto.getVideoTitle())
                .episodeImageUrls(mapper.writeValueAsString(singleVideoDto.getVideoUrls()))
                .episodeDescription(singleVideoDto.getDescription())
                .crewList(Optional.of(singleVideoDto).map(SingleVideoDto::getCrewList).orElse(null))
                .id(singleVideoDto.getProgram().getId())
                .keywords(Arrays.asList(singleVideoDto.getProgram().getKeywords().split(",")))
                .parentalRating(singleVideoDto.getProgram().getParentalRating())
                .description(singleVideoDto.getProgram().getDescription())
                .languages(Arrays.asList(singleVideoDto.getProgram().getLanguages().split(" ")))
                .startDate(singleVideoDto.getProgram().getStartDate())
                .expiryDate(singleVideoDto.getProgram().getExpiryDate())
                .creationDate(singleVideoDto.getProgram().getCreationDate())
                .imgUrls(mapper.writeValueAsString(singleVideoDto.getProgram().getImgUrls()))
                .type(singleVideoDto.getProgram().getType())
                .name(singleVideoDto.getProgram().getName())
                .crewListJson(mapper.writeValueAsString(singleVideoDto.getCrewList()))
                .categoriesList(new ArrayList<>()).build();

        Category category = singleVideoDto.getProgram().getCategory();
        if (category != null) {
            do {
                video.getCategoriesList().add(category.getCategoryName());
                category = category.getParent();
            } while (null != category);
        }
        StringBuilder pathVariable = new StringBuilder();
        pathVariable.append("home/");
        Collections.reverse(video.getCategoriesList());
        for (String s : video.getCategoriesList()) {
            pathVariable.append(s + "/");
        }
        video.setPath(pathVariable.toString());
        video.getCategoriesList().add("home");
        return videoRepository.save(video);
    }

    public VideoResponse convertToDto(Video video) throws IOException {
        return VideoResponse.builder()
                .keywords(video.getKeywords())
                .crewList(mapper.readValue(video.getCrewListJson(), HashMap.class))
                .languages(video.getLanguages())
                .description(video.getDescription())
                .type(video.getType())
                .id(video.getId())
                .name(video.getName())
                .categoriesList(video.getCategoriesList())
                .autocomp(video.getAutocomp())
                .path(video.getPath())
                .imgUrls(Objects.nonNull(video.getImgUrls()) ? mapper.readValue(video.getImgUrls(), HashMap.class) : null)
                .seasonImgUrls(Objects.nonNull(video.getSeasonImgUrls()) ? mapper.readValue(video.getSeasonImgUrls(), HashMap.class) : null)
                .episodeImageUrls(Objects.nonNull(video.getEpisodeImageUrls()) ? mapper.readValue(video.getEpisodeImageUrls(), HashMap.class) : null)
                .startDate(video.getStartDate())
                .expiryDate(video.getExpiryDate())
                .creationDate(video.getCreationDate())
                .parentalRating(video.getParentalRating())
                .seasonName(video.getSeasonName())
                .episodeDescription(video.getEpisodeDescription())
                .episodeNumber(video.getEpisodeNumber())
                .episodeTitle(video.getEpisodeTitle())
                .episodeId(video.getEpisodeId())
                .seasonNumber(video.getSeasonNumber())
                .seasonId(video.getSeasonId()).
                        seasonDescription(video.getDescription())
                .build();
    }

    @Override
    public List<Video> addEpisodeVideo(List<RequestDto> requestDtoList) throws JsonProcessingException {
        List<Video> videoList = new ArrayList<>();
        for (RequestDto requestDto : requestDtoList) {
            Video video = Video.builder()
                    .episodeId(requestDto.getId())
                    .episodeNumber(requestDto.getEpisodeNumber())
                    .episodeTitle(requestDto.getEpisodeTitle())
                    .episodeDescription(requestDto.getEpisodeDescription())
                    .episodeImageUrls(mapper.writeValueAsString(requestDto.getEpisodeImageUrls()))
                    .crewList(Optional.of(requestDto).map(RequestDto::getCrewList).orElse(null))
                    .seasonId(Optional.of(requestDto.getSeason()).map(SeasonDto::getId).orElse(null))
                    .seasonDescription(Optional.of(requestDto.getSeason()).map(SeasonDto::getSeasonDescription).orElse(null))
                    .seasonName(Optional.of(requestDto.getSeason()).map(SeasonDto::getSeasonName).orElse(null))
                    .seasonNumber(Optional.of(requestDto.getSeason()).map(SeasonDto::getSeasonNumber).orElse(null))
                    .seasonImgUrls(mapper.writeValueAsString(Optional.of(requestDto.getSeason()).map(SeasonDto::getSeasonImgUrls).orElse(null)))
                    .id(requestDto.getSeason().getProgram().getId())
                    .keywords(Arrays.asList(requestDto.getSeason().getProgram().getKeywords().split(",")))
                    .parentalRating(requestDto.getSeason().getProgram().getParentalRating())
                    .description(requestDto.getSeason().getProgram().getDescription())
                    .languages(Arrays.asList(requestDto.getSeason().getProgram().getLanguages().split(" ")))
                    .startDate(requestDto.getSeason().getProgram().getStartDate())
                    .expiryDate(requestDto.getSeason().getProgram().getExpiryDate())
                    .creationDate(requestDto.getSeason().getProgram().getCreationDate())
                    .imgUrls(mapper.writeValueAsString(requestDto.getSeason().getProgram().getImgUrls()))
                    .type(requestDto.getSeason().getProgram().getType())
                    .name(requestDto.getSeason().getProgram().getName())
                    .crewListJson(mapper.writeValueAsString(requestDto.getCrewList()))
                    .categoriesList(new ArrayList<>()).build();

            Category category = requestDto.getSeason().getProgram().getCategory();
            if (category != null) {
                do {
                    video.getCategoriesList().add(category.getCategoryName());
                    category = category.getParent();
                } while (null != category);
            }
            StringBuilder pathVariable = new StringBuilder();
            pathVariable.append("home/");
            Collections.reverse(video.getCategoriesList());
            for (String s : video.getCategoriesList()) {
                pathVariable.append(s + "/");
            }
            video.setPath(pathVariable.toString());
            video.getCategoriesList().add("home");
            videoRepository.save(video);
            videoList.add(video);
        }
        // List<Video> videoListResponse = new ArrayList<>();
        //videoRepository.saveAll(videoList).forEach(videoListResponse::add);
        return videoList;
    }

    //    @Override
//    public Video getByProgramId(String programId) {
//        return videoRepository.findByProgramId(programId);
//    }
}

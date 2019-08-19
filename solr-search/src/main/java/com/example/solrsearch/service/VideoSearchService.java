package com.example.solrsearch.service;

import com.example.solrsearch.dto.Program;
import com.example.solrsearch.dto.RequestDto;
import com.example.solrsearch.dto.SingleVideoDto;
import com.example.solrsearch.dto.VideoResponse;
import com.example.solrsearch.entity.Video;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface VideoSearchService {
    Video addVideos(Program programList) throws JsonProcessingException;

    Page<Video> getAllVideos(int pageNumber, int pageSize);

    boolean deleteAll();

    Map<String,Page<VideoResponse>> search(String searchTerm, String videoType, String categoryFilter, int pageNumber, int pageSize) throws Exception;

    Video update(Video video);

    //Video getByProgramId(String programId);

    Map<String,Page<VideoResponse>> autoSuggest(String word, int pageNumber, int pageSize) throws Exception;

    boolean deleteById(String id);

    Video addSingleVideo(SingleVideoDto singleVideoDto) throws JsonProcessingException;

    List<Video> addEpisodeVideo(List<RequestDto> requestDtoList) throws JsonProcessingException;
}

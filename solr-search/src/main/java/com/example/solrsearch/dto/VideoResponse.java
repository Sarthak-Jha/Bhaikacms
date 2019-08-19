package com.example.solrsearch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoResponse {

    private List<String> keywords;
    private Map<String, String> crewList;
    private List<String> languages;
    private String description;
    private String type;
    private String id;
    private String name;
    private List<String> categoriesList;
    private List<String> autocomp;
    private String path;
    private Map<String, String> imgUrls;
    private Long startDate;
    private Long expiryDate;
    private Long creationDate;
    private String parentalRating;
    private String seasonName;
    private Map<String, String> episodeImageUrls;
    private String seasonId;
    private Integer seasonNumber;
    private String seasonDescription;
    private Map<String, String> seasonImgUrls;
    private Integer episodeNumber;
    private String episodeTitle;
    private String episodeDescription;
    private String episodeId;


}
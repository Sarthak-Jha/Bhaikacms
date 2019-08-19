package com.example.solrsearch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {


    private String id;
    private Integer episodeNumber;
    private String episodeTitle;
    private String episodeDescription;
    private Map<String, String> episodeImageUrls;
    private String episodeVideoUrls;
    private Map<String, String> crewList;

    private SeasonDto season;
}

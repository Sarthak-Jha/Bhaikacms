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
public class SeasonDto {


    private String id;
    private Integer seasonNumber;
    private String seasonDescription;
    private String seasonName;
    private Map<String, String> seasonImgUrls;

    private Program program;
}

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
public class SingleVideoDto {

    Program program;
    private String id;
    private String videoTitle;
    private String videoUrl;
    private String description;
    private Map<String, String> videoUrls;
    private Map<String, String> crewList;

}

package com.example.solrsearch.dto;

import com.example.solrsearch.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Program {

    private String keywords;
    private Map<String, String> crewList;
    private String languages;
    private String description;
    private String type;
    private String id;
    private String name;
    private Category category;
    private String parentalRating;
    private Long startDate;
    private Long expiryDate;
    private Long creationDate;
    private Map<String, String> imgUrls;

}

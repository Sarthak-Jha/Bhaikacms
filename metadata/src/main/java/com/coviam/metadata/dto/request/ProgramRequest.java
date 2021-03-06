package com.coviam.metadata.dto.request;

import com.coviam.metadata.entity.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@Getter
@Setter
@Builder
public class ProgramRequest implements Serializable {

    private String id;

    // 1->single video, 2->multi 3->seasonal
    private String type;

    private String description;

    // @Size(min = 2)
    private String name;

    private String parentalRating;

    // we will store keywords as space separated values
    private String keywords;

    // We will languages as space separated values
    private String languages;

    @NotNull
    private Long startDate;

    private Long expiryDate;

    private Boolean isAlive;

    // to store which user has uploaded this file
    private String userId;

    private Category category;

    private Map<String, String> imgUrls = new HashMap<>();

    private Map<String, String> crewList = new HashMap<>();


    private Long creationDate;
    private String userEmail;

}

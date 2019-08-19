package com.example.solrsearch.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Dynamic;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "episode")
@Builder
public class Video {

    @Indexed(stored = true, searchable = true, type = "keywords", value = "keywords")
    private List<String> keywords;
    @Dynamic
    @Indexed(value = "crewList_*", type = "searchableName", copyTo = "crewListCopy")
    private Map<String, String> crewList;
    @Indexed(stored = true, searchable = true, type = "languages", value = "programLanguages")
    private List<String> languages;
    @Indexed(stored = true, searchable = true, type = "description", value = "programDescription")
    private String description;
    @Indexed(stored = true, searchable = true, type = "videotype", value = "programType")
    private String type;
    @Indexed(stored = true, value = "programId")
    private String id;
    @Indexed(stored = true, searchable = true, type = "name", value = "programName")
    private String name;
    @Indexed(stored = true, searchable = true, type = "categoryList", value = "categoriesList")
    private List<String> categoriesList;
    @Indexed(stored = true, searchable = true, type = "searchableName")
    private List<String> crewListCopy;
    @Indexed(stored = true, searchable = true, type = "autocomp")
    private List<String> autocomp;
    @Indexed(stored = true, searchable = true, type = "searchableName")
    private String path;
    @Indexed(stored = true, value = "imageUrls", type = "serachableName")
    private String imgUrls;
    @Indexed(stored = true, value = "programStartDate")
    private Long startDate;
    @Indexed(stored = true, value = "programExpiryDate")
    private Long expiryDate;
    @Indexed(stored = true, value = "programCreationDate")
    private Long creationDate;
    @Indexed(stored = true, value = "programParentalRating")
    private String parentalRating;
    @Indexed(stored = true, value = "seasonName")
    private String seasonName;
    @Indexed(stored = true, value = "episodeImageUrl")
    private String episodeImageUrls;
    @Indexed(stored = true, value = "seasonId")
    private String seasonId;


    @Indexed(stored = true)
    private Integer seasonNumber;
    @Indexed(stored = true)
    private String seasonDescription;
    @Indexed
    private String seasonImgUrls;
    @Indexed(stored = true)
    private Integer episodeNumber;
    @Indexed(stored = true, value = "episodeName")
    private String episodeTitle;
    @Indexed(stored = true, value = "episodeDescription")
    private String episodeDescription;
    @Id
    @Indexed(value = "id")
    private String episodeId;
    @Indexed(type = "string")
    private String crewListJson;


}
//./server/scripts/cloud-scripts/zkcli.sh -zkhost 127.0.0.1:9983 -cmd upconfig -confname video_config2 -confdir server/solr/configsets/_default/conf
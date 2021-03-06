package com.example.solrsearch.repository;

import com.example.solrsearch.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomRepository {

    Page<Video> search(String searchTerm, String videoType, String categoryFilter, Pageable var1);

    //Page<Video> searchContaining(String searchterm, Pageable var);
    Page<Video> getAllVideos(Pageable var);

    Page<Video> autoSuggest(String searchTerm, int pageNumber, int pageSize);
}

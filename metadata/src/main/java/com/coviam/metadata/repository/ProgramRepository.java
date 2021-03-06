package com.coviam.metadata.repository;

import com.coviam.metadata.entity.Program;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, String> {

    Page<Program> findByType(String type, Pageable pageable);


    Page<Program> findByExpiryDateLessThan(Long expiryDate, Pageable page);


    Page<Program> findByStartDateLessThan(Long currentDate, Pageable page);


    //Added  by sunil
    Page<Program> findByTypeOrderByNameAsc(String type, Pageable page);

    Page<Program> findByTypeOrderByNameDesc(String type, Pageable page);

    Page<Program> findByTypeOrderByCreationDateDesc(String type, Pageable page);

    Page<Program> findByTypeOrderByCreationDateAsc(String type, Pageable page);

    //filter
    Page<Program> findByNameOrderByNameAsc(String type, Pageable page);

    Page<Program> findByLanguagesOrderByNameAsc(String type, Pageable page);


    Long countByTypeIgnoreCaseStartsWith(String type);


}

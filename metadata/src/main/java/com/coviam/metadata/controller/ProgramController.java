package com.coviam.metadata.controller;

import com.coviam.metadata.dto.request.DeleteRequest;
import com.coviam.metadata.dto.request.ProgramRequest;
import com.coviam.metadata.dto.response.EmailResponse;
import com.coviam.metadata.entity.Program;
import com.coviam.metadata.services.ProgramServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/metadata")
@CrossOrigin
public class ProgramController {

    @Autowired
    private ProgramServices programServices;

    @PutMapping("/addProgram")
    public ResponseEntity<Program> addProgram(@RequestBody ProgramRequest programRequest) {
        return ResponseEntity.ok(programServices.addProgram(programRequest));
    }

    @PutMapping("/editProgram")
    public ResponseEntity<Boolean> editProgram(@RequestBody ProgramRequest programRequest) {
        return ResponseEntity.ok(programServices.editProgram(programRequest));
    }


    @PostMapping("/deleteProgramById")
    public ResponseEntity<Boolean> deleteProgramById(@RequestBody DeleteRequest deleteRequest) {
        return ResponseEntity.ok(programServices.deleteProgramById(deleteRequest));
    }

    @GetMapping(value = "/getProgramById")
    public ResponseEntity<Program> getProgramById(@RequestParam(name = "programId") String programId) {
        return ResponseEntity.ok(programServices.getProgramById(programId));
    }

    // todo optimise getAll{ProgramType}

    @GetMapping(value = "/getAllSingleVideoProgram")
    public ResponseEntity<Page<Program>> getAllSingleVideoProgram(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {

        return ResponseEntity.ok(programServices
                .getAllSingleVideoProgram(pageNumber, pageSize));
    }


    @GetMapping(value = "/getAllSeasonalVideoProgram")
    public ResponseEntity<Page<Program>> getAllSeasonalVideoProgram(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {

        return ResponseEntity.ok(programServices
                .getAllSeasonalVideoProgram(pageNumber, pageSize));
    }

    @GetMapping(value = "/getAllMultiVideoProgram")
    public ResponseEntity<Page<Program>> getAllMultiVideoProgram(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {

        return ResponseEntity.ok(programServices
                .getAllMultiVideoProgram(pageNumber, pageSize));
    }

    @GetMapping(value = "/getExpiredVideoList")
    public ResponseEntity<Optional<List<EmailResponse>>> getExpiredVideos() {
        return ResponseEntity.ok(Optional.of(programServices.sendExpiredToEmail()));
    }

    @GetMapping(value = "/getAboutToExpire")
    public ResponseEntity<Optional<List<EmailResponse>>> getAboutToExpire() {
        return ResponseEntity.ok(Optional.of(programServices.sendAboutToExpire()));
    }

    @RequestMapping(path = "/addProgramByBulk", method = RequestMethod.POST)
    public ResponseEntity<List<Program>> addProgramByBulk(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String uploadingDir = System.getProperty("user.dir") + "/src/FileUpload/";
        log.error(multipartFile.getOriginalFilename());
        log.info(multipartFile.getOriginalFilename());
        File file = new File(uploadingDir + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        List<Program> programList = programServices.addProgramByBulkUpload(file);
        return ResponseEntity.ok(programList);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count(
            @RequestParam(name = "programType", required = false) String type) {

        log.info("Count for Program type : {} ", type);
        return ResponseEntity.ok(programServices.countByType(type));
    }
}
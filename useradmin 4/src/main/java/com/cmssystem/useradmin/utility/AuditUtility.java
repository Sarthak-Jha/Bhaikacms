package com.cmssystem.useradmin.utility;

import com.cmssystem.useradmin.dto.AuditRequestDto;
import com.cmssystem.useradmin.dto.Change;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
public class AuditUtility {


    private void callAudit(AuditRequestDto auditRequest) {
        RestTemplate restTemplate = new RestTemplate();
        String auditServiceUrl = "http://10.177.7.38:8082";
        Boolean response = restTemplate.postForObject(auditServiceUrl + "/audit/addAudit", auditRequest, Boolean.class);
    }

    public void addAudit(String userName, String userEmail, String modifierEmail, List<Change> changes) {

        AuditRequestDto auditRequestDto = AuditRequestDto.builder()
                .asset(userName)
                .assetId(userEmail)
                .action("ADDED")
                .modifier(modifierEmail)
                .changes(changes)
                .flag(1)
                .build();

        callAudit(auditRequestDto);
    }

    public void deleteAudit(String userName, String userEmail, String modifierEmail, List<Change> changes) {

        AuditRequestDto auditRequestDto = AuditRequestDto.builder()
                .asset(userName)
                .assetId(userEmail)
                .action("DELETED")
                .modifier(modifierEmail)
                .changes(changes)
                .flag(1)
                .build();

        callAudit(auditRequestDto);
    }


    public void editAudit(String userName, String userEmail, String modifierEmail, List<Change> changes) {
        AuditRequestDto auditRequestDto = AuditRequestDto.builder()
                .asset(userName)
                .assetId(userEmail)
                .action("EDITED")
                .modifier(modifierEmail)
                .changes(changes)
                .flag(1)
                .build();

        callAudit(auditRequestDto);

    }
}
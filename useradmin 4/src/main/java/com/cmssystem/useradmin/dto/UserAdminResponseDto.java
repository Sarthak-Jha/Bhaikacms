package com.cmssystem.useradmin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAdminResponseDto {

    private String email;
    private String name;
    private int roleId;
    private boolean isActive;
}

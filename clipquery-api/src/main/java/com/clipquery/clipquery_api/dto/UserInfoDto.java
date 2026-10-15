package com.clipquery.clipquery_api.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private String email;
    private LocalDateTime createdAt;
}

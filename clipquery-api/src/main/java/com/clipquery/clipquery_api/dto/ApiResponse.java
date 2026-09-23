package com.clipquery.clipquery_api.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> error(String message, String status) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .build();
    }
}

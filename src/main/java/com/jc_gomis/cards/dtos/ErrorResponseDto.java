package com.jc_gomis.cards.dtos;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMsg;
    private LocalDateTime errorTime ;
}

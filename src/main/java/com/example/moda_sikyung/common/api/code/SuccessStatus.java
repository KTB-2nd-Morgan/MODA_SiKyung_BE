package com.example.moda_sikyung.common.api.code;

import static org.springframework.http.HttpStatus.OK;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode{
    SUCCESS(OK, "200", "성공"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "204", "콘텐츠 없음");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public Reason getReason() {
        return Reason.builder()
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public Reason getReasonHttpStatus() {
        return Reason.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}

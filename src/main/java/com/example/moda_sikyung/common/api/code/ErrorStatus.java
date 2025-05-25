package com.example.moda_sikyung.common.api.code;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 서버 오류
    _INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "COMMON500_1", "서버 에러, 서버 개발자에게 문의 바랍니다."),
    _BAD_REQUEST(BAD_REQUEST, "COMMON400_1", "잘못된 요청입니다."),
    _UNAUTHORIZED(UNAUTHORIZED, "COMMON401_1", "로그인이 필요합니다."),
    _FORBIDDEN(FORBIDDEN, "COMMON403_1", "금지된 요청입니다."),
    _TOO_MANY_REQUESTS(TOO_MANY_REQUESTS, "COMMON429_1", "요청이 너무 많습니다. 잠시 후 다시 시도해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public Reason getReason() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public Reason getReasonHttpStatus() {
        return Reason.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}

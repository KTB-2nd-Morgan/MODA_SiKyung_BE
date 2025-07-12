package com.example.moda_sikyung.common.api;

import com.example.moda_sikyung.common.api.code.BaseCode;
import com.example.moda_sikyung.common.api.code.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@JsonPropertyOrder({ "isSuccess", "code", "message", "data" })
public record CommonResponse<T> (
    @JsonProperty("isSuccess") Boolean isSuccess,
    @JsonProperty("code") String code,
    @JsonProperty("message") String message,
    @JsonProperty("data") T data
) {
    // JSON 형태로 이쁘게 출력하도록 toString() 오버라이드
    @Override
    public String toString() {
        try {
            var mapper = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // 성공 응답 (200)
    public static <T> CommonResponse<T> onSuccess(T data) {
        return new CommonResponse<>(true,
                SuccessStatus.SUCCESS.getCode(),
                SuccessStatus.SUCCESS.getMessage(),
                data);
    }

    // 성공 + 커스텀 코드
    public static <T> CommonResponse<T> of(BaseCode code, T data) {
        return new CommonResponse<>(true,
                code.getReasonHttpStatus().getCode(),
                code.getReasonHttpStatus().getMessage(),
                data);
    }

    // 204 No Content
    public static <T> CommonResponse<T> onNoContent() {
        return new CommonResponse<>(true,
                SuccessStatus.NO_CONTENT.getCode(),
                SuccessStatus.NO_CONTENT.getMessage(),
                null);
    }

    // 실패 응답 (직접 코드/메시지)
    public static <T> CommonResponse<T> onFailure(String code, String message, T data) {
        return new CommonResponse<>(false, code, message, data);
    }

    // 실패 응답 (BaseCode)
    public static <T> CommonResponse<T> onFailure(BaseCode code, T data) {
        return new CommonResponse<>(false,
                code.getReasonHttpStatus().getCode(),
                code.getReasonHttpStatus().getMessage(),
                data);
    }
}

package com.example.moda_sikyung.common.exception;

import com.example.moda_sikyung.common.api.code.BaseCode;
import com.example.moda_sikyung.common.api.code.Reason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseCode code;

    public Reason getErrorReason() {
        return this.code.getReason();
    }

    public Reason getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}

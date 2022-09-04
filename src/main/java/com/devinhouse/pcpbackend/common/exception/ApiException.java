package com.devinhouse.pcpbackend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;

public class ApiException extends ResponseStatusException {

    public ApiException(HttpStatus status) {
        super(status);
    }

    public ApiException(HttpStatus status, String msg) {
        super(status, msg);
    }

    public ApiException(String msg, HttpStatus status) {
        super(status, msg);
    }

    public ApiException(HttpStatus status, String msg, Throwable cause) {
        super(status, msg, cause);
    }

    public ApiException(int rawStatusCode, String msg, Throwable cause) {
        super(rawStatusCode, msg, cause);
    }

    public static ApiException entityNotFoundException(String entity, String id) {
        return new ApiException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND_BY_ID, entity, id), HttpStatus.NOT_FOUND);
    }

    public static ApiException entityNotFoundException(String entity) {
        return new ApiException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND, entity), HttpStatus.NOT_FOUND);
    }

    public static ApiException badRequestException(String msg) {
        return new ApiException(msg, HttpStatus.BAD_REQUEST);
    }

    public static ApiException notPermittedException(String msg) {
        return new ApiException(msg, HttpStatus.FORBIDDEN);
    }

    public static ApiException missingParameterException(String parameter) {
        return new ApiException(DefaultMessageHelper.getMessage(DefaultMessageConstants.MISSING_PARAMETER, parameter), HttpStatus.FORBIDDEN);
    }
}

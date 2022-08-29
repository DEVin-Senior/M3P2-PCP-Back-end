package com.devinhouse.pcpbackend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
        return new ApiException(String.format("Entity '%s' with id = '%s' not found", entity, id), HttpStatus.NOT_FOUND);
    }

    public static ApiException entityNotFoundException(String entity) {
        return new ApiException(String.format("Entity '%s' not found", entity), HttpStatus.NOT_FOUND);
    }

    public static ApiException badRequestException(String msg) {
        return new ApiException(msg, HttpStatus.BAD_REQUEST);
    }

    public static ApiException notPermittedException(String msg) {
        return new ApiException(msg, HttpStatus.FORBIDDEN);
    }

    public static ApiException missingParameterException(String parameter) {
        return new ApiException(String.format("Parameters [%s] is missing.", parameter), HttpStatus.FORBIDDEN);
    }
}

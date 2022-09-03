package com.devinhouse.pcpbackend.common.exception;

import java.io.Serial;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;

/**
 * Classe para lançamento de exceções padrões na camada de Serviço.
 * <p>
 * Poderá ser utilizada também para lançamento de exceções referente a regra de negócio na camada de Serviço.
 */
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static ServiceException entityNotFoundException(String entity){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND, entity));
    }

    public ServiceException entityNotFoundByIdException(String entity, String id){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND_BY_ID, entity, id));
    }

    public ServiceException missingParameterException(String parameter){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.MISSING_PARAMETER, parameter));
    }

    public ServiceException fieldIsRequiredException(String field){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.FIELD_IS_REQUIRED, field));
    }

    public ServiceException errorPersistDataException(String data){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ERROR_PERSIST_DATA, data));
    }

    public ServiceException errorUpdateDataException(String data){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ERROR_UPDATE_DATA, data));
    }

    public ServiceException errorDeleteDataException(String data){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ERROR_DELETE_DATA, data));
    }

    public ServiceException errorDeleteDataByIdException(String data){
        return new ServiceException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ERROR_DELETE_DATA_BY_ID, data));
    }

}

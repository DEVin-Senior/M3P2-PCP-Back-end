package com.devinhouse.pcpbackend.common.constants;

/**
 * Classe de enumerados com mensagens padrões para uso no lançamento de exceções.
 */
public enum DefaultMessageConstants {

    ENTITY_NOT_FOUND("Entity '%s' not found"),
    ENTITY_NOT_FOUND_BY_ID("Entity '%s' with id = '%s' not found"),
    MISSING_PARAMETER("Parameters [%s] is missing."),
    FIELD_IS_REQUIRED("Field '%s' is required"),
    SECURITY_CONFIGURATION_ERROR("Erro na configuração de segurança"),
    ERROR_CREATE_OBJECT("Erro ao criar o %s. Causa: %s"),
    ERROR_PERSIST_DATA("Erro ao salvar o %s no banco de dados. Causa: %s"),
    ERROR_UPDATE_DATA("Erro ao atualizar o %s no banco de dados. Causa: %s"),
    ERROR_DELETE_DATA("Erro ao deletar o %s no banco de dados. Causa: %s"),
    ERROR_DELETE_DATA_BY_ID("Erro ao deletar o %s com ID '%s' no banco de dados. Causa: %s");

    private final String message;

    DefaultMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.devinhouse.pcpbackend.common.constants;

/**
 * Classe de enumerados com mensagens padrões para uso no lançamento de exceções.
 */
public enum DefaultMessageConstants {

    ENTITY_NOT_FOUND("Entity '%s' not found"),
    ENTITY_NOT_FOUND_BY_ID("Entity '%s' with id = '%s' not found."),
    MISSING_PARAMETER("Parameters [%s] is missing."),
    FIELD_IS_REQUIRED("Field '%s' is required"),
    SECURITY_CONFIGURATION_ERROR("Erro na configuração de segurança"),
    ERROR_CREATE_OBJECT("Erro ao criar o %s. Causa: %s"),
    ERROR_PERSIST_DATA("Erro ao salvar o %s no banco de dados. Causa: %s"),
    ERROR_UPDATE_DATA_BY_ID("Erro ao atualizar o %s com ID %s no banco de dados. Causa: %s"),
    ERROR_DELETE_DATA_BY_ID("Erro ao deletar o %s com ID '%s' no banco de dados. Causa: %s"),
    TEACHER_ID_IS_NOT_A_NUMBER ("Id do docente informado não é um número"),
	ERROR_PROCESSING_EVENT("Erro ao processar evento"),
	CLASS_NOT_FOUND("Turma não encontrada com o ID informado."),
	CLASS_ALREADY_EXISTS_WITH_GIVEN_NAME("Já existe uma turma cadastrada com este nome.");

    private final String message;

    DefaultMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

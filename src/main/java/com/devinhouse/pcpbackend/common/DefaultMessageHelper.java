package com.devinhouse.pcpbackend.common;

import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;

public class DefaultMessageHelper {

    private DefaultMessageHelper() {
    }

    /**
     * Método que busca a mensagem de uma enumeração DefaultMessageConstants.
     *
     * @param defaultMessage mensagem padrão.
     * @param params Parâmetros a serem adicionados na mensagem.
     * @return Mensagem da enumeração formatada.
     */
    public static String getMessage(DefaultMessageConstants defaultMessage, Object... params) {
        if (defaultMessage == null) {
            return null;
        }

        return String.format(defaultMessage.getMessage(), params);
    }

}

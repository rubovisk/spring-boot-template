package com.rubensmello.demo.infra.exception;

public class BadRequestException extends AppRuntimeException {

    public static final String MSG_GENERICA = "Requisição inválida.";
    public static final String MSG_ID_NAO_ENCONTRADO = "Não foi encontrado registro com o ID informado.";
    public static final String MSG_SENHA_CURTA = "A senha deve conter pelo pelo 8 caracteres.";
    public static final String MSG_SENHA_FRACA = "A senha deve conter letras maiúsculas, minúsculas, números e caracteres especiais.";

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}

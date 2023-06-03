package com.sisrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class MatriculaEmUsoException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final HttpStatus status = HttpStatus.CONFLICT;

    public MatriculaEmUsoException(long matricula) {
        super(String.format("Matrícula %s já está cadastrado", matricula));
    }

    public HttpStatus getStatus() {
        return status;
    }
}

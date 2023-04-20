package com.sisrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmailEmUsoException extends Exception {

    private static final long serialVersionUID = 1L;
    private static final HttpStatus status = HttpStatus.CONFLICT;

    public HttpStatus getStatus() {
        return status;
    }

    public EmailEmUsoException(String email) {
        super(String.format("Email %s já está cadastrado", email));
    }
}

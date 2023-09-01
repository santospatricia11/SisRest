package com.sisrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class PedidoDeAcessoJaAnalisadoException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final HttpStatus status = HttpStatus.CONFLICT;

    public PedidoDeAcessoJaAnalisadoException(long pedido) {
        super(String.format("Pedido de acesso %s já foi analisado!", pedido));
    }

    public HttpStatus getStatus() {
        return status;
    }
}

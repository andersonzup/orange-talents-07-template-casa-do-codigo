package br.com.zup.casadocodigo.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectAppNotFoundException extends Exception {
    public ObjectAppNotFoundException(Long id) {
        super("Não foi encontrado um objeto com o id" + id);
    }
}

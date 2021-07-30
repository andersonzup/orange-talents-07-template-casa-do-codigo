package br.com.zup.casadocodigo.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstadoExistenteException extends Throwable {
    public EstadoExistenteException(@NotBlank String nome) {
        super("Já existe um estado com o nome " + nome);
    }
}

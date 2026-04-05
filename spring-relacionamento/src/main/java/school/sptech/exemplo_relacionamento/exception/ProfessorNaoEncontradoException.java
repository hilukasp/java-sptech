package school.sptech.exemplo_relacionamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorNaoEncontradoException extends RuntimeException {

    public ProfessorNaoEncontradoException(Integer id) {
        super("Professor com id %d não encontrado".formatted(id));
    }
}

package school.sptech.exemplo_relacionamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CursoNaoEncontradoException extends RuntimeException {

    public CursoNaoEncontradoException(Integer id) {
        super("Curso com id %d não encontrado".formatted(id));
    }
}

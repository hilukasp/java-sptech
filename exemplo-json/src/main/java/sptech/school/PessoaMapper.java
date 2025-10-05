package sptech.school;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PessoaMapper {

    public List<Pessoa> mapearPessoas(InputStream inputStream) throws IOException {
        // Cria objeto base para mapear o JSON
        // Utilizando a biblioteca Jackson
        ObjectMapper objectMapper = new ObjectMapper();

        // objectMapper.readValue() tem 2 parametros:
        // 1. arquivo a ser mapeado (inputStream)
        // 2. o tipo de objeto para o qual o json sera mapeado
        // no caso, uma lista de Pessoas
        List<Pessoa> pessoasDoJson = objectMapper.readValue(
                inputStream, new TypeReference<List<Pessoa>>() {
                });
        return pessoasDoJson;

    }
}

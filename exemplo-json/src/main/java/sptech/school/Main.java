package sptech.school;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Le um arquivo JSON, trata os dados e importa para um List
    public static void main(String[] args) {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("pessoas.json");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }

        PessoaMapper pessoaMapper = new PessoaMapper();
        List<Pessoa> listaPessoas = new ArrayList<>();
        try {
            // Mapeia o JSON para um lista de Pessoas
            listaPessoas = pessoaMapper.mapearPessoas(inputStream);
        } catch (IOException erro) {
            System.out.println("Erro ao mapear o json");
            erro.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            }  catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo json");
            }

        }

        // Exibe a lista de pessoas
        for (Pessoa p : listaPessoas) {
            System.out.println(p);
        }


    }
}

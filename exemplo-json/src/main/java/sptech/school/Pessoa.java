package sptech.school;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Ignora propriedades desconhecidas
// Vai ignorar "idade" do arquivo json
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pessoa  {
    // Mapeia o campo "name" do JSON para o atributo "nome"
    @JsonProperty("name")
    private String nome;

    // Mapeia o campo "document" do JSON para o atributo "cpf"
    @JsonProperty("document")
    private String cpf;

    // Construtor vazio
    public Pessoa() {

    }

    // Construtor cheio
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // toString()
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

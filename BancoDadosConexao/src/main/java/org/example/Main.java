package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DatabaseConfiguration connection = new DatabaseConfiguration();
        JdbcTemplate con = new JdbcTemplate(connection.getDataSource());

        criarTabela(con);
        inserirDadosIniciais(con);
        inserirTime(con, "Palmeiras", 20);
        listarTimes(con);
        listarTimesComoObjetos(con);
        atualizarTime(con, "Ponte Preta", 1);
        deletarTime(con, 1);
        buscarTime(con,"Palmeiras");
    }

    // ---------------- Métodos auxiliares ----------------

    // Cria a tabela Time, se não existir
    public static void criarTabela(JdbcTemplate con) {
        con.execute("""
                CREATE TABLE IF NOT EXISTS Time(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(100),
                    qtdJogadores INT
                );
                """);
        System.out.println("Tabela 'Time' verificada/criada com sucesso!");
    }

    // Insere alguns registros iniciais
    public static void inserirDadosIniciais(JdbcTemplate con) {
        con.update("INSERT INTO Time (nome, qtdJogadores) VALUES ('Vasco', 20), ('Santos', 40);");
        System.out.println("Times iniciais inseridos!");
    }

    // Insere um novo time com parâmetros
    public static void inserirTime(JdbcTemplate con, String nome, int qtdJogadores) {
        String sql = "INSERT INTO Time (nome, qtdJogadores) VALUES (?, ?)";
        con.update(sql, nome, qtdJogadores);
        System.out.println("Time inserido: " + nome);
    }

    // Lista todos os times como Map (chave-valor)
    public static void listarTimes(JdbcTemplate con) {
        List<?> times = con.queryForList("SELECT * FROM Time;");
        System.out.println("Exibindo times (queryForList):");
        System.out.println(times);
    }

    // Lista os times mapeando para objetos da classe Time
    public static void listarTimesComoObjetos(JdbcTemplate con) {

        //O objeto BeanPropertyRowMapper é responsável por mapear cada linha da tabela a um objeto da classe Time
        //select só que armazenando ele em um objeto do java
        List<Time> listaTimes = con.query(
                "SELECT * FROM Time;",
                new BeanPropertyRowMapper<>(Time.class)
        );

        System.out.println("Exibindo objetos de Times:");
        for (Time t : listaTimes) {
            System.out.println(t);
        }
    }

    // Atualiza o nome de um time pelo id
    public static void atualizarTime(JdbcTemplate con, String novoNome, int id) {
        String sql = "UPDATE Time SET nome = ? WHERE id = ?";
        con.update(sql, novoNome, id);
        System.out.println("Time com id " + id + " atualizado para " + novoNome);
    }

    // Deleta um time pelo id
    public static void deletarTime(JdbcTemplate con, int id) {
        String sql = "DELETE FROM Time WHERE id = ?";
        con.update(sql, id);
        System.out.println("Time com id " + id + " deletado!");
    }


    public static void buscarTime(JdbcTemplate con, String nome){
        String sql= "SELECT *  FROM Time WHERE nome like ?";
        List<Time> time = con.query(sql,new BeanPropertyRowMapper<>(Time.class),  "%"+nome+"%");
        System.out.println(time);
    }
}
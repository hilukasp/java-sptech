package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // Cria um objeto da classe Connection
        // Esse objeto será usado para fazer a conexão com o SGB
        DatabaseConfiguration connection = new DatabaseConfiguration();
        JdbcTemplate con = new JdbcTemplate(connection.getDataSource());

        // Criar tabela Time caso não exista
        con.execute("""
                CREATE TABLE IF NOT EXISTS Time(
                id INT PRIMARY KEY AUTO_INCREMENT,
                nome VARCHAR(100),
                qtdJogadores INT
                );
                """);


        // Insert
        con.update("INSERT INTO Time (nome, qtdJogadores) VALUES" +
                "('Vasco', 20)," +
                "('Santos', 40);"   );
        String time = "Palmeiras";
        Integer jogadores = 20;
        String sqlInsert = "INSERT INTO Time (nome, qtdJogadores) VALUES (?,?)";
        con.update(sqlInsert, time, jogadores);

        //select
        List times = con.queryForList("SELECT * FROM Time;");
        System.out.println(times);

        //O objeto BeanPropertyRowMapper é responsável por mapear cada linha da tabela a um objeto da classe Time
        //select só que armazenando ele em um objeto do java
        List<Time> listaTimes = con.query("SELECT * FROM Time;", new BeanPropertyRowMapper(Time.class));
        System.out.println("Exibindo objetos de Times");
        for(Time list:listaTimes){
            System.out.println(list);
        }
    }



}
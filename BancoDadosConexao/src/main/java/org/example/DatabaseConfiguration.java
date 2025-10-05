package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfiguration {
    private BasicDataSource dataSource;

    public DatabaseConfiguration() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");  // especifica que vai usar o driver do H2
        dataSource.setUrl("jdbc:h2:file:./time-bd");     // URL para conexão com o H2 (meu_banco é o nome do database)
        dataSource.setUsername("sa");                    // nome do usuário do banco
        dataSource.setPassword("");                      // senha do usuário do banco

        //CONEXÃO COM MYSQL
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3360//nome-do-banco");
//        dataSource.setUsername("seu-usuario");
//        dataSource.setPassword("sua-senha");
    }

    public BasicDataSource getDataSource(){
        return dataSource;
    }

}

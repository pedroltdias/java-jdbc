package br.com.github.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('PRODUTO2', 'DESCRICAO2')");

//        ResultSet generatedKeys = stm.executeQuery("SELECT last_insert_rowid()");
//
//        Integer lastId = generatedKeys.getInt("ID");
//
//        System.out.println(lastId);

        connection.close();
    }
}

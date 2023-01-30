package br.com.github.jdbc.test;

import br.com.github.jdbc.factory.ConnectionFactory;

import java.sql.SQLException;

public class TestaPoolConexoes {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++){
            connectionFactory.recuperarConexao();
            System.out.println("Conexao n " + (i+1));
        }
    }
}

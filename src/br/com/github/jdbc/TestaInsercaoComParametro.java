package br.com.github.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperarConexao();)
        {
            connection.setAutoCommit(false); //remove o poder de commit do jdbc e retoma para si(desenvolvedor)

            try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)");) {
                adicionarVariavel("PRODUTO7", "DESCRICAO7", stm);
                adicionarVariavel("PRODUTO8", "DESCRICAO8", stm);

                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[ROOLBACK]");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();
    }
}

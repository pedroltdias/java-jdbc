package br.com.github.jdbc;

import java.sql.*;

public class TestaListagem {
    public static void main(String args[]) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            System.out.println("PRODUTO:" +
                    "\n ID: " + id +
                    "\n NOME: " + nome +
                    "\n DESCRICAO: " + descricao
            );
        }

        con.close();
    }
}

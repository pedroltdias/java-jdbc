package br.com.github.jdbc;

import br.com.github.jdbc.dao.ProdutoDAO;
import br.com.github.jdbc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercaoComProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Mouse", "Mouse Gamer");

        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(produto);
    }
}

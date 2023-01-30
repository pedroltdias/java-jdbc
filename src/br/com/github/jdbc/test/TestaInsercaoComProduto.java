package br.com.github.jdbc.test;

import br.com.github.jdbc.dao.ProdutoDAO;
import br.com.github.jdbc.factory.ConnectionFactory;
import br.com.github.jdbc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaInsercaoComProduto {
    public static void main(String[] args) {
        Produto novoProduto = new Produto("Mouse", "Mouse Gamer");

        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvarProduto(novoProduto);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("[NOVO PRODUTO]: " + novoProduto);
    }
}

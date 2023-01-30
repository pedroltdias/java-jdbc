package br.com.github.jdbc.test;

import br.com.github.jdbc.dao.ProdutoDAO;
import br.com.github.jdbc.factory.ConnectionFactory;
import br.com.github.jdbc.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemComDAOeProduto {
    public static void main(String[] args) {
        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);

            List<Produto> produtos = produtoDAO.listarProduto();
            for (Produto produto : produtos) {
                System.out.println("[LISTANDO PRODUTO]... " + produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

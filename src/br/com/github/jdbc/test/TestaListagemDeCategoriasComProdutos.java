package br.com.github.jdbc.test;

import br.com.github.jdbc.dao.CategoriaDAO;
import br.com.github.jdbc.factory.ConnectionFactory;
import br.com.github.jdbc.model.Categoria;
import br.com.github.jdbc.model.Produto;

import java.sql.Connection;
import java.util.List;

public class TestaListagemDeCategoriasComProdutos {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();

            listaDeCategorias.forEach(cat -> {
                for(Produto produto : cat.getProdutos()){
                    System.out.println("[LISTANDO CATEGORIA]... " + cat.getNome() + " - " + produto.getNome());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

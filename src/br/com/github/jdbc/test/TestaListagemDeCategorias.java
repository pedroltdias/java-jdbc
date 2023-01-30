package br.com.github.jdbc.test;

import br.com.github.jdbc.dao.CategoriaDAO;
import br.com.github.jdbc.factory.ConnectionFactory;
import br.com.github.jdbc.model.Categoria;

import java.sql.Connection;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();

            listaDeCategorias.forEach(cat -> System.out.println("[LISTANDO CATEGORIA]... " + cat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

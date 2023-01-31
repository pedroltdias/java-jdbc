package br.com.github.jdbc.dao;

import br.com.github.jdbc.model.Categoria;
import br.com.github.jdbc.model.Produto;

import java.lang.module.ResolutionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List<Categoria> listar(){
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM CATEGORIA";

        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Categoria categoria = new Categoria(rst.getInt("ID"), rst.getString("NOME"));

                    categorias.add(categoria);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public List<Categoria> listarComProdutos(){
        Categoria ultima = null;
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C " +
                "JOIN PRODUTO P ON P.CATEGORIA_ID = C.ID";

        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    if(ultima == null || !ultima.getNome().equals(rst.getString("NOME"))) {
                        Categoria categoria = new Categoria(rst.getInt("ID"), rst.getString("NOME"));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto = new Produto(rst.getString(4), rst.getString(5));
                    produto.setId(rst.getInt(3));

                    ultima.adicionarProduto(produto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categorias;
    }
}

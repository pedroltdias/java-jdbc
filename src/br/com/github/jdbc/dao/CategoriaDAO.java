package br.com.github.jdbc.dao;

import br.com.github.jdbc.model.Categoria;

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
}

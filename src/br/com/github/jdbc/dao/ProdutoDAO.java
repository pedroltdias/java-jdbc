package br.com.github.jdbc.dao;

import br.com.github.jdbc.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvarProduto(Produto produto){
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try(ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();

        try(PreparedStatement pstm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")) {
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()) {
                while(rst.next()) {
                    Integer id = rst.getInt("ID");
                    String nome = rst.getString("NOME");
                    String descricao = rst.getString("DESCRICAO");

                    Produto produto = new Produto(nome,descricao);
                    produto.setId(id);

                    produtos.add(produto);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return produtos;
    }
}

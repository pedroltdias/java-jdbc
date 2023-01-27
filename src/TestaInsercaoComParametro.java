import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        String nome = "PRODUTO3";
        String descricao = "DESCRICAO3";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)");

        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        connection.close();
    }
}

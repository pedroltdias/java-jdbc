import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        connection.setAutoCommit(false); //remove o poder de commit do jdbc e retoma para si(desenvolvedor)

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)");

        try {
            adicionarVariavel("PRODUTO7", "DESCRICAO7", stm);
            adicionarVariavel("PRODUTO8", "DESCRICAO8", stm);

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ROOLBACK]");
            connection.rollback();
        } finally {
            stm.close();
            connection.close();
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();
    }
}

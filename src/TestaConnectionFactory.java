import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConnectionFactory {
    public static void main(String args[]) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        System.out.println("Closing connection...");

        connection.close();
    }
}

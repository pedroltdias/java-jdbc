import java.sql.*;

public class TestaListagem {
    public static void main(String args[]) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:db.sqlite");

        Statement stm = con.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            System.out.println("PRODUTO:" +
                    "\n ID: " + id +
                    "\n NOME: " + nome +
                    "\n DESCRICAO: " + descricao
            );
        }

        con.close();
    }
}

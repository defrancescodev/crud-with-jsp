package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAO {

    public static Connection createConnection() {
        Connection connection = null;

        try {
            // 1. Driver sem espaço extra
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. URL correta do MySQL (Substitua 'nome_do_seu_banco' pelo nome real do banco de dados)
            String url = "jdbc:mysql://localhost:3306/my_stuff?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "1234";

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = createConnection();

            if (connection != null) {
                System.out.println("Conexão obtida com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}

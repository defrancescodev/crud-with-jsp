package dao;

import bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> getUsers() {
        String sql = "SELECT * FROM usuarios";
        List<User> userList = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = createConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId( resultSet.getInt("id"));
                user.setName(resultSet.getString("nome"));
                user.setPassword(resultSet.getString("senha"));
                user.setEmail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sexo"));
                user.setNationality(resultSet.getString("nacionalidade"));
                userList.add(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
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

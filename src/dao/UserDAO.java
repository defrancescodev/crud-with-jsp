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
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_stuff?useSSL=false&serverTimezone=UTC", "root", "1234");
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

    public void saveUser(User user) {
        String sql = "INSERT INTO usuarios (nome, senha, email, sexo, nacionalidade) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement= null;

        try {
            connection = createConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getNationality());
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


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

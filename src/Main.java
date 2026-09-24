import bean.User;
import dao.UserDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user1 = new User("Samuel", "123", "samuel@gmail.com", "masculino","brasileiro");

        userDAO.saveUser(user1);

        for (User user : userDAO.getUsers()) {
            System.out.println(user.getId());
            System.out.println(user.getName());
        }

    }
}
import bean.User;
import dao.UserDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        for (User user : userDAO.getUsers()) {
            System.out.println(user.getId());
            System.out.println(user.getName());
        }

    }
}
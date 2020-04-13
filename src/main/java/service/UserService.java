package service;

import dao.UserDAO;
import dao.UserDaoFactory;
import model.User;

import java.util.List;

public class UserService {
    private static UserService userService;
    private UserDAO dao;

    private UserService() {
        dao = UserDaoFactory.getInstance().getUserDAO();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }

    public void addUser(String firstName, String lastName, String login, String password, String role) {
        dao.addUser(new User(firstName, lastName, login, password, role));
    }

    public void editUser(User user) {
        dao.editUser(user);
    }

    public void deleteUser(Long id) {
        dao.deleteUser(dao.getUserById(id));
    }

    public void createTable() {
        dao.createTable();
    }

    public void dropTable() {
        dao.dropTable();
    }
}

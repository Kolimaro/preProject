package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User getUserByLogin(String login);

    default void createTable() {
    }

    default void dropTable() {
    }
}

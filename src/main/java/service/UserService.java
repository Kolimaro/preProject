package service;

import dao.UserDAO;
import exception.DBException;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public List<User> getAllUsers() throws DBException {
        List<User> userList;
        try {
            userList = dao.getAllUsers();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return userList;
    }

    public void addUser(String firstName, String lastName) throws DBException {
        try {
            dao.addUser(new User(firstName, lastName));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void editUser(User user) throws DBException {
        try {
            dao.editUser(user);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void deleteUser(Long id) throws DBException {
        try {
            dao.deleteUser(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws DBException {
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void dropTable() throws DBException {
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

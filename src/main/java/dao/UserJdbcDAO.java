package dao;

import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private Connection connection;

    public UserJdbcDAO() {
        connection = DBHelper.getConnection();
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setRole(rs.getString(6));
                userList.add(user);
            }
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return userList;
    }

    @Override
    public User getUserById(Long id) {
        User user;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setId(id);
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setLogin(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setRole(rs.getString(6));
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return user;
    }

    public void addUser(User user) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into users (firstname, lastname, login, password, role) values (?, ?, ?, ?, ?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void editUser(User user) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("update users set firstname = ?, lastname = ?, login = ?, password = ?, role = ? where id = ?");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.setLong(6, user.getId());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public User getUserByLogin(String login) {
        User user;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where login = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setId(rs.getLong(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setLogin(login);
            user.setPassword(rs.getString(5));
            user.setRole(rs.getString(6));
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        return user;
    }

    @Override
    public void deleteUser(User user) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("delete from users where id = ?");
            ps.setLong(1, user.getId());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void createTable() {
        try {
            PreparedStatement ps = connection.prepareStatement("create table if not exists users (id bigint auto_increment, " +
                    "firstname varchar(256), lastname varchar(256), login varchar(256), password varchar(256), role varchar(256), primary key (id))");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void dropTable() {
        try {
            PreparedStatement ps = connection.prepareStatement("drop table if exists users");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}

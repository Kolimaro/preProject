package dao;

import model.User;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DBConnection.getConnection();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            userList.add(user);
        }
        rs.close();
        ps.close();
        return userList;
    }

    public void addUser(User user) throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("insert into users (firstname, lastname) values (?, ?)");
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.executeUpdate();
        connection.commit();
        ps.close();
    }

    public void editUser(User user) throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("update users set firstname = ?, lastname = ? where id = ?");
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setLong(3, user.getId());
        ps.executeUpdate();
        connection.commit();
        ps.close();
    }

    public void deleteUser(Long id) throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("delete from users where id = ?");
        ps.setLong(1, id);
        ps.executeUpdate();
        connection.commit();
        ps.close();
    }

    public void createTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("create table if not exists users (id bigint auto_increment, firstname varchar(256), lastname varchar(256), primary key (id))");
        ps.executeUpdate();
        ps.close();
    }

    public void dropTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("drop table if exists users");
        ps.executeUpdate();
        ps.close();
    }
}

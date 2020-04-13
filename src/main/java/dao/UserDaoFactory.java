package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDaoFactory instance;

    private Properties properties;
    private UserDAO userDAO;

    private UserDaoFactory() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("/dao.properties"));
            String daotype = properties.getProperty("daotype");
            userDAO = (UserDAO) Class.forName(daotype).newInstance();
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new UserDaoFactory();
    }

    public static UserDaoFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}

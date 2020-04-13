package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private static SessionFactory sessionFactory = null;

    public UserHibernateDAO() {
        if (sessionFactory == null) {
            Configuration configuration = DBHelper.getConfiguration();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            sessionFactory = configuration.buildSessionFactory(builder.applySettings(configuration.getProperties()).build());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u", User.class);
        List<User> userList = query.getResultList();
        session.close();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.login = :u_login", User.class);
        query.setParameter("u_login", login);
        User user = query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();

    }
}

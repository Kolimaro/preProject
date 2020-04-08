package servlet;

import exception.DBException;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class MainServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<User> users = userService.getAllUsers();
            req.setAttribute("usersFromDB", users);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/allUsers.jsp");
            dispatcher.forward(req, resp);
        } catch (DBException e) {
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        try {
            userService.addUser(firstName, lastName);
        } catch (DBException e) {
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userService.createTable();
            resp.setStatus(200);
        } catch (DBException e) {
            resp.setStatus(500);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userService.dropTable();
            resp.setStatus(200);
        } catch (DBException e) {
            resp.setStatus(500);
        }
    }
}

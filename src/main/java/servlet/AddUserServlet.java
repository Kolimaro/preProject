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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/addUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        try {
            userService.addUser(firstName, lastName);
            List<User> users = userService.getAllUsers();
            req.setAttribute("usersFromDB", users);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/allUsers.jsp");
            dispatcher.forward(req, resp);
        } catch (DBException e) {
            resp.setStatus(500);
        }
    }
}

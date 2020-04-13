package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getUserByLogin(login);
        if (user.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            if (user.getRole().equals("admin")) {
                resp.sendRedirect(req.getContextPath() + "/admin");
            } else {
                resp.sendRedirect(req.getContextPath() + "/user");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}

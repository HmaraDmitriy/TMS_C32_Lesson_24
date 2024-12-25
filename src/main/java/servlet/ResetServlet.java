package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("visitCount", 0);

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Visit Count Reset</h1>");
        resp.getWriter().println("<p>Visit count has been reset.</p>");
        resp.getWriter().println("<a href='/count'>Go to Count</a>");
    }
}
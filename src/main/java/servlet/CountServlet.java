package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/count")
public class CountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 0;
        }
        visitCount++;
        session.setAttribute("visitCount", visitCount);

        Logger.log("Accessed CountServlet: " + visitCount);

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Visit Count</h1>");
        resp.getWriter().println("<p>Page visits: " + visitCount + "</p>");
        resp.getWriter().println("<a href='/reset'>Reset Count</a>");
    }
}


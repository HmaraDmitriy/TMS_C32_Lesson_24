package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/index", "/plan"})
public class ServletDZ extends HttpServlet {
        @Override
        public void init() throws ServletException {
            Logger.log("CombinedServlet initialized");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String path = req.getServletPath();
            resp.setContentType("text/html");

            if ("/index".equals(path)) {
                Logger.log("Accessed /index");
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h2>Information</h2>");
                resp.getWriter().println("<h4>Full name - Khmara Dmitry Leonidovich</h4>");
                resp.getWriter().println("<h4>Gender - male</h4>");
                resp.getWriter().println("<h4>Age - 34</h4>");
                resp.getWriter().println("</body></html>");
            } else if ("/plan".equals(path)) {
                Logger.log("Accessed /plan");
                resp.getWriter().println("<html><body>");
                resp.getWriter().println("<h1>Have a good New Year's Eve )))))</h1>");
                resp.getWriter().println("</body></html>");
            }
        }
}

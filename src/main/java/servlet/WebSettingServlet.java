package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/settings")
public class WebSettingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appName = getServletContext().getInitParameter("appName");
        String appVersion = getServletContext().getInitParameter("appVersion");
        String developerName = getServletContext().getInitParameter("developerName");
        String supportEmail = getServletContext().getInitParameter("supportEmail");

        Logger.log("Accessed SettingsServlet");

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Application Settings</h1>");
        resp.getWriter().println("<p>App Name: " + appName + "</p>");
        resp.getWriter().println("<p>Version: " + appVersion + "</p>");
        resp.getWriter().println("<p>Developer: " + developerName + "</p>");
        resp.getWriter().println("<p>Support Email: " + supportEmail + "</p>");
    }
}

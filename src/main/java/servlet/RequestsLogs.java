package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/logs")
public class RequestsLogs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("Accessed LogsServlet");

        resp.setContentType("text/plain");

        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resp.getWriter().println(line);
            }
        } catch (IOException e) {
            resp.getWriter().println("Error reading logs: " + e.getMessage());
        }
    }
}

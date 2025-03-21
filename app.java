import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class TaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String task = request.getParameter("task");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/task_tracker", "root", "yourpassword");

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tasks (user_id, task_description, status) VALUES (?, ?, ?)");
            ps.setInt(1, 1);  // Example user_id
            ps.setString(2, task);
            ps.setString(3, "Pending");
            ps.executeUpdate();

            out.println("<h3>Task added successfully!</h3>");
            out.println("<a href='task.html'>Go Back</a>");
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
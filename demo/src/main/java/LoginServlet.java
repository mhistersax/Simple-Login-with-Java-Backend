import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet(name = "newing", urlPatterns = { "/newing" })
public class LoginServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String usermail = request.getParameter("usermail");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/webserver", "root", "");
                String query = "insert into authentication(username, password, fullName, Email)values(?,?,?,?)";
                PreparedStatement preparedStatementStmt = obj.prepareStatement(query);
                preparedStatementStmt.setString(1, userName);
                preparedStatementStmt.setString(2, password);
                preparedStatementStmt.setString(3, fullname);
                preparedStatementStmt.setString(4, usermail);
                int i = preparedStatementStmt.executeUpdate();
                if (i >= 1) {
                    out.println("Data is inserted sucessfully !");

                } else {
                    out.println("Data not inserted!");
                }
            } catch (Exception e) {
                out.println(e);
            }
            
        }
    }
    
}

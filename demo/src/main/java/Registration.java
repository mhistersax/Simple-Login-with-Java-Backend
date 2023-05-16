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
import jakarta.servlet.RequestDispatcher;

// import java.sql.PreparedStatement;

@WebServlet(name = "regist", urlPatterns = { "/regist" })
public class Registration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String gender = request.getParameter("gender");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/webserver", "root", "");
                String query = "insert into regtable(fname, lname, email, city, country, gender)values(?,?,?,?,?,?)";
                PreparedStatement preparedStatementStmt = obj.prepareStatement(query);
                preparedStatementStmt.setString(1, fname);
                preparedStatementStmt.setString(2, lname);
                preparedStatementStmt.setString(3, email);
                preparedStatementStmt.setString(4, city);
                preparedStatementStmt.setString(5, country);
                preparedStatementStmt.setString(6, gender);
                int i = preparedStatementStmt.executeUpdate();
                if (i >= 1) {
                    // out.println("Data is inserted sucessfully !");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                     rd.include(request, response);
                     out.close();
                } else {
                    out.println("Data not inserted!");
                }
            } catch (Exception e) {
                out.println(e);
            }

        }
       
    }
}

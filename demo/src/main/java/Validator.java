import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;

// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Validator extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        String result;
        
        try (PrintWriter out = response.getWriter()){
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            try {
                result = "'" + email + "'";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/webserver", "root", "");
                Statement stmt = obj.createStatement(); 
                ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM `regtable` WHERE email = "  + result);
            rs.next();
            // Creating Strings for capturing
            String cantinatingFullname = rs.getString(1);
            String cantinatingMail = rs.getString(3);
            String finalFullName = fname + " " + lname;
        if(fname.equals(cantinatingFullname) || (email.equals(cantinatingMail))){
                out.println("Welcome " + finalFullName);
            }
            else{
                out.println("Wrong Pin or Password");
            }
            } catch (Exception e) {
                out.println("Please Register This Mail, User Not found in the database");
            }
           
    } catch (Exception d) {
            System.out.println(d);
        }
    }
}

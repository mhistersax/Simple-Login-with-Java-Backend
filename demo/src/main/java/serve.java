import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "serve", urlPatterns = { "/display" })
public class serve extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // if(userName == null || userName.equals("") && password == null || password.equals("")){
            //     out.println("Welcome");
            //     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            //     rd.include(request, response);
            // }
            // else if(userName.equals("Kamal") && password.equals("admin")){
            //     out.println("Acess Granted");
             //    RequestDispatcher rd = request.getRequestDispatcher("login.html");
            //     rd.include(request, response);
            // }
            // else{
            //     out.println("Password error");
            //     RequestDispatcher rd = request.getRequestDispatcher("/C:/Users/coppy/OneDrive/Documents/Java_web_vscode/demo/src/main/webapp/index.jsp");
            //     rd.include(request, response);
            // }
         }
    }
  
}

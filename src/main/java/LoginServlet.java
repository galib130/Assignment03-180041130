import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import  com.example.Assignment03_180041130.LoginBean;
public class LoginServlet extends HttpServlet {
//
//import com.example.lab04_180041130_task3.LoginBean;




        Boolean valid;
        public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {


            LoginBean loginBean =new LoginBean();

            loginBean.setUsername(request.getParameter("username"));
            loginBean.setPassword(request.getParameter("password"));

            valid=loginBean.getValid();

            if(valid==Boolean.TRUE){
                HttpSession session=request.getSession(true);

                session.setAttribute("username",loginBean.getUsername());
                session.setAttribute("password",loginBean.getPassword());
                request.getRequestDispatcher("home.jsp").include(request,response);
            //response.sendRedirect("Home");

            }
            else{
                request.getRequestDispatcher("login.jsp").include(request,response);
            }

        }






}

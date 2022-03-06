import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class updateServlet extends HttpServlet{
    ArrayList<Integer> countList=new ArrayList<Integer>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
       if(req.getParameter("Add")!=null){
         int object= Integer.parseInt(req.getParameter("Add"));
           if(session.getAttribute("countList")!=null){
               countList= (ArrayList<Integer>) session.getAttribute("countList");
               int count=countList.get(object);
               count++;
               countList.set(object,count);
               session.setAttribute("countList",countList);

           }


       }

       else if(req.getParameter("Subtract")!=null){
           int object= Integer.parseInt(req.getParameter("Subtract"));
           if(session.getAttribute("countList")!=null){
               countList= (ArrayList<Integer>) session.getAttribute("countList");
               int count=countList.get(object);
               if(count>1)
               count--;
               countList.set(object,count);
               session.setAttribute("countList",countList);

           }
       }

       req.getRequestDispatcher("cart.jsp").include(req,resp);
    }
}

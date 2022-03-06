import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class deleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> cartList=new ArrayList<String>();
        ArrayList<Integer> priceList=new ArrayList<Integer>();
        ArrayList<String> imageList=new ArrayList<String>();
        ArrayList<Integer> countList=new ArrayList<Integer>();
        HttpSession session= req.getSession();
        if(session.getAttribute("cartList")!=null){

            cartList= (ArrayList<String>) session.getAttribute("cartList");
            priceList= (ArrayList<Integer>) session.getAttribute("priceList");
            imageList= (ArrayList<String>) session.getAttribute("imageList");
            countList= (ArrayList<Integer>) session.getAttribute("countList");

        }
        if(req.getParameter("Delete")!=null){
            int delete= Integer.parseInt(req.getParameter("Delete"));
            cartList.remove(delete);
            priceList.remove(delete);
            imageList.remove(delete);
            countList.remove(delete);
            System.out.println(delete);


        }
        req.getRequestDispatcher("cart.jsp").include(req,resp);
    }
}

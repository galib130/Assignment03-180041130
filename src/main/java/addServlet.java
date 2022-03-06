import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;


public class addServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
try {
    Class.forName("com.mysql.cj.jdbc.Driver");


    Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST","user","2467810Ag*");
    Statement statement=connect.createStatement();
    String sql;
    int id=0;
    if(req.getParameter("cart")!=null){
         id= Integer.parseInt(req.getParameter("cart"));

    }
    sql="SELECT NAME,PRICE,IMAGE FROM ITEMS WHERE ID="+id+";";
    ArrayList<String> cartList=new ArrayList<String>();
    ArrayList<Integer> priceList=new ArrayList<Integer>();
    ArrayList<String> imageList=new ArrayList<String>();
    ArrayList<Integer> countList=new ArrayList<Integer>();
    ResultSet resultSet= statement.executeQuery(sql);
    HttpSession session= req.getSession();
    if (session!=null){

        if(session.getAttribute("cartList")!=null){

            cartList= (ArrayList<String>) session.getAttribute("cartList");
            priceList= (ArrayList<Integer>) session.getAttribute("priceList");
            imageList= (ArrayList<String>) session.getAttribute("imageList");
            countList= (ArrayList<Integer>) session.getAttribute("countList");

        }
            while (resultSet.next()){

                cartList.add(resultSet.getString("NAME"));
                priceList.add(resultSet.getInt("PRICE"));
                imageList.add(resultSet.getString("IMAGE"));
            }
            countList.add(1);
            session.setAttribute("cartList",cartList);
            session.setAttribute("priceList",priceList);
            session.setAttribute("imageList",imageList);
            session.setAttribute("countList",countList);
            System.out.println(countList + "countList");
    }

} catch (SQLException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
        req.getRequestDispatcher("home.jsp").include(req,resp);
    }
}

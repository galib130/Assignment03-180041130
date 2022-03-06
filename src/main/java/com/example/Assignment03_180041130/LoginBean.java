package com.example.Assignment03_180041130;

import java.io.Serializable;
import java.sql.*;

public class LoginBean implements  Serializable{
    String username;
    String password;
    Boolean valid=false;
    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public Boolean getValid() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST","user","2467810Ag*");
            Statement statement=connect.createStatement();

            String s1= "SELECT * FROM USER WHERE USERNAME='"+this.username+"'"+" AND PASSWORD='"+this.password
            +"'"+";";
           ResultSet result= statement.executeQuery(s1);
            String username__valid="NULL";
            String password_valid="NULL";
           while (result.next()){

                 username__valid=result.getString("USERNAME");
                 password_valid=result.getString("PASSWORD");
            }
           if(username__valid.equals("NULL")){
               valid=Boolean.FALSE;
           }
           else
               valid=Boolean.TRUE;
           result.close();
           statement.close();
           connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
//        if(username.equals("galib130")&&password.equals("1234")){
//            valid=Boolean.TRUE;
//        }
//        else
//            valid=Boolean.FALSE;

        return valid;
    }
}

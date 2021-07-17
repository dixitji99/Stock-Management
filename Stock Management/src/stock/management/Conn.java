/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */

public class Conn {
    public static String email;
    
public static void main(String args[]){
    
}
        public  boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
        
        public  boolean isValidu(String uname) 
    { 
        Pattern pat = Pattern.compile("^[a-zA-Z[^0-9]]+\\w[^0-9]{2,5}$"); 
        if (uname == null) 
            return false; 
        return pat.matcher(uname).matches(); 
    } 
        public  boolean isValidp(String password) 
    { 
        Pattern pat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$"); 
        if (password == null) 
            return false; 
        return pat.matcher(password).matches(); 
    } 

    public  String Con2(String query1,String st)
    {
        String j=null;
        try{
Class.forName("java.sql.DriverManager");
Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/stockmanagement","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query1);
while(rs.next())
{
j=rs.getString(st);    
}
        }
catch(HeadlessException | ClassNotFoundException | SQLException e){
JOptionPane.showMessageDialog(null, e.getMessage());
}  
        return j;
    }
    
    public void con1(String tn)
    {
        
         try{
Class.forName("java.sql.DriverManager");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost/stockmanagement","root","");
Statement stmt=con.createStatement();
stmt.executeUpdate(tn);
System.out.println("data added successfully");
         }
         catch(ClassNotFoundException | SQLException e){
             System.out.print(e);
         }
    }
    
    
}

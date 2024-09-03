package com.aditya.learning;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConn {
public static void main(String[] args) throws Exception{
		
	String url = "jdbc:mysql://localhost:3306/student";
    String uname = "root";
    String pass = "your_password"; // Replace 'your_password' with the actual password
    
//    String query = "select * from aliens";
    
//    String query = "insert into aliens values(4, 'Vinayak')";
    
    
    int userId = 5;
    String name = "Himanshu";
    
    String query = "insert into aliens values (?,?)";
    
    
    // You can omit this line in newer versions of JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(url, uname, pass);
    
//    Statement st = con.createStatement();
    PreparedStatement st = con.prepareStatement(query);
    st.setInt(1, userId);
    st.setString(2, name);
//    ResultSet rs = st.executeQuery(query);
    int count = st.executeUpdate();
    
    String userData = " ";
//    rs.next();
//    userData = rs.getInt(1) + ":" + rs.getString(2);
//    System.out.println(userData);
//    
//    rs.next();
//    userData = rs.getInt(1) + ":" + rs.getString(2);
//    System.out.println(userData);
//    
//    rs.next();
//    userData = rs.getInt(1) + ":" + rs.getString(2);
//    System.out.println(userData);
    
//    while(rs.next()) {
//    	userData = rs.getInt(1) + ":" + rs.getString(2);
//        System.out.println(userData);
//    }
//    
    System.out.println(count + " rows affected");
    st.close();
    con.close();
	}
}

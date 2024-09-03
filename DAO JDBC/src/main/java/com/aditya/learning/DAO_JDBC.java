package com.aditya.learning;

import java.sql.*;

public class DAO_JDBC {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(11);
		System.out.println(s1.sname);
	}
}

class StudentDAO{
	public Student getStudent(int rollno) {
		try {
			String query = "select sname from stu where rollno = " + rollno;			
			Student s = new Student();
			s.rollno = rollno;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "your_password");
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.sname = name;
			
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

class Student{
	int rollno;
	String sname;
}
package com.loginregistrations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registeruser")

public class RegistrationUserServlet extends HttpServlet{
	
	
		private static final String query="INSERT INTO USERSREGISTRATION (NAME,EMAIL,PASSWORD,PHONENUMBER,GENDER) VALUES (?,?,?,?,?)";
		 private static final String jdbcurl = "jdbc:oracle:thin:@//Gipsy:1521/orcl";
		 private static final String db_username = "KishoreDB";
		 private static final String db_password = "kishore";
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
		{
			PrintWriter out=res.getWriter();
			String username=req.getParameter("Name");
			String emailid=req.getParameter("Email");
			String password=req.getParameter("Password");
			long phonenumber=Long.parseLong(req.getParameter("Phonenumber"));
			String gender=req.getParameter("Gender");
			res.setContentType("text/html");
			Connection con =null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(jdbcurl,db_username,db_password);
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, emailid);
				ps.setString(3, password);
				ps.setLong(4, phonenumber);
				ps.setString(5, gender);
				int cnt=ps.executeUpdate();
				if(cnt == 1)
				{
					res.sendRedirect("LoginPage.jsp");  
				}
				else
				{
					res.sendRedirect("RegisterPage.html");
				}
				
			}
			catch(SQLException | ClassNotFoundException se)
			{
				se.printStackTrace();
				out.println("<h2>"+se.getMessage()+"</h2>");
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}




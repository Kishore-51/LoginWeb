package com.loginregistrations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
	private static final String query="SELECT NAME,PASSWORD FROM USERSREGISTRATION WHERE NAME=? AND PASSWORD=?";
	 private static final String jdbcurl = "jdbc:oracle:thin:@//Gipsy:1521/orcl";
	 private static final String db_username = "KishoreDB";
	 private static final String db_password = "kishore";
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		String username=req.getParameter("Name");
		//String emailid=req.getParameter("Email");
		String password=req.getParameter("Password");
		
		res.setContentType("text/html");
		Connection con =null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(jdbcurl,db_username,db_password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				
			{
				 HttpSession session=req.getSession();
				 session.setAttribute("username",username);
				 	 
				res.sendRedirect("LastPage.jsp");
			}	
			else
			{
				
				res.sendRedirect("LoginPage.jsp?error=1");
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

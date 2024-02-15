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
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final String query="SELECT * FROM USERSREGISTRATION WHERE NAME=? AND PASSWORD=?";
	 private static final String jdbcurl = "jdbc:oracle:thin:@//Gipsy:1521/orcl";
	 private static final String db_username = "KishoreDB";
	 private static final String db_password = "kishore";
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		
		
		res.setContentType("text/html");
		Connection con =null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(jdbcurl,db_username,db_password);
			PreparedStatement ps=con.prepareStatement(query);
//			ps.setString(1, username);
//			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				res.sendRedirect("/profile");
			}	
			else
			{
				res.sendRedirect("LoginPage.html");
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

package com.loginregistrations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		
		res.setContentType("text/html");
		HttpSession session=req.getSession(false);  
		if(session !=null )
		{
			session.invalidate(); 
		}
        res.sendRedirect("LoginPage.jsp");
	}
}

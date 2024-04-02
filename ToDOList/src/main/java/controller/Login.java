package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dbaccess;
import dto.User;
@WebServlet("/userlogin")
public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String email=req.getParameter("email");		
		String password=req.getParameter("password");

		
		dbaccess dao=new dbaccess();
		
		try {
			User u=dao.findByEmail(email);
			if(u!=null)
			{
				if(u.getUserpassword().equals(password))
				{
					HttpSession session=req.getSession();
					session.setAttribute("user",u);
					req.getRequestDispatcher("home.jsp").include(req, res);;	
				}
				else
				{
					req.getRequestDispatcher("login.jsp").include(req, res);
				}
			}
			else	
			{
				req.getRequestDispatcher("login.jsp").include(req, res);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

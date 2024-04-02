package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.dbaccess;
import dto.User;
@WebServlet("/s1")
@MultipartConfig(maxFileSize=10*1024*1024)
public class Getuser extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		Part imagepart=req.getPart("image");
		byte[]imagebyte=imagepart.getInputStream().readAllBytes();
		
		User user = new User();
		user.setUserid(id);
		user.setUsername(name);
		user.setUseremail(email);
		user.setUsercontact(contact);
		user.setUserpassword(password);
		user.setUserimage(imagebyte);
		
		dbaccess dba=new dbaccess();
		try {
			int re=dba.savedata(user);
			if(re>0)
			{
				res.getWriter().print("signup success");
			}
			else
			{
				res.getWriter().print("signup failed");
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
	


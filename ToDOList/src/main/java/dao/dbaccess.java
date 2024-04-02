package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import dto.User;

public class dbaccess
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?user=root&password=root");
		return cn;
	}
	public static int savedata(User user) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(5, user.getUserpassword());
		Blob blobimage=new SerialBlob(user.getUserimage());
		pst.setBlob(6, blobimage);
		int res=pst.executeUpdate();
		return res;
		
	}
	
	public User findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from users where useremail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(5));
			Blob imageblob=rs.getBlob(6);
			byte[] imagebyte=imageblob.getBytes(1,(int) imageblob.length());
			u.setUserimage(imagebyte);
			
			return u;
		}
		else
		{
			return null;
		}
	}

	
}





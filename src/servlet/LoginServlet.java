package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtools.DBUtil;
import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import MD5.MD5Util;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ID=request.getParameter("ID");
		String PW=request.getParameter("PW");
		String PW_MD5=MD5Util.MD5(PW);
		boolean type=false;
		response.setContentType("text/html; charset=UTF-8");

		try
		{
			Connection con=DBUtil.getConnection();
			Statement stmt=con.createStatement();
			String sql="select * from user where uloginname='"+ID+"' and upwd='"+PW_MD5+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				type=true;
				PrintWriter out = response.getWriter();
				UserDao userDAO=new UserDao();
				List<User> list = new ArrayList<User>();
				list=userDAO.Select(ID,PW_MD5);
				JSONArray ja = new JSONArray();
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {	
					User user = (User) iterator.next();	
					JSONObject jobj= new JSONObject();	
					jobj.put("uid", user.getUid());		
					jobj.put("uname", user.getUname());	
					jobj.put("uidcard", user.getUidcard());	
					jobj.put("usex", user.getUsex());
					jobj.put("ubirth", user.getUbirth());
					jobj.put("uage", user.getUage());
					jobj.put("uaddr",user.getUaddr());
					jobj.put("utele", user.getUtele());
					jobj.put("uloginname", user.getUloginname());
					jobj.put("type", true);
					ja.add(jobj);	
				}
				DBUtil.Close();
				System.out.println(ja.toString());
				out.write(ja.toString());
				//out.print(type);
				out.flush();
				out.close();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		doGet(request, response);
	}

}

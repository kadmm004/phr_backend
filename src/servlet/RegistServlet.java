package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MD5.MD5Util;
import dbtools.DBUtil;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String IDCARD=request.getParameter("IDCARD");
		String TELE=request.getParameter("TELE");
		String NAME=request.getParameter("NAME");
		String SEX=request.getParameter("SEX");
		String ADDR=request.getParameter("ADDR");
		String BIRTH=request.getParameter("BIRTH");
		String NATION=request.getParameter("NATION");
		
		Date birth=java.sql.Date.valueOf(BIRTH);
		
		Calendar c = Calendar.getInstance();
		c.setTime(birth);
		int year = c.get(Calendar.YEAR);
		int age=2020-year;
		
		String PW=request.getParameter("PW");
		String PW_MD5=MD5Util.MD5(PW);
		String PW2=request.getParameter("PW2");
		String PW2_MD5=MD5Util.MD5(PW2);
		
		boolean sendback=false;
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(IDCARD==null) {
        	System.out.println("33333");
        	sendback=false;
        }
        else if(!PW_MD5.equals(PW2_MD5)) {
        	System.out.println(PW+"__"+PW_MD5);
        	System.out.println(PW2+"__"+PW2_MD5);
        	sendback=false;
        }
        else {
        	try
            {
            	Connection con=DBUtil.getConnection();
            	PreparedStatement ps;
                ResultSet rs;
            	String sql="insert into user(uidcard,uname,usex,ubirth,uage,uaddr,utele,uloginname,upwd,unation) " + 
            			"values (?,?,?,?,?,?,?,?,?,?)";
            	ps=con.prepareStatement(sql);
    			Statement stmt=con.createStatement();
    			ps.setString(1,IDCARD);
    			ps.setString(2,NAME);
    			ps.setString(3,SEX);
    			ps.setDate(4,birth);
    			ps.setInt(5,age);
    			ps.setString(6,ADDR);
    			ps.setString(7,TELE);
    			ps.setString(8,TELE);
    			ps.setString(9,PW_MD5);
    			ps.setString(10,NATION);
    			ps.execute();
    		    if(ps!=null)
    		    {
    		    	sendback=true;
    		    }
            }
            catch(Exception ex)
            {
            	ex.printStackTrace();
            }
            finally
            {
            	DBUtil.Close();
            	out.print(sendback);
            	out.flush();
            	out.close();
            }
        }
		doGet(request, response);
	}

}

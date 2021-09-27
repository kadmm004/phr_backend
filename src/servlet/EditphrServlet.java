package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtools.DBUtil;

/**
 * Servlet implementation class EditphrServlet
 */
@WebServlet("/EditphrServlet")
public class EditphrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditphrServlet() {
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
		String id=request.getParameter("UID");
		String height=request.getParameter("UHEIGHT");
		double uheight=Double.parseDouble(height);
		String weight=request.getParameter("UWEIGHT");
		double uweight=Double.parseDouble(weight);
		double ubmi=uweight/(uheight*uheight/10000);
		String blood=request.getParameter("UBLOOD");
		String waistline=request.getParameter("UWAISTLINE");
		double uwaistline=Double.parseDouble(waistline);
		String umarriage=request.getParameter("UMARRIAGE");
		String uborn=request.getParameter("UBORN");
		String uexercise=request.getParameter("UEXERCISE");
		String udiet=request.getParameter("UDIET");
		String uallergy=request.getParameter("UALLERGY");
		String usmoke=request.getParameter("USMOKE");
		String udrink=request.getParameter("UDRINK");
		System.out.println(umarriage+"||"+uborn);
		boolean sendback=false;
		
        PrintWriter out = response.getWriter();
        
        try
        {
        	Connection con=DBUtil.getConnection();
        	PreparedStatement ps;
            ResultSet rs;
            Statement stmt=con.createStatement();
//        	String sql="REPLACE INTO phr VALUES("+uid+","+uheight+","+uweight+","+ubmi+",'"+blood+"',"+uwaistline+",'"+umarriage+"'," + 
//        			"'"+uborn+"','"+uexercise+"','"+udiet+"','"+uallergy+"','"+usmoke+"','"+udrink+"') ";
//        	stmt.execute(sql);
            String sql="replace into phr values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setDouble(2,uheight);
			ps.setDouble(3,uweight);
			ps.setDouble(4,ubmi);
			ps.setString(5,blood);
			ps.setDouble(6,uwaistline);
			ps.setString(7,umarriage);
			ps.setString(8,uborn);
			ps.setString(9,uexercise);
			ps.setString(10,udiet);
			ps.setString(11,uallergy);
			ps.setString(12,usmoke);
			ps.setString(13,udrink);
			ps.execute();
		    if(ps!=null)
		    {
		    	sendback=true;
		    	System.out.println(sendback);
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
		doGet(request, response);
	}

}

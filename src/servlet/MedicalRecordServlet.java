package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbtools.DBUtil;

/**
 * Servlet implementation class MedicalRecordServlet
 */
@WebServlet("/MedicalRecordServlet")
public class MedicalRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalRecordServlet() {
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
		
		String USERID=request.getParameter("USERID");
		String MRDATE=request.getParameter("MRDATE");
		String HOSID=request.getParameter("HOSID");
		String MRCAUSE=request.getParameter("MRCAUSE");
		String MRDETAIL=request.getParameter("MRDETAIL");
		String MRSTATE=request.getParameter("MRSTATE");
		Date mrdate=java.sql.Date.valueOf(MRDATE);
		boolean sendback=false;
        PrintWriter out = response.getWriter();
        try
        {
        	Connection con=DBUtil.getConnection();
        	PreparedStatement ps;
        	ResultSet rs;
        	String sql="insert into medical_record(USERID,MRDATE,HOSID,MRCAUSE,MRDETAIL,MRSTATE) " + 
    			"values (?,?,?,?,?,?)";
        	ps=con.prepareStatement(sql);
        	Statement stmt=con.createStatement();
        	ps.setString(1,USERID);
        	ps.setDate(2,mrdate);
        	ps.setString(3,HOSID);
        	ps.setString(4,MRCAUSE);
        	ps.setString(5,MRDETAIL);
        	ps.setString(6,MRSTATE);
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
		doGet(request, response);
	}
}

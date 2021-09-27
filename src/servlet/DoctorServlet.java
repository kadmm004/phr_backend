package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDao;
import entity.Doctor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
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
		DoctorDao doctorDAO=new DoctorDao();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		String jsonString="";
		String  actionString = request.getParameter("action");
		List<Doctor> list = new ArrayList<Doctor>();
		list=doctorDAO.SelectAll();
		JSONArray ja = new JSONArray();
		for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {	
			Doctor doctor = (Doctor) iterator.next();	
			JSONObject jobj= new JSONObject();	
			jobj.put("docname", doctor.getDocName());		
			jobj.put("doctitle", doctor.getDocTitle());	
			jobj.put("docnum", doctor.getDocNum());		
			jobj.put("docscore", doctor.getDocScore());	
			jobj.put("docmajor", doctor.getDocMajor());	
			System.out.println(doctor.getDocName());
			ja.add(jobj);	
		}
		out.write(ja.toString());
		out.flush();
		out.close();
		doGet(request, response);
	}

}

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

import dao.HospitalDao;
import entity.Hospital;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class HospitalServlet
 */
@WebServlet("/HospitalServlet")
public class HospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalServlet() {
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
		HospitalDao HospitalDAO=new HospitalDao();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		String jsonString="";
		String  actionString = request.getParameter("action");
		List<Hospital> list = new ArrayList<Hospital>();
		list=HospitalDAO.SelectAll();
		JSONArray ja = new JSONArray();
		for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {	
			Hospital Hospital = (Hospital) iterator.next();	
			JSONObject jobj= new JSONObject();	
			jobj.put("hosname", Hospital.getHosName());		
			jobj.put("hosdept", Hospital.getHosDept());	
			jobj.put("hosclass", Hospital.getHosClass());		
			jobj.put("hostype", Hospital.getHosType());	
			jobj.put("hoscomment", Hospital.getHosComment());	
			System.out.print(Hospital.getHosName());
			ja.add(jobj);	
		}
		out.write(ja.toString());
		out.flush();
		out.close();
		doGet(request, response);
	}

}

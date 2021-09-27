package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegistDao;

/**
 * Servlet implementation class AppointServlet
 */
@WebServlet("/AppointServlet")
public class AppointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointServlet() {
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
		RegistDao RegistDAO=new RegistDao();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter(); 
		String jsonString="";
		String actionString = request.getParameter("action");
		String depname=request.getParameter("depname");
		String docname=request.getParameter("docname");
		String regprice=request.getParameter("price");
		String time=request.getParameter("time");
		String paname=request.getParameter("paname");
		//String paname="Ð¡Íõ";
		System.out.println(depname+docname+regprice+time+paname);
		RegistDAO.insertReg(docname,paname,regprice,time,depname);
		doGet(request, response);
	}

}

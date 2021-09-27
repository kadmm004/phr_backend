package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DrugDao;
import entity.Drug;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DrugServlet
 */
@WebServlet("/DrugServlet")
public class DrugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrugServlet() {
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
		DrugDao drugDAO=new DrugDao();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		String jsonString="";
		String  actionString = request.getParameter("action");
		List<Drug> list = new ArrayList<Drug>();
		list=drugDAO.SelectAll();
		JSONArray ja = new JSONArray();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {	
			Drug drug = (Drug) iterator.next();	
			JSONObject jobj= new JSONObject();	
			jobj.put("drugid", drug.getdrugid());		
			jobj.put("drugname", drug.getdrugname());	
			jobj.put("vertinum", drug.getvertinum());
			jobj.put("ingredient", drug.getingredient());
			jobj.put("mainfunc", drug.getmainfunc());
			jobj.put("dosage", drug.getdosage());
			jobj.put("adverseaction", drug.getadverseaction());
			jobj.put("taboo", drug.gettaboo());
			jobj.put("attention", drug.getattention());
			jobj.put("standards", drug.getstandards());
			jobj.put("productor", drug.getproductor());
			jobj.put("category", drug.getcategory());
			jobj.put("price", drug.getprice());
			ja.add(jobj);	
		}
		out.write(ja.toString());
		out.flush();
		out.close();
		doGet(request, response);
	}

}

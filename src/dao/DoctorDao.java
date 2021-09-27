package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbtools.DBUtil;
import entity.Doctor;

public class DoctorDao {
	private Connection conn;
	private Statement st;
	private ResultSet set;
	
	public List<Doctor> SelectAll(){
		List list = new ArrayList();
		try {
			conn=DBUtil.getConnection();
			if(conn == null)
				return null;
			String sql="select docname,docposition,docnum,docscore,socskilled from doctor";
			st=conn.createStatement();
			set=st.executeQuery(sql);
			while(set.next()) {
				String docname=set.getString(1);
				String doctitle=set.getString(2);
				String docnum=set.getString(3);
				String docscore=set.getString(4);
				String docmajor=set.getString(5);
				Doctor newDoc=new Doctor(docname,doctitle,docscore,docnum,docmajor);
				list.add(newDoc);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				try {
					set.close();
					conn.close();
				}catch(Exception e) {
					
				}
			}
			return list;	
		}
}

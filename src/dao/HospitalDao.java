package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbtools.DBUtil;
import entity.Hospital;

public class HospitalDao {
	private Connection conn;
	private Statement st;
	private ResultSet set;
	
	public List<Hospital> SelectAll(){
		List list = new ArrayList();
		try {
			conn=DBUtil.getConnection();
			if(conn == null)
				return null;
			String sql="select hosname,spesect,hosclass,hostype,hoscomment from hostpital";
			st=conn.createStatement();
			set=st.executeQuery(sql);
			while(set.next()) {
				String hosname=set.getString(1);
				String hosdept=set.getString(1);
				String hosclass=set.getString(3);
				String hostype=set.getString(4);
				String hoscomment=set.getString(5);
				Hospital newHos=new Hospital(hosname,hosdept,hosclass,hostype,hoscomment);
				list.add(newHos);
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

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbtools.DBUtil;

public class RegistDao {
	private Connection conn;
	private Statement st;
	private ResultSet set;

	public void insertReg(String docname,String paname,String regprice,String regdate,String depname){
		List list = new ArrayList();
		try {
			conn=DBUtil.getConnection();
			if(conn == null)
				return;
			String sql="insert into register(regdate,regprice,docname,paname,depname) "+ 
					"values ('"+regdate+"','"+regprice+"','"+docname+"','"+paname+"','"+depname+"')";
			st=conn.createStatement();
			st.execute(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				set.close();
				conn.close();
			}catch(Exception e) {

			}
		}
	}
}

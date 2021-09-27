package dao;

import java.sql.*;
import java.util.*;

import dbtools.DBUtil;
import entity.Drug;

public class DrugDao {
	// 连接对象
	private Connection conn;
	//传递sql语句
	private Statement stt;
	//结果集
	private ResultSet set;

	public List<Drug> SelectAll() {
		List list = new ArrayList();
		try {
			// 获取连接
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// 定义sql语句
			String Sql = "select * from Drug";
			// 执行sql语句
			stt = conn.createStatement();
			// 返回结果集
			set = stt.executeQuery(Sql);
			// 获取数据
			while (set.next()) {

				String drugid=set.getString(1);
				String drugname=set.getString(2);
				String vertinum=set.getString(3);
				String ingredient=set.getString(4);
				String mainfunc=set.getString(5);
				String dosage=set.getString(6);
				String adverseaction=set.getString(7);
				String taboo=set.getString(8);
				String attention=set.getString(9);
				String standards=set.getString(10);
				String productor=set.getString(11);
				String category=set.getString(12);
				double price=set.getDouble(13);

				Drug p=new Drug(drugid,drugname,vertinum,ingredient,mainfunc,dosage,adverseaction,taboo,attention,standards,productor,category,price);
				list.add(p);         
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				set.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

}

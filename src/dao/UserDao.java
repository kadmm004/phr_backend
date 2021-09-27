package dao;

import java.sql.*;
import java.util.*;

import dbtools.DBUtil;
import entity.User;

public class UserDao {
	// 连接对象
	private Connection conn;
	//传递sql语句
	private Statement stt;
	//结果集
	private ResultSet set;

	public List<User> SelectAll() {
		List list = new ArrayList();
		try {
			// 获取连接
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// 定义sql语句
			String Sql = "select * from User";
			// 执行sql语句
			stt = conn.createStatement();
			// 返回结果集
			set = stt.executeQuery(Sql);
			// 获取数据
			while (set.next()) {
				int u_id=set.getInt(1);//账号
				String uidcard=set.getString(2);
				String uname=set.getString(3);
				String usex=set.getString(4);
				String ubirth=set.getString(5);
				int uage=set.getInt(6);
				String uaddr=set.getString(7);
				String utele=set.getString(8);
				String uloginname=set.getString(9);
				String upwd=set.getString(10);
				String unation=set.getString(11);
				User p=new User(u_id,uidcard,uname,usex,ubirth,uage,uaddr,utele,uloginname,upwd,unation);
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

	public List<User> Select(String id,String pwd) {
		List list = new ArrayList();
		try {
			// 获取连接
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// 定义sql语句
			String sql="select * from user where uloginname='"+id+"' and upwd='"+pwd+"'";
			// 执行sql语句
			stt = conn.createStatement();
			// 返回结果集
			set = stt.executeQuery(sql);
			// 获取数据
			while (set.next()) {
				int u_id=set.getInt(1);//账号
				String uidcard=set.getString(2);//用户名
				String uname=set.getString(3);//用户名
				String usex=set.getString(4);//用户名
				String ubirth=set.getString(5);//用户名
				int uage=set.getInt(6);//用户名
				String uaddr=set.getString(7);//用户名
				String utele=set.getString(8);//用户名
				String uloginname=set.getString(9);//用户名
				String upwd=set.getString(10);//用户名
				String unation=set.getString(11);//用户名
				User p=new User(u_id,uidcard,uname,usex,ubirth,uage,uaddr,utele,uloginname,upwd,unation);
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

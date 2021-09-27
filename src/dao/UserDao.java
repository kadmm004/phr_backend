package dao;

import java.sql.*;
import java.util.*;

import dbtools.DBUtil;
import entity.User;

public class UserDao {
	// ���Ӷ���
	private Connection conn;
	//����sql���
	private Statement stt;
	//�����
	private ResultSet set;

	public List<User> SelectAll() {
		List list = new ArrayList();
		try {
			// ��ȡ����
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// ����sql���
			String Sql = "select * from User";
			// ִ��sql���
			stt = conn.createStatement();
			// ���ؽ����
			set = stt.executeQuery(Sql);
			// ��ȡ����
			while (set.next()) {
				int u_id=set.getInt(1);//�˺�
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
			// �ͷ���Դ
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
			// ��ȡ����
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// ����sql���
			String sql="select * from user where uloginname='"+id+"' and upwd='"+pwd+"'";
			// ִ��sql���
			stt = conn.createStatement();
			// ���ؽ����
			set = stt.executeQuery(sql);
			// ��ȡ����
			while (set.next()) {
				int u_id=set.getInt(1);//�˺�
				String uidcard=set.getString(2);//�û���
				String uname=set.getString(3);//�û���
				String usex=set.getString(4);//�û���
				String ubirth=set.getString(5);//�û���
				int uage=set.getInt(6);//�û���
				String uaddr=set.getString(7);//�û���
				String utele=set.getString(8);//�û���
				String uloginname=set.getString(9);//�û���
				String upwd=set.getString(10);//�û���
				String unation=set.getString(11);//�û���
				User p=new User(u_id,uidcard,uname,usex,ubirth,uage,uaddr,utele,uloginname,upwd,unation);
				list.add(p);         
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
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

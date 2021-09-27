package dao;

import java.sql.*;
import java.util.*;

import dbtools.DBUtil;
import entity.Drug;

public class DrugDao {
	// ���Ӷ���
	private Connection conn;
	//����sql���
	private Statement stt;
	//�����
	private ResultSet set;

	public List<Drug> SelectAll() {
		List list = new ArrayList();
		try {
			// ��ȡ����
			conn = DBUtil.getConnection();
			if (conn == null)
				return null;
			// ����sql���
			String Sql = "select * from Drug";
			// ִ��sql���
			stt = conn.createStatement();
			// ���ؽ����
			set = stt.executeQuery(Sql);
			// ��ȡ����
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

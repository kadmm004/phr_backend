package dbtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtil {
	
	private static String url="jdbc:mysql://127.0.0.1:3306/phr?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false";
	private static String username="root";
	private static String password="mxd5356";
	private static Connection conn;
	
	static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//获取数据库连接
	public static Connection getConnection(){
		try{
			conn=DriverManager.getConnection(url,username,password);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	//建立数据库连接
	public static void main(String[] args){
		Connection conn=DBUtil.getConnection();
		if(conn!=null){
			System.out.println("数据库连接成功");
		}
		else{
			System.out.println("数据库连接失败");
		}
	}
	//关闭数据库连接
	public static void Close(){
		if(conn!=null){
			try{
				conn.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

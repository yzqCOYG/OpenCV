package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test2 {
	//驱动程序的定义
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//连接地址的定义(UTC是统一标准世界时间)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//用户名
	public static final String DBUSER = "root";
	//密码
	public static final String DBPASS = "";
	public static void main(String[] args) {
		
		//数据库连接
		Connection conn = null;
		
		//加载驱动程序
		try {
			Class.forName(DBDRIVER);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			//输入用户名和密码
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(conn);
		
		//关闭数据库
		try {
			conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTest1 {
	//驱动程序的定义
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//连接地址的定义(UTC是统一标准世界时间)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//用户名
	public static final String DBUSER = "root";
	//密码
	public static final String DBPASS = "yzq0325";
	public static void main(String[] args) throws Exception{
		//数据库连接
		Connection conn = null;
		//数据库操作
		Statement stmt = null;
		//保存查询结果
		ResultSet rs = null;
		
		String sql = "SELECT * FROM book";
		//加载驱动程序
		Class.forName(DBDRIVER);
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//实例化Statement对象
		stmt = conn.createStatement();
		//实例化ResultSet对象
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {     //指针向下移动  注意：所有getter方法均可用getString()代替
			String name = rs.getString("name");
			String pass = rs.getString("password");
			int age = rs.getInt("age");
			String sex = rs.getString("sex");
			java.util.Date d = rs.getDate("birthday"); //java.util.Date的日期格式为：yyyy-MM-dd
			System.out.print("姓名：" + name + ": ");
			System.out.print("密码：" + pass + ": ");
			System.out.print("年龄：" + age + ": ");
			System.out.print("性别：" + sex + ": ");
			System.out.println("生日：" + d);
			System.out.println("--------");
		}
		
		//关闭结果集、操作和数据库
		rs.close();
		stmt.close();
		conn.close();
	}
}

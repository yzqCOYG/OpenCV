package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert1 {
	//驱动程序的定义
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//连接地址的定义(UTC是统一标准世界时间)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//用户名
	public static final String DBUSER = "root";
	//密码
	public static final String DBPASS = "";
	public static void main(String[] args) throws Exception{
		//数据库连接
		Connection conn = null;
		//数据库操作
		Statement stmt = null;
		
		String sql = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES ('sb','123',30,'male','09-7-5')";
		String sql2 = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES ('dsb','1234',20,'male','19-7-5')";
		//加载驱动程序
		Class.forName(DBDRIVER);
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//实例化Statement对象
		stmt = conn.createStatement();
		//执行数据库更新操作
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql2);
		//关闭操作和数据库
		stmt.close();
		conn.close();
	}
}

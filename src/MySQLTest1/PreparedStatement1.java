package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class PreparedStatement1 {
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
		PreparedStatement pstmt = null;
		
		String name = "dsb";
		String password = "123";
		int age = 30;
		String sex = "male";
		String birthday = "1997-07-05";
		
		//声明一个Date对象
		java.util.Date temp = null;
		//通过SimpleDateFormat类将一个字符串变为java.util.Date类型
		temp = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		//通过java.util.Date取出具体的日期数，并将其变为java.sql.Date类型
		java.sql.Date bir = new java.sql.Date(temp.getTime());
		
		//编写预处理SQL命令，该命令使用"?"进行占位
		String sql = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES (?,?,?,?,?)";
		
		//加载驱动程序
		Class.forName(DBDRIVER);
		
		//连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		
		//赋值操作
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setInt(3, age);
		pstmt.setString(4, sex);
		pstmt.setDate(5, bir);
		
		//执行数据库更新操作
		pstmt.executeUpdate();
		
		//关闭操作和数据库
		pstmt.close();
		conn.close();
	}
}

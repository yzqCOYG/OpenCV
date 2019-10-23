/*PreparedStatement和Statement
 * 前者多用于开发中使用
 * 后者不建议使用*/

package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatement2 {
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
		
		//设置查询关键字
		String keyWord = "s";
		//查询结果的保存
		ResultSet rs = null;
		
		String sql = "SELECT * FROM book WHERE name LIKE ? OR password LIKE ? OR sex LIKE ?";

		//加载驱动程序
		Class.forName(DBDRIVER);
		//连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//实例化PreparedStatement对象
		pstmt = conn.prepareStatement(sql);
		//设置模糊查询
		pstmt.setString(1, "%" + keyWord + "%");
		pstmt.setString(2, "%" + keyWord + "%");
		pstmt.setString(3, "%" + keyWord + "%");
		
		//实例化ResultSet对象
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString(1);
			String pass = rs.getString(2);
			int age = rs.getInt(3);
			String sex = rs.getString(4);
			java.util.Date d = rs.getDate(5); //java.util.Date的日期格式为：yyyy-MM-dd
			System.out.print("姓名：" + name + ": ");
			System.out.print("密码：" + pass + ": ");
			System.out.print("年龄：" + age + ": ");
			System.out.print("性别：" + sex + ": ");
			System.out.println("生日：" + d);
			System.out.println("--------");
		}
		
		//关闭操作和数据库
		rs.close();
		pstmt.close();
		conn.close();
	}
}

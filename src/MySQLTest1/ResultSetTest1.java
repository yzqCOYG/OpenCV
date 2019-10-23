package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTest1 {
	//��������Ķ���
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//���ӵ�ַ�Ķ���(UTC��ͳһ��׼����ʱ��)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//�û���
	public static final String DBUSER = "root";
	//����
	public static final String DBPASS = "yzq0325";
	public static void main(String[] args) throws Exception{
		//���ݿ�����
		Connection conn = null;
		//���ݿ����
		Statement stmt = null;
		//�����ѯ���
		ResultSet rs = null;
		
		String sql = "SELECT * FROM book";
		//������������
		Class.forName(DBDRIVER);
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//ʵ����Statement����
		stmt = conn.createStatement();
		//ʵ����ResultSet����
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {     //ָ�������ƶ�  ע�⣺����getter����������getString()����
			String name = rs.getString("name");
			String pass = rs.getString("password");
			int age = rs.getInt("age");
			String sex = rs.getString("sex");
			java.util.Date d = rs.getDate("birthday"); //java.util.Date�����ڸ�ʽΪ��yyyy-MM-dd
			System.out.print("������" + name + ": ");
			System.out.print("���룺" + pass + ": ");
			System.out.print("���䣺" + age + ": ");
			System.out.print("�Ա�" + sex + ": ");
			System.out.println("���գ�" + d);
			System.out.println("--------");
		}
		
		//�رս���������������ݿ�
		rs.close();
		stmt.close();
		conn.close();
	}
}

package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class correct1 {
	//��������Ķ���
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//���ӵ�ַ�Ķ���(UTC��ͳһ��׼����ʱ��)
	public static final String DBURL = "jdbc:mysql://129.204.196.212:3306/book?serverTimezone=UTC";
	//�û���
	public static final String DBUSER = "root";
	//����
	public static final String DBPASS = "yzq0325";
	public static void main(String[] args) throws Exception{
		//���ݿ�����
		Connection conn = null;
		//���ݿ����
		Statement stmt = null;
		
		String name = "sb";
		String password = "123";
		int age = 25;
		String sex = "male";
		String birthday = "2009-07-04";
		String sql = "UPDATE book SET name='" + name + "',password='" 
		+ password + "',age=" + age + ",sex='" + sex + "',birthday='" + birthday +"' WHERE name='sb'";		

//		String sql = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES ('sb','123',30,'male','09-7-5')";

		//������������
		Class.forName(DBDRIVER);
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//ʵ����Statement����
		stmt = conn.createStatement();
		//ִ�����ݿ���²���
		stmt.executeUpdate(sql);
		//�رղ��������ݿ�
		stmt.close();
		conn.close();
	}
}

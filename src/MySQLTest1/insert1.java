package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert1 {
	//��������Ķ���
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//���ӵ�ַ�Ķ���(UTC��ͳһ��׼����ʱ��)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//�û���
	public static final String DBUSER = "root";
	//����
	public static final String DBPASS = "";
	public static void main(String[] args) throws Exception{
		//���ݿ�����
		Connection conn = null;
		//���ݿ����
		Statement stmt = null;
		
		String sql = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES ('sb','123',30,'male','09-7-5')";
		String sql2 = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES ('dsb','1234',20,'male','19-7-5')";
		//������������
		Class.forName(DBDRIVER);
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//ʵ����Statement����
		stmt = conn.createStatement();
		//ִ�����ݿ���²���
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql2);
		//�رղ��������ݿ�
		stmt.close();
		conn.close();
	}
}

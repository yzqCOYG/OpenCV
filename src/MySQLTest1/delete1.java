package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete1 {
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
		
		String sql = "DELETE FROM book WHERE name='dsb'";
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

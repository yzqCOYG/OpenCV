package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test2 {
	//��������Ķ���
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	//���ӵ�ַ�Ķ���(UTC��ͳһ��׼����ʱ��)
	public static final String DBURL = "jdbc:mysql://localhost:3306/book?serverTimezone=UTC";
	//�û���
	public static final String DBUSER = "root";
	//����
	public static final String DBPASS = "";
	public static void main(String[] args) {
		
		//���ݿ�����
		Connection conn = null;
		
		//������������
		try {
			Class.forName(DBDRIVER);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			//�����û���������
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(conn);
		
		//�ر����ݿ�
		try {
			conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

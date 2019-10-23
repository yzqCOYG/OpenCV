package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class PreparedStatement1 {
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
		PreparedStatement pstmt = null;
		
		String name = "dsb";
		String password = "123";
		int age = 30;
		String sex = "male";
		String birthday = "1997-07-05";
		
		//����һ��Date����
		java.util.Date temp = null;
		//ͨ��SimpleDateFormat�ཫһ���ַ�����Ϊjava.util.Date����
		temp = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		//ͨ��java.util.Dateȡ����������������������Ϊjava.sql.Date����
		java.sql.Date bir = new java.sql.Date(temp.getTime());
		
		//��дԤ����SQL���������ʹ��"?"����ռλ
		String sql = "INSERT INTO book(name,password,age,sex,birthday)" + "VALUES (?,?,?,?,?)";
		
		//������������
		Class.forName(DBDRIVER);
		
		//�������ݿ�
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		
		//��ֵ����
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setInt(3, age);
		pstmt.setString(4, sex);
		pstmt.setDate(5, bir);
		
		//ִ�����ݿ���²���
		pstmt.executeUpdate();
		
		//�رղ��������ݿ�
		pstmt.close();
		conn.close();
	}
}

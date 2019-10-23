/*PreparedStatement��Statement
 * ǰ�߶����ڿ�����ʹ��
 * ���߲�����ʹ��*/

package MySQLTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatement2 {
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
		
		//���ò�ѯ�ؼ���
		String keyWord = "s";
		//��ѯ����ı���
		ResultSet rs = null;
		
		String sql = "SELECT * FROM book WHERE name LIKE ? OR password LIKE ? OR sex LIKE ?";

		//������������
		Class.forName(DBDRIVER);
		//�������ݿ�
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		//ʵ����PreparedStatement����
		pstmt = conn.prepareStatement(sql);
		//����ģ����ѯ
		pstmt.setString(1, "%" + keyWord + "%");
		pstmt.setString(2, "%" + keyWord + "%");
		pstmt.setString(3, "%" + keyWord + "%");
		
		//ʵ����ResultSet����
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString(1);
			String pass = rs.getString(2);
			int age = rs.getInt(3);
			String sex = rs.getString(4);
			java.util.Date d = rs.getDate(5); //java.util.Date�����ڸ�ʽΪ��yyyy-MM-dd
			System.out.print("������" + name + ": ");
			System.out.print("���룺" + pass + ": ");
			System.out.print("���䣺" + age + ": ");
			System.out.print("�Ա�" + sex + ": ");
			System.out.println("���գ�" + d);
			System.out.println("--------");
		}
		
		//�رղ��������ݿ�
		rs.close();
		pstmt.close();
		conn.close();
	}
}

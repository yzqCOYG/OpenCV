package MySQLTest1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {

    /**
     * ���ܣ�JDBC�������ݿ�
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //����Properties����
        Properties pro=new Properties();
        //��ȡ������
        InputStream in=
                JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //����������
        pro.load(in);
        
        String driver=pro.getProperty("driver");
        String jdbcUrl=pro.getProperty("jdbcUrl");
        String user=pro.getProperty("user");
        String password=pro.getProperty("password");
        //�������ݿ���������
        Class.forName(driver);
        //ͨ��DriverManager��getConnection()������ȡ���ݿ�����
        Connection conn=DriverManager.getConnection(jdbcUrl, user, password);
        return conn;
    }
    /**
     * ���ܣ��ر����ݿ�����
     * @param rs
     * @param statement
     * @param conn
     */
    public static void closeConnection(ResultSet rs,Statement statement,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(statement!=null){
            
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (Exception e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
        }
    }
}
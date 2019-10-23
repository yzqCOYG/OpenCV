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
     * 功能：JDBC连接数据库
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //创建Properties对象
        Properties pro=new Properties();
        //获取输入流
        InputStream in=
                JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //加载输入流
        pro.load(in);
        
        String driver=pro.getProperty("driver");
        String jdbcUrl=pro.getProperty("jdbcUrl");
        String user=pro.getProperty("user");
        String password=pro.getProperty("password");
        //加载数据库驱动程序
        Class.forName(driver);
        //通过DriverManager的getConnection()方法获取数据库连接
        Connection conn=DriverManager.getConnection(jdbcUrl, user, password);
        return conn;
    }
    /**
     * 功能：关闭数据库连接
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
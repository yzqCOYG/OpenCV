package MySQLTest1;

public class test1 {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static void main(String[] args) {
		try {
			Class.forName(DBDRIVER);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

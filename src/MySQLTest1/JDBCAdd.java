package MySQLTest1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCAdd {
    public static int Insert(String... parms){
    Connection conn=null;
    PreparedStatement preStatement=null;//����PreparedStatement����
    try {
        //1��׼��Connection�������ݿ�
        conn=JDBCTools.getConnection();
        //2��׼��sql���
        //sql��䲻�ٲ���ƴ�ӷ�ʽ��Ӧ��ռλ���ʺŵķ�ʽдsql��䡣
        String sql="insert into t_attendance(id,EnID,Name,DateTime) values(?,?,?,?)";
        //3��׼��prepareStatement
        //��ռλ������ֵ��ռλ��˳���1��ʼ����һ��������ռλ����λ�ã��ڶ���������ռλ����ֵ��
        preStatement=conn.prepareStatement(sql);
        //4��ռλ������ֵ
        for(int i=0;i<parms.length;i++){
            preStatement.setObject(i+1, parms[i]);
        }
        //5��ִ��sql
        return preStatement.executeUpdate();
        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        return 0;
    }finally{
        //6���ر����ݿ��
        JDBCTools.closeConnection(null, preStatement, conn);
    }
}
}

package OpenCVTest1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import MySQLTest1.JDBCAdd;

public class ReadTXT {
    public static List<String> trim(String[] source){
        List<String> list = new ArrayList<String>();
        //ѭ�������õ������ļ������뵽list��
        for(String item : source){
            if(null==item||"".equals(item))
                continue;
            list.add(item);
        }
        return list;
    }
    public static void main(String[] args) {
        int read = 0;
        int write = 0;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; // ���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
        try {
            String str = "";
            fis = new FileInputStream("./out.txt");// FileInputStream
            // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
            isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
            br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new
                                            // InputStreamReader�Ķ���
            while ((str = br.readLine()) != null) {
                //��ȡ�õ���һ������
                String[] parms = str.split("\t");
                //������һ��
                if(parms[0].equals("No")) continue;
                //�ѵõ������ݷŽ�list
                List<String> list = trim(parms);
                read++;
                //������ӷ�������list�ĵ�1,3,4,7�����ݼ��뵽mysql
                for(int i = 0;i<list.size();i++)
                	write+=JDBCAdd.Insert(list.get(i));
            }
            //��¼�¶���/д�˶���������
            System.out.println("read="+read+"; write="+write);
        } catch (FileNotFoundException e) {
            System.out.println("�Ҳ���ָ���ļ�");
        } catch (IOException e) {
            System.out.println("��ȡ�ļ�ʧ��");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

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
        //循环遍历得到的行文件，加入到list中
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
        BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            fis = new FileInputStream("./out.txt");// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
                                            // InputStreamReader的对象
            while ((str = br.readLine()) != null) {
                //截取得到的一行数据
                String[] parms = str.split("\t");
                //跳过第一行
                if(parms[0].equals("No")) continue;
                //把得到的数据放进list
                List<String> list = trim(parms);
                read++;
                //调用添加方法，把list的第1,3,4,7条数据加入到mysql
                for(int i = 0;i<list.size();i++)
                	write+=JDBCAdd.Insert(list.get(i));
            }
            //记录下读了/写了多少条数据
            System.out.println("read="+read+"; write="+write);
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

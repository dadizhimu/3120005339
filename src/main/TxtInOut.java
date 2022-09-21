package main;

import java.io.*;

public class TxtInOut {


    /**
     * 导入文件
     * @param absPath 文件的绝对路径
     * @return 以字符串的形式返回文件内容
     */
    public static String readTxt(String absPath){
        String str="";
        String strLine;
        File file = new File(absPath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bfr = new BufferedReader(isr);
            while ((strLine = bfr.readLine()) != null) {
                str += strLine;
            }
            isr.close();
            bfr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 导出为txt文件
     * @param data
     * @param absPath 绝对路径
     */
    public  static  void writeTxt(double data,String absPath){
        String str=Double.toString(data);//将要写入的数据转换为字符串格式
        File file = new File(absPath);
        FileWriter fileWriter=null;
        try{
            fileWriter=new FileWriter(file,false);
            fileWriter.write("该论文的重复率为：");
            fileWriter.write(str,0,(str.length()>3?4:str.length()));
            fileWriter.write("\r\n");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}

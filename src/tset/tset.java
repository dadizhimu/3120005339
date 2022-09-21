package tset;

import main.Hamming;
import main.SimHash;
import main.TxtInOut;

public class tset {

    public static void main(String[] args)
    {

        //orig.txt
        String str0= TxtInOut.readTxt(args[0]);
        //orig_0.8_add.txt
        String str1=TxtInOut.readTxt(args[1]);
        check(str0,str1);
        //orig_0.8_del.txt
        String str2=TxtInOut.readTxt(args[2]);
        check(str0,str2);
        //orig_0.8_dis_1.txt
        String str3=TxtInOut.readTxt(args[3]);
        check(str0,str3);
        //orig_0.8_dis_10.txt
        String str4=TxtInOut.readTxt(args[4]);
        check(str0,str4);
        //orig_0.8_dis_15.txt
        String str5=TxtInOut.readTxt(args[5]);
        check(str0,str5);


        //4.输出答案文件


        System.exit(0);




    }

    public static void check(String str0,String str1){
        //计算simHash值
        String simHash0= SimHash.getSimHash(str0);
        String simHash1=SimHash.getSimHash(str1);
        //计算相似度（汉明距离）
        double similarity= Hamming.getSimilarity(simHash0,simHash1);
        String ans=Double.toString(similarity);

        System.out.println("查重率为： "+ans);
    }
}

package main;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;


public class SimHash {

    /**
     * 计算传入字符串的哈希值
     * @param str 传入的字符串
     * @return 传入字符串的哈希值
     */
    public static String getHash(String str){
        try{
            //使用MD5算法计算传入字符串的哈希值
            MessageDigest msd=MessageDigest.getInstance("MD5");
            return new BigInteger(1, msd.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }

    }


    /**
     * 计算传入字符串的simHash值
     * 调用了getHash()
     * @param str 传入的字符串
     * @return
     */
    public static String getSimHash(String str){

        int[] v = new int[128];//128位的hash值

        List<String> keywordList = HanLP.extractKeyword(str, str.length());//使用中文语言处理包HanLP对传入的字符串进行分词
        int size = keywordList.size();
        int i = 0;
        for(String keyword : keywordList){

            String keywordHash = getHash(keyword);//计算hash值
            if (keywordHash.length() < 128) {
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }//hash值少于128位的用0补齐
            }
            // 加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        //降维
        String simHash = "";// 储存返回的simHash值
        for (int j = 0; j < v.length; j++) {
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;

    }


}

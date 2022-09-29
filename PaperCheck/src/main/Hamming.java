package main;

public class Hamming {


    /**
     * 计算汉明距离
     * @param simHash1
     * @param simHash2
     * @return 汉明距离
     */
    public  static int getHammingDistance(String simHash1,String simHash2){
        int distance=0;
        if(simHash1.length()!=simHash2.length())  distance=-1;//二者位数不相同，即出错
        else {
            for(int i=0;i<simHash1.length();i++){
                if(simHash1.charAt(i)!=simHash2.charAt(i)) distance++;
            }//汉明距离即为两个simHash值不同的位数
        }
        return distance;

    }

    /**
     * 计算相似度
     * 调用getHammingDistance()计算汉明距离
     * @param simHash1
     * @param simHash2
     * @return 相似度
     */
    public static double getSimilarity(String simHash1,String simHash2){
        int distance = getHammingDistance(simHash1,simHash2);//计算汉明距离
        return 0.01*(100-distance*100/128);//计算并返回相似度
    }



}

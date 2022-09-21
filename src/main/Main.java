package main;


public class Main {
    public static void main(String[] args)
    {
        //1.文件的读取
        //第一个文件的输入
        /*test
        System.out.println("原文文件绝对路径：");
        Scanner scanner = new Scanner(System.in);
        String absPath0 = scanner.next();
        String str0=TxtInOut.readTxt(absPath0);
        */
        String str0=TxtInOut.readTxt(args[0]);//从命令行参数中获取：论文原文的文件的绝对路径。

        //第二个文件的输入
        /*test
        System.out.println("抄袭版论文绝对路径：");
        String absPath1 = scanner.next();
        String str1=TxtInOut.readTxt(absPath1);
        */
        String str1=TxtInOut.readTxt(args[1]);//从命令行参数获取：抄袭版论文的文件的绝对路径。
        String ansFilePath=args[2];//从命令行参数获取：输出的答案文件的绝对路径。

        //2.计算simHash值
        String simHash0=SimHash.getSimHash(str0);
        String simHash1=SimHash.getSimHash(str1);

        //3.计算相似度（汉明距离）
        double similarity= Hamming.getSimilarity(simHash0,simHash1);

        //4.输出答案文件
        TxtInOut.writeTxt(similarity,ansFilePath);

        System.exit(0);




    }

}
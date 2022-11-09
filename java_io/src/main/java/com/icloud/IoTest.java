package com.icloud;

import java.io.*;

/**
 * @author zdh
 */
public class IoTest {

    public static void main(String[] args) {
       // fileInputStreamTest();
        // fileReaderTest();
        //BufferedInputStreamTest();
        BufferedInputStreamTest2();
    }

    /**
     * 文件字节流读操作
     */
    public static void  fileInputStreamTest(){
        try {
            //在try()中打开文件会在结尾自动关闭
            FileInputStream fileIn = new FileInputStream("/Users/zdh/Downloads/nqv6u2YsHI.txt");
            FileOutputStream fos = new FileOutputStream("/Users/zdh/Downloads/temp/tmp3.txt");
            byte[] buf = new byte[1024];
            // byte[] buf = new byte[2];
            //读取字节的个数
            int hasRead;
            while ((hasRead = fileIn.read(buf)) > 0) {
                //每次最多将1024个字节转换成字符串，这里tmp2.txt中的字符小于1024，所以一次就读完了
                //循环次数 = 文件字符数 除以 buf长度
                System.err.println(new String(buf, 0 ,hasRead));
                //每读取一次就写一次，读多少就写多少
                fos.write(buf, 0, hasRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字符流操作
     */
    public static void fileReaderTest(){
        try {
            //在try()中打开文件会在结尾自动关闭
            FileReader fileReader = new FileReader("/Users/zdh/Downloads/nqv6u2YsHI.txt");
            FileWriter fos = new FileWriter("/Users/zdh/Downloads/temp/tmpWrter.txt");
            char[] buf = new char[32];
            // byte[] buf = new byte[2];
            //读取字节的个数
            int hasRead;
            // 每个char都占两个字节，每个字符或者汉字都是占2个字节，因此无论buf长度为多少，总是能读取中文字符长度的整数倍,不会乱码
            while ((hasRead = fileReader.read(buf)) > 0) {
                // 如果buf的长度大于文件每行的长度，就可以完整输出每行，否则会断行。
                // 循环次数 = 文件字符数 除以 buf长度
               // System.out.println(new String(buf, 0, hasRead));
                fos.write(buf, 0, hasRead);
                //这里需要把缓冲区数据刷到文件中
                fos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 缓冲流程操作1
     */
    public static void  BufferedInputStreamTest(){
        try {
            //在try()中打开文件会在结尾自动关闭
            FileInputStream fileIn = new FileInputStream("/Users/zdh/Downloads/nqv6u2YsHI.txt");
            FileOutputStream fos = new FileOutputStream("/Users/zdh/Downloads/temp/BufferedInputStreamTest.txt");
            BufferedInputStream busIn = new BufferedInputStream(fileIn);
            BufferedOutputStream busOut = new BufferedOutputStream(fos);
            byte[] buf = new byte[1024];
            // byte[] buf = new byte[2];

            //读取字节的个数
            int hasRead;
            while ((hasRead = busIn.read(buf)) > 0) {
                //每次最多将1024个字节转换成字符串，这里tmp2.txt中的字符小于1024，所以一次就读完了
                //循环次数 = 文件字符数 除以 buf长度
                System.err.println(new String(buf, 0 ,hasRead));
                //每读取一次就写一次，读多少就写多少
                busOut.write(buf, 0, hasRead);
                //这里需要把缓冲区数据刷到文件中
                busOut.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 缓冲流程操作2
     */
    public static void BufferedInputStreamTest2(){
        try {
            //在try()中打开文件会在结尾自动关闭
            FileReader fileReader = new FileReader("/Users/zdh/Downloads/nqv6u2YsHI.txt");
            FileWriter fos = new FileWriter("/Users/zdh/Downloads/temp/BufferedWriter.txt");
            BufferedReader busIn = new BufferedReader(fileReader);
            BufferedWriter busOut = new BufferedWriter(fos);
            char[] buf = new char[32];
            // byte[] buf = new byte[2];
            //读取字节的个数
            int hasRead;
            String line;
            // 每个char都占两个字节，每个字符或者汉字都是占2个字节，因此无论buf长度为多少，总是能读取中文字符长度的整数倍,不会乱码
            while ((line = busIn.readLine()) !=null) {
                // 如果buf的长度大于文件每行的长度，就可以完整输出每行，否则会断行。
                // 循环次数 = 文件字符数 除以 buf长度
                //System.err.println(line);
                busOut.write(line);
                //这里需要把缓冲区数据刷到文件中
                busOut.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

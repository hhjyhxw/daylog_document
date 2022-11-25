package com.icloud;

import java.io.*;

/**
 * 转换流（处理乱码问题）
 */
public class InOutPutStreamTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //output();
        intput();
    }

    public static void output() throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("/Users/zdh/Downloads/temp/tmp3.txt"),"GBK");
        //BufferedWriter br = new BufferedWriter(input);
        out.write("hi 哦看看");
        out.close();

    }

    public static void intput() throws ClassNotFoundException, IOException {
            InputStreamReader input = new InputStreamReader(new FileInputStream("/Users/zdh/Downloads/temp/tmp3.txt"),"GBK");
            BufferedReader br = new BufferedReader(input);
            System.err.println("content==="+br.readLine());
    }

}

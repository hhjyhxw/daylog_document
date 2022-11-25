package com.icloud.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

//https://www.bilibili.com/video/BV15B4y1u7Rn?p=6&vd_source=3573b65723446d336a46e980f0125101
public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/zdh/temp/filetest.txt");


        File parent = new File("/Users/zdh/");
        File child = new File(file,"/temp/filetest.txt");
        System.err.println(child.getName());


        File file2 = new File("/Users/zdh/","/temp/filetest2.txt");
        try {
            file2.exists();
            file2.isDirectory();
            file2.isFile();
            file2.createNewFile();
            file2.getName();
            file2.getAbsoluteFile();
            file2.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println(file2.getName());
    }
}

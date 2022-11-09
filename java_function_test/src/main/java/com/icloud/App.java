package com.icloud;

import java.io.UnsupportedEncodingException;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* System.out.println( "Hello World!" );
        //编码格式有 UTF-8 GB2312 GBK UTF-16 UTF-32
        try {
            int length = "oREekjpYosWes5b16jyeSTmv3CcAoREekjpYosWes5b16jyeSTmv3CcAoREekjpYosWes5b16jyeSTmv3CcAoREekjpYosWes5b16jyeSTmv3CcA".getBytes("UTF-8").length;
            System.err.println("length=="+length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        System.err.println(testFunction(3,(x)-> x*2+5));

    }

    public static int testFunction(int i, Function<Integer,Integer> function) {
        return function.apply(i);
    }
}

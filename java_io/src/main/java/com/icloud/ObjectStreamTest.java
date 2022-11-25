package com.icloud;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
       // output();
        intput();
    }

    public static void output() throws IOException {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/zdh/Downloads/temp/tmp3.txt"));
            //out.write(100);
            out.writeBoolean(true);
            out.writeLong(1L);
            Cat cat = new Cat();
            cat.setAge(10);
            cat.setName("豆豆");
            out.writeObject(cat);


    }

    public static void intput() throws ClassNotFoundException, IOException {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("/Users/zdh/Downloads/temp/tmp3.txt"));
            //System.err.println(" input.readInt()=="+ input.readInt());
            System.err.println(" input.readBoolean()=="+ input.readBoolean());
            System.err.println(" input.readLong()=="+ input.readLong());
            Object obj = input.readObject();
            System.err.println(" cat.class=="+ obj.getClass());
            System.err.println(" cat=="+ obj);
    }

    static class Cat implements Serializable{
        private String name;
        private int age;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

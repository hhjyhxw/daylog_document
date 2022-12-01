package com.icloud.template;

public class CommonUtils {

    public static <T> void swap(T a,T b){
        T temp = a;
        a = b;
        b = temp;
    }

    public  static <T> void print(T array[],int len){
        for (int i = 0; i < len; i++) {
            System.err.println(array[i]);
        }
    }

    public static void main(String[] args) {
        String aa = "aa";
        Integer a = new Integer(1000);
        Integer b = new Integer(2000);
        User user1 = new User("zhangs");
        User user2 = new User("lisi");
        System.err.println("user1 = "+user1.name);
        System.err.println("user2 = "+user2.name);
        swap(user1,user2);
        System.err.println("user1 = "+user1.name);
        System.err.println("user2 = "+user2.name);
    }



    static class User{
        private String name;
        public User(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}



package com.anlythree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("haha");
        list.add("haha");
        list.add("haha");
        System.out.println(list);
    }

    public void fun1(){
        String a = "哈";
        System.out.println(a.length()+"-"+a.codePointCount(0,a.length()));
        if(a instanceof String){

        }
        String intern = a.intern();
        System.out.println(intern);
    }

}

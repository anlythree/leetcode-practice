package com.anlythree;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if( i == 0){
                    break;
                }
                System.out.println("父循环第:"+i+"次"+"子循环第:"+j+"次");
            }
            System.out.println("父循环第:"+i+"次");
        }
    }

    public static List page(List list,int pageNum,int pageSize){
        return null;

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

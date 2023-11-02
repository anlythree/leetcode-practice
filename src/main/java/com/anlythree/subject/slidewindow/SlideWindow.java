package com.anlythree.subject.slidewindow;

public class SlideWindow {

    public static String dynamicPassword(String password, int target) {
        if(password == null || password.isEmpty() || target < 0){
            return password;
        }
        char[] result = new char[password.length()];
        char[] charArray = password.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i < target){
                result[password.length() - target +i] = charArray[i];
            }else{
                result[i-target] = charArray[i];
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String s3cur1tyC0d3 = dynamicPassword("s3cur1tyC0d3", 4);
        System.out.println(s3cur1tyC0d3);
    }

}

package com.strings;

public class ReverseArray {
    public static void main(String[] args) {
        String str = "Rajesh";
        String reverse = reverseSTR(str);
        System.out.println(reverse.toString());
    }

    public static String reverseSTR(String s){
        int start = 0;
        int end = s.length()-1;
        char[] ch = s.toCharArray();
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start ++;
            end --;
        }

        return new String(ch);
    }
}

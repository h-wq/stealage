package com.xupt.read.util;

public class Strings {
    public static boolean isEmptyOrNull(String str){
        if(str == null){
           return true;
        }

        if(str.length() == 0){
            return true;
        }

        return false;
    }
}

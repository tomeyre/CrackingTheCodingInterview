package org.example;

public class Strings {

    // first ask if its in ASCII or unicode
    //ASCII is a 7-bit character set containing 128 characters
    //As of Unicode version 15.1, there are 149,878 characters with code points, covering 161 modern and historical scripts, as well as multiple symbol sets.
    public static boolean checkUniqueUsingBooleanArray(String str){
        if(str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for(int i =0; i < str.length(); i++){
            int val = str.charAt(i);
            if(charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}

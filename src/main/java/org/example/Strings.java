package org.example;

import java.util.Arrays;

public class Strings {

    // solution 1 -------------------------------------------------------------------------------


    // you can argue that the time complexity is O(n) where n equals the length of the string or O(1) as you will never loop through more than 128 times.
    // the space complexity is O(1)
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

    // assumption the string only contains lowercase letters
    // how is this reduced space well we use an int instead of an array to hold our current checks
    // in the unicode table a = 97;
    // lets say the first letter of the string is c so val will be 99 - 97 = 2;
    // next line if ((O & 4) > 0) = false, this may seem obvious but this is a bitwise &
    // for a start how did we get 4? 1 << 2 = 100 and 100 converted from binary to int = 4
    // the rest of the calculation is 0 & 100 = 000 so it is not greater than 0.
    // next line 0 |= 4 answer 4
    // how did we get 4? 0 |= 4 is a bitwise operation 0 in binary is 0 and 4 in binary is 100 the or operation = 100
    // next letter is d so val = 3;
    // next line if ((4 & 8) > 0) false
    // 1 << 3 = 1000 = 8
    // 100 & 1000 = 0000 so not greater than 0
    // next line 4 |= 8
    // 100 |= 1000 = 1100 = 12
    public static boolean checkUniqueReducedSpaceComplexity(String str){
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    // space complexity is O(1) but time complexity goes up to O(n2)
    public static boolean checkUniqueNoAdditionalDataStructures(String str){
        for(int i = 0; i < str.length(); i++){
            for(int j = 1 + i; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n log(n)) for sorting but sorts take up more space
    public static boolean checkUniqueSortFirst(String str){
        str = stringSort(str);
        for(int i = 0; i < str.length(); i++){
            if(i == str.length() - 1) {
                return true;
            }
            if(str.charAt(i) == str.charAt(1 + i)) {
                return false;
            }
        }
        return true;
    }

    // solution 2 -------------------------------------------------------------------------------

    // perhaps the best most understandable way to implement however if efficiency is very important see checkEfficientPermutation
    public static boolean checkPermutationUsingSort(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        return stringSort(a).equals(stringSort(b));
    }

    // again we assume the char set is ASCII (always check the char set)
    // create an int array which sets all values to 0
    // add 1 to the array location for instance a = 97 if a was in the string twice letters[97] would equal 2
    // then loop through the next string and subtract 1.
    // if the value is less than 0 then there is a miss match in strings.
    // this works as we check length first
    public static boolean checkEfficientPermutation(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        int[] letters = new int[128];
        for(int i =0; i < a.length(); i++){
            letters[a.charAt(i)]++;
        }

        for(int i =0; i < b.length(); i++){
            letters[b.charAt(i)]--;
            if(letters[b.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }

    private static String stringSort(String a){
        char[] charsA = a.toCharArray();
        Arrays.sort(charsA);
        return new String(charsA);
    }

    // solution 3 -------------------------------------------------------------------------------

    //
    public static String urlify(char[] str, int length){
        int numberOfSpaces = countOfChar(str, 0, length, ' ');
        int newIndex = length - 1 + numberOfSpaces * 2;

        if(newIndex + 1 < str.length) str[newIndex + 1] = '\0';
        for(int oldIndex = length - 1; oldIndex >= 0; oldIndex -= 1){
            if(str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }
        return String.valueOf(str);
    }

    private static int countOfChar(char[] str, int start, int end, int target){
        int count = 0;
        for(int i = start; i < end; i++){
            if(str[i] == target){
                count++;
            }
        }
        return count;
    }

    // solution 4 -------------------------------------------------------------------------------

    public static void isPalindrome(String str){

    }
}

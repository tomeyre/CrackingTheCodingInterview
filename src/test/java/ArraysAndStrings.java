import org.junit.jupiter.api.Test;

import static org.example.Strings.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArraysAndStrings {

    private String strUnique = "abcdefghijklmnopqrstuvwxyz";
    private String strNotUnique = "abcdefghijklmnopabcderfghijklmnop";
    private String permutationA = "dog";
    private String permutationB = "god";
    private String permutationC = "odg   ";
    private String permutationD = "cat";
    private char[] plainUrlText = {'M','r',' ','T','h','o','m','a','s',' ','E','y','r','e',' ',' ',' ',' '};
    private String encodedUrlText = "Mr%20Thomas%20Eyre";
    private String palindromeInput = "caottac";


    // solution 1 -------------------------------------------------------------------------------
    // Implement an algorithm to determine if all characters in a string are unique.
    // What if you can't use additional data structures?

    // first ask if its in ASCII or unicode
    // ASCII is a 7-bit character set containing 128 characters
    // As of Unicode version 15.1, there are 149,878 characters with code points,
    // covering 161 modern and historical scripts, as well as multiple symbol sets.

    @Test
    public void isUnique_1_1_1(){
        assertTrue(checkUniqueUsingBooleanArray(strUnique));
        assertFalse(checkUniqueUsingBooleanArray(strNotUnique));
    }

    @Test
    public void isUnique_1_1_2(){
        assertTrue(checkUniqueReducedSpaceComplexity(strUnique));
        assertFalse(checkUniqueReducedSpaceComplexity(strNotUnique));
    }

    @Test
    public void isUnique_1_1_3(){
        assertTrue(checkUniqueNoAdditionalDataStructures(strUnique));
        assertFalse(checkUniqueNoAdditionalDataStructures(strNotUnique));
    }

    @Test
    public void isUnique_1_1_4(){
        assertTrue(checkUniqueSortFirst(strUnique));
        assertFalse(checkUniqueSortFirst(strNotUnique));
    }

    // solution 2 -------------------------------------------------------------------------------
    // Given two strings, write a method to decide if one is a permutation of the other.

    // first confirm some details
    // is the permutation case-sensitive?
    // is white space significant?
    // for this test we will assume white space is significant, and we don't care about case sensitivity

    @Test
    public void isPermutation_1_2_1(){
        assertTrue(checkPermutationUsingSort(permutationA, permutationB));
        assertFalse(checkPermutationUsingSort(permutationA, permutationC));
        assertFalse(checkPermutationUsingSort(permutationA, permutationD));
    }

    @Test
    public void isPermutation_1_2_2(){
        assertTrue(checkEfficientPermutation(permutationA, permutationB));
        assertFalse(checkEfficientPermutation(permutationA, permutationC));
        assertFalse(checkEfficientPermutation(permutationA, permutationD));
    }

    // solution 3 -------------------------------------------------------------------------------
    // Write a method to replace all the spaces in a string with %20. You are given the string which has sufficient
    // space at the end to hold the additional characters, so you are also given the true length of the string.
    // example
    // input:   "Mr John Smith     ", 13
    // output:  "Mr%20John%20Smith"
    // implemented with char arrays because strings are immutable

    @Test
    public void urlify_1_3_1(){
        assertEquals(encodedUrlText, urlify(plainUrlText, 14));
    }

    // solution 4 -------------------------------------------------------------------------------
    // Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word
    // or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome
    // does not need to be limited to just dictionary words. You can ignore the non-letter characters.

    @Test
    public void isPalindrome_1_4_1(){
        isPalindrome(palindromeInput);
    }
}

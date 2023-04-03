// Question: https://leetcode.com/problems/valid-palindrome-ii
// Created on: 2023-04-02

public class Solution {
    private boolean isValid(String s, int l, int r, boolean oneDeleted) {
        if (l >= r) return true;

        if (s.charAt(l) == s.charAt(r)) return isValid(s, l+1, r-1, oneDeleted);

        if (!oneDeleted) 
            return isValid(s, l+1, r, true) || isValid(s, l, r-1, true);
        
        return false;
    }

    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length()-1, false);
    }
}
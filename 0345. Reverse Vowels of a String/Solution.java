// Question: https://leetcode.com/problems/reverse-vowels-of-a-string/
// Created on: 2022-11-04

class Solution {
    
    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < vowels.length(); ++i) {
            if (c == vowels.charAt(i)) return true;
        }
        return false;
    }
    
    public String reverseVowels(String s) {
        char[] chrs = s.toCharArray();
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isVowel(chrs[l])) l++;
            while (r > l && !isVowel(chrs[r])) r--;
            if (l < r) {
                char temp = chrs[l];
                chrs[l] = chrs[r];
                chrs[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(chrs);
    }
}
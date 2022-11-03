// Question: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
// Created on: 2022-11-03

class Solution {
    
    private Map<String, Integer> occrs;
    
    public int longestPalindrome(String[] words) {
        occrs = new HashMap<>();
        for (String word: words) {
            if (occrs.containsKey(word)) {
                occrs.put(word, occrs.get(word) + 1);
            } else {
                occrs.put(word, 1);
            }
        }
        
        int res = 0;
        boolean hasMiddleOdd = false;
        for (String str: occrs.keySet()) {
            String revStr = "";
            revStr += str.charAt(1);
            revStr += str.charAt(0);
            
            if (str.equals(revStr)) {
                int count = occrs.get(str);
                if (count % 2 == 1) {
                    hasMiddleOdd = true;
                    res += (count-1)*2;
                } else {
                    res += count*2;
                }
            } else {
                int num1 = occrs.getOrDefault(str, 0);
                int num2 = occrs.getOrDefault(revStr, 0);
                res += Math.min(num1, num2)*2;
            }
        }
        return hasMiddleOdd ? res+2 : res;
    }
}
// Question: https://leetcode.com/problems/longest-substring-without-repeating-characters
// Created on: 2023-03-25

class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToPos = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!charToPos.containsKey(s.charAt(i))) {
                charToPos.put(s.charAt(i), i);
                res = Math.max(res, i-left+1);
                continue;
            }
            left = Math.max(left, charToPos.get(s.charAt(i))+1);
            charToPos.put(s.charAt(i), i);
            res = Math.max(res, i-left+1);
        }

        return res;
    }

}

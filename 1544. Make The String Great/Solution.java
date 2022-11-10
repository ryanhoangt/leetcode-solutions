// Question: https://leetcode.com/problems/make-the-string-great/
// Created on: 2022-11-10

class Solution {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 0) {
            int p1 = 0, p2 = 1;
            boolean isGood = true;
            while (p2 < sb.length()) {
                if (Math.abs(sb.charAt(p2) - sb.charAt(p1)) == 32) {
                    sb = sb.delete(p1, p2 + 1);
                    isGood = false;
                    break;
                } 
                p1++; p2++;
            }
            if (isGood) break;
        }
        return sb.toString();
    }
    
}
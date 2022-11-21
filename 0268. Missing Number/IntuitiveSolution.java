// Question: https://leetcode.com/problems/missing-number/
// Created on: 2022-11-21

class Solution {
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] existed = new int[n+1];
        for (int num: nums) {
            existed[num] = 1;
        }
        for (int i = 0; i <= n; ++i) {
            if (existed[i] == 0) return i;
        }
        return -1;
    }
}
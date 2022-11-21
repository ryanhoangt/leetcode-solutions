// Question: https://leetcode.com/problems/missing-number/
// Created on: 2022-11-21

class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length, curSum = 0;
        for (int num: nums) {
            curSum += num;
        }
        return n*(n+1)/2 - curSum;
    }
}
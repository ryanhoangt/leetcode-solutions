// Question: https://leetcode.com/problems/container-with-most-water
// Created on: 2023-03-09

public class Solution {

    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0, right = n-1;
        while (right > left) {
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, (right-left) * h);
            
            if (height[right] >= height[left]) {
                left++;
            } else right--;
        }

        return res;
    }

}
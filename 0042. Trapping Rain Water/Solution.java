// Question: https://leetcode.com/problems/trapping-rain-water
// Created on: 2023-03-18

public class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int[] maxHeightLess = new int[n];
        int[] maxHeightGreater = new int[n];
        maxHeightLess[0] = -1;
        maxHeightGreater[n-1] = -1;

        for (int i = 1; i < n; i++) 
            maxHeightLess[i] = Math.max(
                maxHeightLess[i-1], 
                height[i-1]
            );

        for (int i = n-2; i >= 0; i--) 
            maxHeightGreater[i] = Math.max(
                maxHeightGreater[i+1], 
                height[i+1]
            );

        int totalWater = 0;
        for (int i = 1; i < n-1; i++) {
            int maxToTrap = Math.min(
                maxHeightLess[i],
                maxHeightGreater[i]
            );
            totalWater += (maxToTrap > height[i] ? (maxToTrap - height[i]) : 0);
        }
        return totalWater;
    }

}
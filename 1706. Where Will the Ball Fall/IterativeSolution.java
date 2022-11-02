// Question: https://leetcode.com/problems/where-will-the-ball-fall/
// Created on: 2022-11-03

class IterativeSolution {
    
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        
        for (int c = 0; c < n; ++c) {
            int curCol = c;
            for (int r = 0; r < m; ++r) {
                if (grid[r][curCol] == 1 && (curCol < n-1) && grid[r][curCol] == grid[r][curCol+1]) { // flow right
                    curCol++;
                    continue;
                }
                if (grid[r][curCol] == -1 && (curCol > 0) && grid[r][curCol] == grid[r][curCol-1]) { // flow left
                    curCol--;
                    continue;
                }
                curCol = -1;
                break;
            }
            res[c] = curCol;
        }
        
        return res;
    }
}
// Question: https://leetcode.com/problems/where-will-the-ball-fall/
// Created on: 2022-11-03

class DFSSolution {
    
    int[][] grid;
    int m;
    int n;
    
    private int bottomColumn(int r, int c) {
        if (r == m) return c;
        
        if (grid[r][c] == 1 && (c < n-1) && grid[r][c] == grid[r][c+1]) // flow right
            return bottomColumn(r+1, c+1);
        if (grid[r][c] == -1 && (c > 0) && grid[r][c] == grid[r][c-1]) // flow left
            return bottomColumn(r+1, c-1);
        
        return -1;
    }
    
    public int[] findBall(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = bottomColumn(0, i);
        }
        return res;
    }
}
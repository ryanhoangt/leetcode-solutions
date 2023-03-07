// Question: https://leetcode.com/problems/game-of-life
// Created on: 2023-03-07

public class Solution2 {

    private int m, n;
    private int[][] board;

    private int numLiveNeighbors(int r, int c) {
        int cMin = Math.max(0, c-1);
        int cMax = Math.min(c+1, n-1);
        int rMin = Math.max(0, r-1);
        int rMax = Math.min(r+1, m-1);
        int res = 0;
        for (int i = rMin; i <= rMax; i++) {
            for (int j = cMin; j <= cMax; j++) {
                if (i == r && j == c) continue;
                res += Math.abs(board[i][j]) == 1 ? 1 : 0;
            }
        }
        return res;
    }

    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int numLive = numLiveNeighbors(i, j);
                if (board[i][j] == 1)
                    board[i][j] = (numLive == 2 || numLive == 3) ? 1 : -1;
                else if (numLive == 3) 
                    board[i][j] = 2;
            }
        }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = board[i][j] > 0 ? 1 : 0;

        return;
    }

}
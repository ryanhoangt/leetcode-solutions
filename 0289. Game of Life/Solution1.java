// Question: https://leetcode.com/problems/game-of-life
// Created on: 2023-03-07

public class Solution1 {

    private int m, n;
    private int[][] board;

    private int sumOfNeighbors(int r, int c) {
        int cMin = Math.max(0, c-1);
        int cMax = Math.min(c+1, n-1);
        int rMin = Math.max(0, r-1);
        int rMax = Math.min(r+1, m-1);
        int res = 0;
        for (int i = rMin; i <= rMax; i++)
            for (int j = cMin; j <= cMax; j++)
                res += board[i][j];

        return res - board[r][c];
    }

    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;

        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = sumOfNeighbors(i, j);
                if (board[i][j] == 1)
                    newBoard[i][j] = (sum == 2 || sum == 3) ? 1 : 0;
                else if (sum == 3) 
                    newBoard[i][j] = 1;
            }
        }
        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                board[i][j] = newBoard[i][j];

        return;
    }

}
// Question: https://leetcode.com/problems/design-tic-tac-toe/
// Created on: 2023-03-05

class TicTacToe {

    private int n;
    private int[] hSum;
    private int[] vSum;
    private int diag03, diag12;

    public TicTacToe(int n) {
        this.n = n;
        this.hSum = new int[n];
        this.vSum = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int amt = (player == 1) ? 1 : -1;

        if (row == col) diag03 += amt;
        if (row + col == n-1) diag12 += amt;
        hSum[row] += amt;
        vSum[col] += amt;

        if (Math.abs(hSum[row]) == n || Math.abs(vSum[col]) == n ||
            Math.abs(diag03) == n || Math.abs(diag12) == n)
            return player;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
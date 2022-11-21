// Question: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
// Created on: 2022-11-21

class Solution {

    private static int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    private int[] entrance;
    
    private boolean isExit(Integer[] pos) {
        int r = pos[0], c = pos[1];
        return !(r == entrance[0] && c == entrance[1]) 
            && (r == 0 || c == 0 || r == m-1 || c == n-1);
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        this.m = maze.length;
        this.n = maze[0].length;
        this.entrance = entrance;
        boolean[][] queued = new boolean[m][n];
        int res = 0;
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{entrance[0], entrance[1]});
        queued[entrance[0]][entrance[1]] = true;
        
        while (!q.isEmpty()) {
            int curLen = q.size();
            
            for (int i = 0; i < curLen; i++) {
                Integer[] curPos = q.remove();
                if (isExit(curPos)) return res;
                
                for (int[] dir: DIRS) {
                    int nR = curPos[0] + dir[0];
                    int nC = curPos[1] + dir[1];
                    if (nR < 0 || nC < 0 || nR >= m || nC >= n) continue;
                    if (maze[nR][nC] ==  '.' && !queued[nR][nC]) {
                        queued[nR][nC] = true;
                        q.add(new Integer[]{nR, nC});
                    }
                }
            }
            res += 1;
        }
        
        return -1;
    }
}
// Question: https://leetcode.com/problems/minimum-genetic-mutation/
// Created on: 2022-11-02

class Solution {
    
    private int distance(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < 8; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) res++;
        }
        return res;
    }
    
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        int level = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int numNodes = q.size();
            for (int i = 0; i < numNodes; ++i) {
                String cur = q.remove();
                visited.add(cur);
                if (cur.equals(end)) return level;
                
                for (String adj: bank) {
                    if (distance(adj, cur) == 1 && !visited.contains(adj)) q.add(adj);
                }
            }
            level++;
        }
        return -1;
    }
}
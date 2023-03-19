// Question: https://leetcode.com/problems/time-needed-to-inform-all-employees
// Created on: 2023-03-19

public class BFSSolution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] subords = new List[n];
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            int curManagerId = manager[i];
            if (subords[curManagerId] == null) 
                subords[curManagerId] = new ArrayList<>();
            subords[curManagerId].add(i);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        int ans = 0;

        while (!q.isEmpty()) {
            int curId = q.peek()[0];
            int timeWhenReceived = q.peek()[1];
            q.poll();
            ans = Math.max(ans, timeWhenReceived);

            if (subords[curId] != null) {
                for (int j = 0; j < subords[curId].size(); j++) {
                    int subordId = subords[curId].get(j);
                    q.add(new int[]{subordId, timeWhenReceived + informTime[curId]});            
                }
            }
        }
        
        return ans;
    }
    
}
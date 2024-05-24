class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int completeComponents = 0;
        // make an adj. list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++) {
            if (!visited[i]) {
                int[] temp = new int[2];
                dfs(i,adj,visited,temp);
                if (temp[0]*(temp[0]-1)/2 == temp[1]/2) {
                    completeComponents+=1;
                }
            }
        }
        return completeComponents;
    }

    public void dfs(int node,List<List<Integer>> adj,boolean[] visited,int[] temp) {
        temp[0]+=1;
        temp[1]+=adj.get(node).size();
        visited[node] = true;
        for(int it:adj.get(node)) {
            if (!visited[it]) {
                dfs(it,adj,visited,temp);
            }
        }
    }
}
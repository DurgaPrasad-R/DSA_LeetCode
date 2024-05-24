class Solution {
    public int findCircleNum(int[][] adj) {
        int components = 0;
        int V = adj.length;
        boolean[] visited = new boolean[V+1];
        for(int i = 1;i<=V;i++) {
            if (!visited[i]) {
                components++;
                dfs(i,V,adj,visited);
            }
        }
        return components;
    }
    public static void dfs(int node,int V,int[][] adj,boolean[] visited) {
        visited[node] = true;
        for(int i = 0;i<V;i++) {
            int it = adj[node-1][i];
            if (i+1!=node && it == 1 && !visited[i+1]) {
                dfs(i+1,V,adj,visited);
            }
        }
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(dfs(i,j,grid,visited),ans);
                }
            }
        }
        return ans;
    }

    public boolean isValid(int x,int y,int[][] grid) {
        if (x>=0 && x<grid.length && y>=0 && y<grid[0].length) {
            return true;
        }
        return false;
    }

    public int dfs(int i,int j,int[][] grid,boolean[][] visited) {
        int cnt = 1;
        visited[i][j] = true;
        int[] xOff = {-1,0,1,0};
        int[] yOff = {0,1,0,-1};
        for(int off = 0;off<4;off++) {
            int x = i+xOff[off];
            int y = j+yOff[off];
            if (isValid(x,y,grid) && !visited[x][y] && grid[x][y] == 1) {
                cnt+=dfs(x,y,grid,visited);
            }
        }
        return cnt;
    }
}
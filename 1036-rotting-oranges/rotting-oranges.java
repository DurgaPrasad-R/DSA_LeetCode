class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public boolean isValid(int x,int y,int[][] grid) {
        if (x>=0 && x<grid.length && y>=0 && y<grid[0].length) {
            return true;
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        int[] xOff = {-1,0,1,0};
        int[] yOff = {0,1,0,-1};
        int m = grid.length,n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int c = 0;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i,j));
                }
                if (grid[i][j] == 1) {
                    c+=1;
                }
            }
        }
        if (c == 0) return 0;
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            time+=1;
            for(int i = 0;i<size;i++) {
                Pair curr = q.poll();
                for(int off = 0;off<4;off++) {
                    int x = curr.x+xOff[off];
                    int y = curr.y+yOff[off];
                    if (isValid(x,y,grid) && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        c-=1;
                        q.offer(new Pair(x,y));
                    }
                }
            }
        }
        if (c == 0) {
            return time-1;
        }
        return -1;
    }
}
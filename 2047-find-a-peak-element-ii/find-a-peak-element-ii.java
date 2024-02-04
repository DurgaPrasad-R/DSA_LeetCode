class Solution {
    public int[] findPeakGrid(int[][] G) {
      int n = G.length,m = G[0].length;
        int[] ans = new int[2];
        int low = 0,high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int maxRowIdx = findMaxRow(G,n,m,mid);
            int left = (mid-1>=0) ? G[maxRowIdx][mid - 1]:-1;
            int right = (mid+1<m) ? G[maxRowIdx][mid+1]:-1;
            int mainEle = G[maxRowIdx][mid];
            if (mainEle > left && mainEle > right){
                return new int[] {maxRowIdx,mid};
            } else if (mainEle < left){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
    public static int findMaxRow(int[][] G,int n,int m,int targetCol){
        int maxValue = -1;
        int maxIdx = -1;
        for(int i=0;i<n;i++){
            int ele = G[i][targetCol];
            if (ele > maxValue){
                maxValue = ele;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
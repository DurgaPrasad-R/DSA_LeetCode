class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length,flag = -1;
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(newInterval[1] < intervals[i][0]){
                res.add(new int[] {newInterval[0],newInterval[1]});
                flag = i;
                break;
            }
            else if (newInterval[0] > intervals[i][1]){
                res.add(new int[] {intervals[i][0],intervals[i][1]});
            } else {
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        if (flag!=-1){
            for(int i = flag;i<n;i++){
                res.add(new int[] {intervals[i][0],intervals[i][1]});
            }
        }
        else {
            res.add(new int[] {newInterval[0],newInterval[1]});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;

    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i = 0;i<n;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j = i+1;j<n;j++){
                if (end >= intervals[j][0]){
                    end = Math.max(end,intervals[j][1]);
                } else {
                    break;
                }
            }
            List<Integer> temp = Arrays.asList(start,end);
            ans.add(temp);
        }
        int newLen = ans.size();
        int[][] res = new int[newLen][2];
        for(int i = 0;i<newLen;i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }
}
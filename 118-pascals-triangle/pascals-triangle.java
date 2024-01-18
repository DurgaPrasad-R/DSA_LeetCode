class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int j = 1;j<=n;j++)
        {
            List<Integer> rowAns = new ArrayList<>();
            int res = 1;
            for(int i = 0;i<j;i++){
                if (i == 0 || i == j-1){
                    rowAns.add(1);
                } else {
                    res = res * (j - i);
                    res = res / (i);
                    rowAns.add(res);
                }
            }
            ans.add(rowAns);
        }
        return (ans);
    }
}
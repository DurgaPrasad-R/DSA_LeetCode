class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombosSum(candidates,0,target,new ArrayList<>(),result);
        return result;
    }
    public void findCombosSum(int[] candidates,int idx,int target,List<Integer> ds,List<List<Integer>> result){
        if (target == 0)        {
            result.add(new ArrayList<>(ds));
            return;
        }
        else{
            int n = candidates.length;
            for(int i = idx;i<n;i++){
                if (i>idx && candidates[i] == candidates[i-1]) continue;
                if (candidates[i] > target) break;
                ds.add(candidates[i]);
                findCombosSum(candidates,i+1,target-candidates[i],ds,result);
                ds.remove(ds.size()-1);
            }
        }
    }
}
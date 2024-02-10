class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0,candidates,target,new ArrayList<>(),result);
        return result;
    }
    public void findCombinations(int idx, int[] arr,int target,List<Integer> ds,List<List<Integer>> result){
        if (idx == arr.length){
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[idx] <= target){
            ds.add(arr[idx]);
            findCombinations(idx,arr,target-arr[idx],ds,result);
            ds.remove(ds.size()-1);
        }
        findCombinations(idx+1,arr,target,ds,result);
    }
}
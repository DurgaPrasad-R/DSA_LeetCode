class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0,count = 0,n = nums.length;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        for(int i = 0;i<n;i++){
            sum+=nums[i];
            if (prefixSum.containsKey(sum-goal)){
                count+=prefixSum.get(sum-goal);
            }
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
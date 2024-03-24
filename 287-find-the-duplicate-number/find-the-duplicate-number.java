class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> hset = new HashSet<>();
        for(int i = 0;i<n;i++){
            if (hset.contains(nums[i])){
                return nums[i];
            } else{
                hset.add(nums[i]);
            }
        }
        return -1;
    }
}
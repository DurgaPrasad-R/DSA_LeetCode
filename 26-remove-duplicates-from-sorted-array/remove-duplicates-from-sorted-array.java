class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if (!set.contains(nums[i])){
                nums[set.size()] = nums[i];
                set.add(nums[i]);
            } else {
                continue;
            }
        }
        return set.size();
    }
}
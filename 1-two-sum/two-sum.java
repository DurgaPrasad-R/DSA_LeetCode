class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0;i<n;i++){
            if (hmap.containsKey(target-nums[i])){
                res[0] = hmap.get(target-nums[i]);
                res[1] = i;
                break;
            } else{
                hmap.put(nums[i],i);
            }
        }
        return res;
    }
}
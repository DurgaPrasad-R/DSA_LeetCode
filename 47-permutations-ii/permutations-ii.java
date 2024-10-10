class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(nums,0,nums.length,res,set);
        return res;
    }
    public static void helper(int[] nums,int k,int n,List<List<Integer>> res,Set<List<Integer>> set) {
        if (k == n - 1) {
            List<Integer> temp = new ArrayList<>();
            for(int num:nums) {
                temp.add(num);
            }
            if (!set.contains(temp)) {
                res.add(temp);
                set.add(temp);
            }
            return;
        } else {
            for(int i = k;i<n;i++) {
                swap(nums,i,k);
                helper(nums,k+1,n,res,set);
                swap(nums,i,k);
            }
        }
    }

    public static void swap(int[] nums,int i,int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}
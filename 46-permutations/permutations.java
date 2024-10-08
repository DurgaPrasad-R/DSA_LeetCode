class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        helper(nums,0,n,res);

        return res;
    }

    public static void helper(int[] nums,int k,int n,List<List<Integer>> res) {
        if (k == n - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        } else {
            for(int i = k;i<n;i++) {
                swap(nums,k,i);
                helper(nums,k+1,n,res);
                swap(nums,k,i);
            }
        }
    }

    public static void swap(int[] nums,int idx,int sIdx) {
        int temp = nums[idx];
        nums[idx] = nums[sIdx];
        nums[sIdx] = temp;
    }
}
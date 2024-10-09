class Solution {
    public void reverse(int[] nums,int l,int h) {
        while (l<h) {
            int t = nums[l];
            nums[l] = nums[h];
            nums[h] = t;
            l++;
            h--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int bp = -1;
        for(int i = n-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                bp = i;
                break;
            }
        }
        if (bp == -1) {
            Arrays.sort(nums);
        } else {
            int swap = -1;
            for(int i = n-1;i>=0;i--) {
                if (nums[bp] < nums[i]) {
                    swap = i;
                    break;
                }
            }
            int t = nums[bp];
            nums[bp] = nums[swap];
            nums[swap] = t;
            reverse(nums,bp+1,n-1);
        }
        
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        int h = nums.length;
        int[] b = new int[h];
        for(int i =0;i<h;i++){
            b[i] = nums[i];
        }
        for(int i = 0;i<h;i++){
            nums[(i+k)%h] = b[i];
        }
    }
}
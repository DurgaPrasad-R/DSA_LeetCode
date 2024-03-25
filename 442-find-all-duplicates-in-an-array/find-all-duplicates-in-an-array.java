class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ar = new ArrayList<>();
        int i = 0,n = nums.length;
        while(i<n) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums,i,correct);
            } else {
                i++;
            }
        }
        for(i = 0;i<n;i++) {
            if (nums[i]-1 != i) {
                ar.add(nums[i]);
            }
        }
        return ar;
    }
    public void swap(int[] nums,int f,int l) {
        int temp = nums[f];
        nums[f] = nums[l];
        nums[l] = temp;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // To find it we need the prefix product and the suffix product
        // So two arrays to keep track of prefix and suffix products
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            if (i == 0){
                prefix[i] = nums[i];
            } else {
                prefix[i] = nums[i]*prefix[i-1];
            }
        }
        for(int i = n-1;i>=0;i--){
            if (i == n-1){
                suffix[i] = nums[i];
            } else {
                suffix[i] = nums[i]*suffix[i+1];
            }
        }
        for(int i = 0;i<n;i++){
            if (i == 0){
                res[i] = suffix[i+1];
            } else if (i == n-1){
                res[i] = prefix[i-1];
            } else {
                res[i] = prefix[i-1]*suffix[i+1];
            }
        }
        return res;
    }
}
class Solution {
    public int maxProduct(int[] arr) {
        int n=arr.length,max = Integer.MIN_VALUE,prefix = 1,suffix = 1;
        for(int i = 0;i<n;i++){
            if (prefix == 0){
                prefix = 1;
            } 
            if (suffix == 0){
                suffix = 1;
            }
            prefix = prefix * arr[i];
            suffix = suffix * arr[n-1-i];
            max = Math.max(max, Math.max(prefix,suffix));
        }
        return max;
    }
}
class Solution {
    public int splitArray(int[] nums, int k) {
        return findPages(nums,nums.length,k);
    }
    public static int findPages(int []arr, int n, int m) {
        // Write your code here.
        if (m>n){
            return -1;
        }
        int[] Maxpages = maxPages(arr,n);
        int low = Maxpages[0],high = Maxpages[1];
        while(low <= high){
            int mid = (low+high)/2;
            if (helper(arr,n,mid) > m){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }
    public static int helper(int[] arr,int n,int pages){
        int cntPages = 0,students = 1;
        for(int i = 0;i<n;i++)
        {
            if (pages >= cntPages+arr[i]){
                cntPages+=arr[i];
            } else {
                students+=1;
                cntPages = arr[i];
            }
        }
        return students;
    }
    public static int[] maxPages(int[] arr,int n){
        int max = arr[0],s = arr[0];
        for(int i = 1;i<n;i++)
        {
            s+=arr[i];
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return new int[] {max,s};
    }
}
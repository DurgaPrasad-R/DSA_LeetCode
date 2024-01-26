class Solution {
    public int minDays(int[] arr, int b, int r) {
        int n = arr.length;
        if ((long)r*b > n){
            return -1;
        }
        int[] mnmx = miniMax(arr,n);
        int low = mnmx[0],high = mnmx[1];
        while (low<=high){
            int mid = (low+high)/2;
            if (makeBoquets(arr,mid,r,b)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
        
        
    }
    public static boolean makeBoquets(int[] arr,int day,int r,int b)
    {
        int mx = 0,cnt = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if (arr[i]>day){
                mx+=(long)cnt/r;
                cnt = 0;
            } else {
                cnt+=1;
            }
        }
        mx+=cnt/r;
        return mx>=b;
    }
    public static int[] miniMax(int[] arr,int n){
        int mini = arr[0],maxi = arr[0];
        for(int i = 1;i<n;i++){
            if (arr[i] > maxi){
                maxi = arr[i];
            }
            if (arr[i] < mini){
                mini = arr[i];
            }
        }
        return new int[] {mini,maxi};
    }
}
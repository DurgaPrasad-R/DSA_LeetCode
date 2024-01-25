class Solution {
    public int minEatingSpeed(int[] v, int h) {
        int low = 1,high = findMax(v,v.length);
        while(low<=high)
        {
            int mid = (low+high)/2;
            int totalH = calculateTym(v,mid);
            if (totalH<=h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int calculateTym(int[] v,int hourly){
        int n = v.length,req = 0;
        for(int i = 0;i<n;i++)
        {
            req+=Math.ceil((double)v[i]/(double)hourly);
        }
        return req;
    }
    public static int findMax(int[] arr,int n){
        int max = arr[0];
        for(int i = 1;i<n;i++)
        {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
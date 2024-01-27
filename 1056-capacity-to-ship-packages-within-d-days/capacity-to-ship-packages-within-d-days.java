class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int[] result = returnMxSum(weights,n);
        int low = result[0], high = result[1];
        while(low <= high){
            int mid = (low+high)/2;
            if (processDays(weights,mid) <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int processDays(int[] weights,int c){
        int load = 0,days = 1,n = weights.length;
        for(int i = 0;i<n;i++)
        {
            if (load+weights[i] > c){
                days+=1;
                load = weights[i];
            } else {
                load+=weights[i];
            }
        }
        return days;
    }
    public int[] returnMxSum(int[] arr,int n)
    {
        int mx = arr[0], s = arr[0];
        for(int i = 1;i<n;i++){
            s+=arr[i];
            if (mx < arr[i]){
                mx = arr[i];
            }
        }
        return new int[] {mx,s};
    }
}
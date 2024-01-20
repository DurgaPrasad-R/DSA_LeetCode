class Solution {
    public int findMin(int[] arr) {
        int start = 0,end = arr.length-1,min = Integer.MAX_VALUE;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if (arr[start] <= arr[mid]){
                min = Math.min(min,arr[start]);
                start = mid + 1;
            } else {
                min = Math.min(min,arr[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
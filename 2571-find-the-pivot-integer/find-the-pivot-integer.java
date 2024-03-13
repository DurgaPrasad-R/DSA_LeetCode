class Solution {
    public int pivotInteger(int n) {
        int left = 1,right = n;
        int totalSum = n*(n+1)/2;
        while(left<=right){
            int midNum = (left+right)/2;
            int firstSum = (midNum*(midNum+1))/2;
            int secondSum = totalSum - firstSum + midNum;
            if (firstSum == secondSum) return midNum;
            else if (firstSum < secondSum) left = midNum + 1;
            else right = midNum - 1;
        }
        return -1;
    }
}
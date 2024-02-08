class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,maxBef = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i = 0;i<n;i++){
            if (prices[i] < min) min = prices[i];
            maxBef = Math.max(maxBef,prices[i]-min);
        }
        return maxBef;
    }
}
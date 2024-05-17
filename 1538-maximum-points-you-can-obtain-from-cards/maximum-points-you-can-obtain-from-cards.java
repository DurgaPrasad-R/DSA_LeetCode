class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0,r = k - 1;
        int leftSum = 0,rightSum = 0,maxSum = 0;
        for(int i = l;i<=r;i++) {
            leftSum+=cardPoints[i];
        }
        maxSum = leftSum;
        int rIdx = cardPoints.length - 1;
        for(int i = k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rIdx];
            rIdx--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}
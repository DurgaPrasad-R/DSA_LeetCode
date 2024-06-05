class Solution {
    public int maxArea(int[] height) {
        int l = 0,r = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l<r) {
            int h = Math.min(height[l],height[r]);
            int b = r - l;
            maxArea = Math.max(maxArea,b*h);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
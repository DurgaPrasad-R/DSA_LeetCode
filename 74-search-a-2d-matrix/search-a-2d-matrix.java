class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        int low = 0,high = n*m - 1; 
        while(low<=high){
            int mid = (low+high)/2;
            int eleRow = mid/m,eleCol = mid%m;
            int searchEle = matrix[eleRow][eleCol];
            if (searchEle == target){
                return true;
            } else if (searchEle > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
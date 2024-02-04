class Solution {
    public boolean searchMatrix(int[][] MATRIX, int target) {
        int n = MATRIX.length,m = MATRIX[0].length;
        int row = 0,col = m - 1;
        while(row<n && col>=0){
            if (MATRIX[row][col] == target){
                return true;
            } else if (MATRIX[row][col] > target){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
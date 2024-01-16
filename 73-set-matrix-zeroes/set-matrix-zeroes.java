class Solution {
    public void setZeroes(int[][] a) {
        int rows = a.length,cols = a[0].length;
        int[] rowEms = new int[rows];
        int[] colEms = new int[cols];

        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if (a[i][j] == 0){
                    rowEms[i] = 1;
                    colEms[j] = 1;
                }
            }
        }
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if (rowEms[i] == 1 || colEms[j] == 1)
                {
                    a[i][j] = 0;
                }
            }
        }
    }
}
class Solution {
    private void swap(int[][] matrix, int i, int j, int m, int n){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
    public void rotate(int[][] matrix) {
        // transpose
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                swap(matrix, i, j, j, i);
            }
        }
        int l = 0;
        int r = matrix.length - 1;
        while(l < r){
            for(int i=0; i<matrix.length; i++){
                swap(matrix, i, l, i, r);
            }
            l++;
            r--;
        }
    }
}
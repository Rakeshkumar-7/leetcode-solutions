class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Get the correct row
        int low = 0;
        int high = m-1;
        int mid;
        while(low < high){
            mid = (low + high)/2;
            if(matrix[mid][n-1] >= target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        // Search the row
        int row = high;
        low = 0;
        high = n-1;
        while(low < high){
            mid = (low + high)/2;
            if(matrix[row][mid] < target){
                low = mid + 1;
            }else if(matrix[row][mid] > target){
                high = mid;
            }else{
                return true;
            }
        }

        if(matrix[row][high] == target) return true;

        return false;
    }
}
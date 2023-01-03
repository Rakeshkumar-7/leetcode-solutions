class Solution {
    private boolean isValid(char[][] board, int x, int y, int num){
        // check row
        for(int i=0; i<9; i++){
            if(board[x][i] == (char)(num + '0')){
                return false;
            }
        }
        
        // check column
        for(int i=0; i<9; i++){
            if(board[i][y] == (char)(num + '0')){
                return false;
            }
        }

        // check sub-box
        int sr = 3*(x/3);
        int sc = 3*(y/3);
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j] == (char)(num + '0')){
                    return false;
                }
            }
        }

        return true;
    }
    private boolean util(char[][] board, int x, int y){
        if(y >= 9){
            y = 0;
            x++;
        }
        if(x == 9 && y == 0){
            return true;
        }
        if(board[x][y] == '.'){
            for(int i=1; i<=9; i++){
                if(isValid(board, x, y, i)){
                    board[x][y] = (char)(i + '0');
                    if(util(board, x, y+1)) return true;
                    board[x][y] = '.';
                }
            }
        }else{
            return util(board, x, y+1);
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        util(board, 0, 0);
    }
}
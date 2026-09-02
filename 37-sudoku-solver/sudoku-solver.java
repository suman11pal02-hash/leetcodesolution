class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board)
    {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++)
            {
                // Find an empty cell
                if(board[i][j] == '.'){
                    // Try filling it with digits '1' to '9'
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Place the character

                            if(solve(board)){
                                return true; //Found a valid solution
                            }
                            else{
                                board[i][j] = '.'; //Backtrack
                            }
                        }
                    }
                    return false; //no valid digit can be placed in this cell
                }
            }
        }
        return true; //All cells filled successfully
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {
            //Check row duplicate
            if (board[row][i] == c) return false;
            
            //Check column duplicate
            if (board[i][col] == c) return false;
            
            //Check 3x3 sub-box duplicate
            int subBoxRow = 3 * (row / 3) + i /3;
            int subBoxCol = 3 * (col / 3) + i % 3;
            if(board[subBoxRow][subBoxCol] == c) return false;
        }
        return true;
    }
}
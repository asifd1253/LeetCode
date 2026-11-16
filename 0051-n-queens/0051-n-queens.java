class Solution {
    List<List<String>> res = new ArrayList<>();
    int N;
    public boolean isValidPosition(char board[][], int row, int col){
        // check from top
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // check from left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        // check from right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<N; i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    public void solve(char board[][], int row){
        if(row == N){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<N; i++){
                String curStr = new String(board[i]);
                temp.add(curStr);
            }
            res.add(temp);
            return;
        }

        for(int col=0; col<N; col++){
            if(isValidPosition(board, row, col)){
                board[row][col] = 'Q';
                solve(board, row+1);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        N = n;

        char board[][] = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        solve(board, 0);

        return res;
    }
}
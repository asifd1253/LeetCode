class Solution {
    public List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return result;
        }

        List<String> board = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++){
                row.append('.');
            }
            board.add(row.toString());
        }

        solve(board, 0);

        return result;
    }
    public void solve(List<String> board, int row){
        if(row == board.size()){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int col=0; col<board.size(); col++){
            if(isValid(board, row, col)){
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(board, row+1);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }
    public boolean isValid(List<String> board, int row, int col){
        //for upside check
        for(int i=row; i>=0; i--){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        //for left diagonal side
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //for right diagonal side
        for(int i=row, j=col; i>=0 && j<board.size(); i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }
}
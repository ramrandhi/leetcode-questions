package patterns.graphs.matrix;

// https://leetcode.com/problems/surrounded-regions/

public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        for(int j = 0;j<column;j++) {
            if(!visited[0][j] && board[0][j] == 'O') {
                dfs(0, j, board, visited, delRow, delCol, row, column);
            }
            if(!visited[row - 1][j] && board[row - 1][j] == 'O') {
                dfs(row - 1, j, board, visited, delRow, delCol, row, column);
            }
        }
        for(int i= 0;i<row;i++) {
            if(!visited[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, visited, delRow, delCol, row, column);
            }
            if(!visited[i][column - 1] && board[i][column-1] == 'O') {
                dfs(i, column - 1, board, visited, delRow, delCol, row, column);
            }
        }
        for(int i = 0;i<row;i++) {
            for(int j = 0; j<column;j++) {
                if(!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] visited, int[] delRow, int[] delCol,int row,int column){
        visited[r][c] = true;
        for(int i = 0;i<4;i++) {
            int nRow = r + delRow[i];
            int nCol = c + delCol[i];
            if(nRow >= 0 && nRow < row && nCol >= 0 && nCol < column && !visited[nRow][nCol] && board[nRow][nCol]=='O') {
                dfs(nRow, nCol, board, visited, delRow, delCol, row, column);
            }
        }
    }
}

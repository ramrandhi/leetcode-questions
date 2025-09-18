package patterns.recursion_backTracking.backtracking.recursionPblmsWithBackTracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        // here we need to check is it safe to put the queen
        for(int column = 0; column < board[0].length; column++) {
            if(isSafe(board, row, column)) {
                board[row][column] = true;
                count = count + queens(board, row + 1);
                board[row][column] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int column) {
        // check vertical row
        for(int i = 0; i< row;i++) {
            if(board[i][column]) {
                return false;
            }
        }

        // check the diagonally left
        int maxLeft = Math.min(row, column);
        for(int i= 1; i <= maxLeft;i++) {
            if(board[row - i][column - i]) {
                return false;
            }
        }

        // check the diagonally right
        int maxRight = Math.min(row, board.length - column - 1);
        for(int i=1;i<=maxRight;i++) {
            if(board[row - i][column + i]){
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row) {
                if(element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}

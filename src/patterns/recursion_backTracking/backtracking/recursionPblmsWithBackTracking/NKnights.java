package patterns.recursion_backTracking.backtracking.recursionPblmsWithBackTracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knights(board, 0,0,4);
    }

    static void knights(boolean[][] board, int row, int column, int knights) {
        if(knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length-1) { // gone past the last row
            return;
        }
        if(column == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }
        if(isSafe(board, row, column)) {
            board[row][column] = true;
            knights(board, row, column + 1, knights - 1);
            board[row][column] = false;
        }
        knights(board, row, column + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int column) {
        if(isValid(board, row - 2, column - 1)) {
            if(board[row-2][column-1]) {
                return false;
            }
        }
        if(isValid(board, row - 1, column - 2)) {
            if(board[row - 1][column - 2]) {
                return false;
            }
        }
        if(isValid(board, row - 1, column + 2)) {
            if(board[row - 1][column + 2]) {
                return false;
            }
        }
        if(isValid(board, row - 2, column + 1)) {
            if(board[row - 2][column + 1]) {
                return false;
            }
        }
        return true;
    }

//    above isSafe logic only checks 4 directions
//    A knight can attack from 8 possible moves, not just 4.
//    But since you’re filling the board left-to-right, top-to-bottom, you really only need to check positions that could already be filled (above and left).
//    So your version works, but it’s incomplete if you change traversal order.

//    private static boolean isSafe(boolean[][] board, int row, int column) {
//        int[][] moves = {
//                {-2, -1}, {-2, +1},
//                {-1, -2}, {-1, +2}
//        };
//
//        for (int[] move : moves) {
//            int r = row + move[0];
//            int c = column + move[1];
//            if (isValid(board, r, c) && board[r][c]) {
//                return false;
//            }
//        }
//        return true;
//    }

    static boolean isValid(boolean[][] board, int row, int column) {
        if(row >= 0 && row < board.length && column >= 0 && column < board.length) {
            return true;
        } else {
            return false;
        }
    }

    static void display(boolean[][] board) {
        for(boolean[] row: board) {
            for(boolean element: row) {
                System.out.print(element ? "K " : "X ");
            }
            System.out.println();
        }
    }
}

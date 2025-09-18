package patterns.recursion_backTracking.backtracking.recursionPblmsWithBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MageProblem {
    public static void main(String[] args) {
//        System.out.println(CountWaysToReachTheEndInMage(3,3));
//        printPathsInMageWhileReachingToTheEnd("", 3,3);
//        System.out.println(returnListInMageWhileReachingToTheEnd("", 3,3));
//        mageGoingDiagonallyAsWell("", 3,3);
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
//        mageWithObstales("", maze, 0,0);
//        mazeThatCanGoAllDirections("", maze, 0,0);
        int[][] path = new int[maze.length][maze[0].length];
        mazeThatCanGoAllDirectionsWithSteps("", maze, 0,0, path, 1);
    }

    static int CountWaysToReachTheEndInMage(int row, int column) {
        if(row == 1 || column == 1) {
            return 1;
        }
        int left = CountWaysToReachTheEndInMage(row - 1, column);
        int right = CountWaysToReachTheEndInMage(row, column - 1);
        return left + right;
    }

    static void printPathsInMageWhileReachingToTheEnd(String processed, int row, int column) {
        if(row == 1 && column == 1) {
            System.out.println(processed);
            return;
        }
        // here if we don't put this check then row will keep on decrementing and second funcion will never be called in base
        // condition there is && and if should never be triggered.
        if(row > 1) {
            printPathsInMageWhileReachingToTheEnd(processed + 'D', row - 1, column);
        }
        if(column > 1) {
            printPathsInMageWhileReachingToTheEnd(processed + 'R', row, column - 1);
        }
    }

    // returning to arrayList
    static List<String> returnListInMageWhileReachingToTheEnd(String processed, int row, int column) {
        List<String> list = new ArrayList<>();
        if(row == 1 && column == 1) {
            list.add(processed);
            return list;
        }
        // here if we don't put this check then row will keep on decrementing and second funcion will never be called in base
        // condition there is && and if should never be triggered.
        if(row > 1) {
            list.addAll(returnListInMageWhileReachingToTheEnd(processed + 'D', row - 1, column));
        }
        if(column > 1) {
            list.addAll(returnListInMageWhileReachingToTheEnd(processed + 'R', row, column - 1));
        }
        return list;
    }

    // here mage can also go diagonally as well
    static void mageGoingDiagonallyAsWell(String processed, int row, int column) {
        if(row == 1 && column == 1) {
            System.out.println(processed);
            return;
        }
        // here if we don't put this check then row will keep on decrementing and second funcion will never be called in base
        // condition there is && and if should never be triggered.

        if(row > 1 && column > 1) {
            mageGoingDiagonallyAsWell(processed + 'D', row - 1, column - 1);
        }
        if(row > 1) {
            mageGoingDiagonallyAsWell(processed + 'V', row - 1, column);
        }
        if(column > 1) {
            mageGoingDiagonallyAsWell(processed + 'H', row, column - 1);
        }
    }

    // mage with obstacle at (1,1) here we are starting from (0,0) insted of (3,3) which we have done previously
    static void mageWithObstales(String processed, boolean[][] maze, int row, int column) {
        if(row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if(maze[row][column] == false) {
            return;
        }
        if(row < maze.length - 1) {
            mageWithObstales(processed + 'D', maze, row + 1, column);
        }
        if(column < maze[0].length - 1) {
            mageWithObstales(processed + 'R', maze, row, column + 1);
        }
    }

    static void mazeThatCanGoAllDirections(String processed, boolean[][] maze, int row, int column) {
        if(row == maze.length-1 && column == maze[0].length-1) {
            System.out.println(processed);
            return;
        }
        if(maze[row][column] == false) {
            return;
        }
        maze[row][column] = false;
        if(row < maze.length-1) {
            mazeThatCanGoAllDirections(processed + 'D', maze, row + 1, column);
        }

        if(column < maze[0].length-1) {
            mazeThatCanGoAllDirections(processed + 'R', maze, row, column + 1);
        }

        if(row > 0) {
            mazeThatCanGoAllDirections(processed + 'U', maze, row - 1, column);
        }

        if(column > 0) {
            mazeThatCanGoAllDirections(processed + 'L', maze, row, column - 1);
        }
        maze[row][column] = true;
    }

    static void mazeThatCanGoAllDirectionsWithSteps(String processed, boolean[][] maze, int row, int column, int[][] path, int step) {
        if(row == maze.length-1 && column == maze[0].length-1) {
            path[row][column] = step;
            for(int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }
        if(maze[row][column] == false) {
            return;
        }
        maze[row][column] = false;
        path[row][column] = step;
        if(row < maze.length-1) {
            mazeThatCanGoAllDirectionsWithSteps(processed + 'D', maze, row + 1, column, path, step + 1);
        }
        if(column < maze[0].length-1) {
            mazeThatCanGoAllDirectionsWithSteps(processed + 'R', maze, row, column + 1, path, step + 1);
        }
        if(row > 0) {
            mazeThatCanGoAllDirectionsWithSteps(processed + 'U', maze, row - 1, column, path, step + 1);
        }
        if(column > 0) {
            mazeThatCanGoAllDirectionsWithSteps(processed + 'L', maze, row, column - 1, path, step + 1);
        }
        maze[row][column] = true;
        path[row][column] = 0;
    }
}

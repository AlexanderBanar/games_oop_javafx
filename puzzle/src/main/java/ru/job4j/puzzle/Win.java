package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        int[][] table = Logic.convert();
        boolean result = false;
        int[] diagonal = extractDiagonal(table);
        for (int i = 0; i < diagonal.length; i++) {
            if (diagonal[i] == 1) {
                if (monoHorizontal(table, i) || monoVertical(table, i)) {
                    result = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }

    public static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}

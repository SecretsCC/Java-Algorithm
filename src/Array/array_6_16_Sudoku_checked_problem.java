package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class array_6_16_Sudoku_checked_problem {

    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        //check row
        for(int i = 0; i < partialAssignment.size(); ++i) {
            if(hasDuplicate(partialAssignment, i, i + 1, 0, partialAssignment.size())) {
                return false;
            }
        }

        //check colum
        for(int j = 0; j < partialAssignment.size(); +r+j ) {
            if(hasDuplicate(partialAssignment, 0, partialAssignment.size(), j, j+1)) {
                return false;
            }
        }

        //check region constrains
        int regionSize = (int)Math.sqrt(partialAssignment.size());
        for(int i = 0; i < regionSize; ++i) {
            for(int j = 0; j < regionSize; ++j) {
                if(hasDuplicate(partialAssignment, regionSize * i, regionSize * (i + 1), regionSize * j, regionSize * (j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow, int endRow, int startCol, int endCol) {
        List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialAssignment.size() + 1, false));
        for(int i = 0; i < endRow; ++i){
            for(int j = 0; j < endCol; ++j) {
                if(partialAssignment.get(i).get(j) != 0 && isPresent.get(partialAssignment.get(i).get(j))) {
                    return true;
                }
                isPresent.set(partialAssignment.get(i).get(j), true);
            }
        }
        return false;
    }

    //array version1
    public boolean isValidSudoku1(char[][] board) {
        for(int i = 0; i < board.length; ++i) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0; j < board.length; ++j){
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[i][j] != '.' && !cols.add(board[i][j])) return false;

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) return false;

            }
        }
        return true;
    }

    //version 2
    public static boolean isValidSudoku2(char[][] board) {
        for(int i =0; i < board.length; ++i){
            for(int j = 0; j < board.length; ++j){
                if(board[i][j] == '.') continue;
                if(!valid(board,i,j)) return false;
            }
        }
        return true;
    }

    private static boolean valid(char[][] board, int i, int j) {
        for(int row = 0; row < board.length; row++){
            if(row == i) continue;
            if(board[row][j] == board[i][j]) return false;
        }
        for(int col = 0; col < board.length; ++col) {
            if(col == j) continue;
            if(board[i][col] == board[i][j]) return false;
        }
        for(int row = (i / 3) * 3; row < (i / 3 + 1) * 3; ++row) {
            for(int col = (j / 3) * 3; col < (j / 3 + 1) * 3; ++col) {
                if(row == i && col == j) continue;
                if(board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}

package Leetcode.medium;

/*
* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    Example 2:
        Input: board =
        [["@8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","@8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: false
* */
public class _36_ValidSudoku {
    /*
     * Solution :
     *  - iterate for once
     *  - each column contain a map/or array to check repeat
     *  -  split whole block as 9*9 block and number each block
     *  - boxIndex = index_box = (row/3)*3+column/3;
     * */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] subBox = new int[9][9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    int value = board[row][col] - '1';
                    int box_index = (row / 3) * 3 + col / 3;
                    if (rows[row][value] == 1) {
                        return false;
                    } else {
                        rows[row][value] = 1;
                    }

                    if (cols[col][value] == 1) {
                        return false;
                    } else {
                        cols[col][value] = 1;
                    }

                    if (subBox[box_index][value] == 1) {
                        return false;
                    } else {
                        subBox[box_index][value] = 1;
                    }

                }
            }
        }

        return true;
    }
}

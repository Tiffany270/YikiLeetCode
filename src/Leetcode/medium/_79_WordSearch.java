package Leetcode.medium;

/*
        Given an m x n board and a word, find if the word exists in the grid.
        The word can be constructed from letters of sequentially adjacent cells,
        where "adjacent" cells are horizontally or vertically neighboring.
        The same letter cell may not be used more than once.

                Input: board =
                [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]], word = "ABCCED"
                Output: true

                Input: board =
                [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]], word = "SEE"
                Output: true

* */
public class _79_WordSearch {
    /*Solution BFS
    别回退了你写不出来(不过感觉回溯也是回退啊……）
     * */

    public boolean exist(char[][] board, String word) {
        int rl = board.length;
        int cl = board[0].length;
        boolean[][] visited = new boolean[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                boolean flag =
                        check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(
            char[][] board, boolean[][] visited,
            int i, int j,
            String str, int k) {
        if (board[i][j] != str.charAt(k)) {
            return false;
        } else if (k == str.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions =//down, up,right,left
                {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (
                    newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, str, k + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;

        return res;

    }
}

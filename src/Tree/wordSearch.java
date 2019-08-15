package Tree;

public class wordSearch {
    class Solution {
        int m,n;
        boolean[][] visited;
        int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};

        public boolean inArea(int x,int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }

        public boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
            if(index == word.length() - 1) {
                return board[startx][starty] == word.charAt(index);
            }

            if(board[startx][starty] == word.charAt(index)) {
                visited[startx][starty] = true;
                for(int i = 0; i < 4; ++i) {
                    int newx = startx + d[i][0];
                    int newy = starty + d[i][1];
                    if(inArea(newx,newy) && !visited[newx][newy]) {
                        if(searchWord(board,word,index+1,newx,newy)) {
                            return true;
                        }
                    }
                }
                visited[startx][starty] = false;
            }
            return false;

        }

        public boolean exist(char[][] board, String word) {
            this.m = board.length;
            this.n = board[0].length;

            this.visited = new boolean[m][n];
            for(int i = 0; i < m; ++i) {
                for(int j = 0; j < n; ++j) {
                    visited[i][j] = false;
                }
            }

            for(int i = 0; i < board.length; ++i) {
                for(int j = 0; j < board[i].length; ++j) {
                    if(searchWord(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;

        }
    }
}

package p999;

// https://leetcode.com/problems/available-captures-for-rook/
// 难度： easy
// faster than 100.00%
// 一开始误以为需要BFS,其实不需要.
// 完成时间30min

public class Solution {
    public int numRookCaptures(char[][] board) {
        int sideLen = board.length;
        int captureNum = 0;
        int rookX = -1;
        int rookY = -1;
        int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};

        for (int i = 0; i < sideLen; i++) {
            for (int j = 0; j < sideLen && rookX < 0; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    break;
                }
            }
        }

        for (int[] move: moves) {
            int x = rookX;
            int y = rookY;
            while (x<sideLen && x>=0 && y<sideLen && y>=0){
                if(board[x][y]=='B') break;
                if(board[x][y]=='p') {
                    captureNum++;
                    break;
                }

                x += move[0];
                y += move[1];
            }
        }

        return captureNum;
    }
}

package medium.p36;

import java.util.HashSet;

public class Solution1 {
    public static boolean isValidSudoku(char[][] board) {
        return checkBox(board)&&checkColumn(board)&&checkRow(board);
    }

    private static boolean checkColumn(char[][] board){
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> nums = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='.') continue;
                if(nums.contains(board[i][j])) return false;
                else nums.add(board[i][j]);
            }
        }
        return true;
    }

    private static boolean checkRow(char[][] board){
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> nums = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if(board[j][i]=='.') continue;
                if(nums.contains(board[j][i])) return false;
                else nums.add(board[j][i]);
            }
        }
        return true;
    }

    private static boolean checkBox(char[][] board){
        for (int i = 0; i <= 6; i+=3) {
            for (int j = 0; j <= 6; j+=3) {
                HashSet<Character> nums = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    if(board[i+k/3][j+k%3]=='.') continue;
                    if(nums.contains(board[i+k/3][j+k%3])) return false;
                    else nums.add(board[i+k/3][j+k%3]);
                }
            }
        }
        return true;
    }





    public static void main(String[] args) {
        char[][] sudo = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        if(isValidSudoku(sudo)){
            System.out.println("wrong answer");
        }
    }
}

package p909;

// https://leetcode.com/problems/snakes-and-ladders/

//  faster than 82.12% of Java online submissions

import javafx.util.Pair;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int snakesAndLadders(int[][] board) {
        Pair<Integer, Integer> run;
        int sideLen = board.length; //边长
        int end = sideLen*sideLen;  //终点
        HashSet<Integer> history = new HashSet<>(); //记录遍历过的square 1.减少计算; 2避免死循环
        Queue<Pair<Integer,Integer>> trace = new LinkedList<>();  // 记录 Id 和 步数
        trace.add(new Pair<>(1,0));
//        System.out.println("size length:"+sideLen);

        while (!trace.isEmpty()){
            run = trace.poll();
//            System.out.println("poll:"+run);
//            System.out.println("-----");
            for(int stepSize=1; stepSize<=6; stepSize++){
                int tmpRun = run.getKey() + stepSize;
                if(valueOfId(board, tmpRun)!= -1) tmpRun = valueOfId(board, tmpRun); // 跳转
                if(tmpRun==end)return run.getValue()+1;
                if(tmpRun<end){
                    if(history.contains(tmpRun)) continue;
                    trace.add(new Pair<>(tmpRun,run.getValue()+1));
//                    System.out.println("push:"+tmpRun);
                    history.add(tmpRun);
                }
            }
        }
        return -1;
    }

    private static int valueOfId(int[][] board, int id){
        int sideLen = board.length; //边长
        int row = (sideLen -1) - (id-1)/sideLen;
        int col;
        int remainder = id%sideLen;
        if(remainder==0) remainder = sideLen -1;
        else remainder -= 1;
        if(((id-1)/sideLen)%2 == 0){
            col = remainder;
        }else {
            col = (sideLen -1) - remainder;
        }

        return board[row][col];
    }

    public static void main(String[] args) {
//        int[][] board = {
//                {-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,35,-1,-1,13,-1},
//                {-1,-1,-1,-1,-1,-1},
//                {-1,15,-1,-1,-1,-1}};
        int[][] board = {{-1,-1},{-1,-1}};




        System.out.println("output:"+snakesAndLadders(board));
    }
}

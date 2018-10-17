package 아이스크림;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Pair<Integer, Integer>> nagative;

    static int[] arr;
    static int[][] map;

    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        map = new int[10001][10001];
        for (int i = 0; i < M; i++) {
            input = bf.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=1;
        }


        arr = new int[3];


        result = 0;
        dfs(0,3,1);



        System.out.println(result);
    }

    public static void dfs(int depth, int m, int target){

        if(m==0){
//            for (int i = 0; i < 3; i++) {
//                System.out.print(" "+arr[i]);
//            }
//            System.out.println();
            if(checking()){
                result++;
            }

            return;
        }

        if(target==N+1){

            return;
        }

        arr[depth]=target;

        dfs(depth+1, m-1, target+1);
        dfs(depth, m, target+1);



    }

    public static boolean checking(){
        if(map[arr[0]][arr[1]]==1 || map[arr[1]][arr[0]]==1
        || map[arr[1]][arr[2]]==1 || map[arr[2]][arr[1]]==1
        || map[arr[0]][arr[2]]==1 || map[arr[2]][arr[0]]==1){
            return false;
        }
        return true;
    }
}



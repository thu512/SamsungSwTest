package 경사로;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);


        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        //행 탐색
        for (int i = 0; i < N; i++) {

        }

    }

    //d: 0 -> 행 / 1 -> 열
    public static boolean check(int index, int l, int d, int[][] map){
        boolean result = true;

        if(d == 0){

        }else if(d == 1){

        }

        return result;
    }
}

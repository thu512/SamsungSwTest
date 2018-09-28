package 등산로조성2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static int N;
    static int K;
    static int[][] map;
    static int[][] check;
    static int high;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static boolean fix;

    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = bf.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            map = new int[N][N];
            check = new int[N][N];
            high = 0;

            for (int i = 0; i < N; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    high = Math.max(high, map[i][j]);
                }
            }

            max=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==high){
                        fix = false;
                        check[i][j]=1;
                        dfs(i,j,1,high);
                        check[i][j]=0;
                    }
                }
            }

            System.out.println("#"+test_case+" "+max);

        }
    }

    public static void dfs(int r, int c, int d, int h){
        if(max < d){
            max = d;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r+dr[i];
            int tc = c+dc[i];

            if(tr >= 0 && tr < N && tc >= 0 && tc <N && check[tr][tc]!=1){
                if(map[tr][tc] < h){
                    check[tr][tc]=1;
                    dfs(tr,tc,d+1,map[tr][tc]);
                    check[tr][tc]=0;
                }else{
                    if(!fix && map[tr][tc]-K < h){
                        fix=true;
                        check[tr][tc]=1;
                        dfs(tr,tc,d+1,h-1);
                        check[tr][tc]=0;
                        fix=false;
                    }
                }
            }

        }

    }
}

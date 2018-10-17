package 게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static int[][] check;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        check = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                if(input[j].equals("H")){
                    map[i][j] = -1;
                    check[i][j]=1;
                }else{
                    map[i][j] = Integer.parseInt(input[j]);
                }

            }
        }

        max=0;
        check[0][0]=1;
        dfs(0,0,0);

        System.out.println(max);
    }

    public static void dfs(int r, int c, int d){
        if(map[r][c]==-1){
            max = Math.max(max, d);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r+dr[i]*map[r][c];
            int tc = c+dc[i]*map[r][c];

            if(!(tr>=0 && tr<N && tc>=0 && tc<M)){
                max = Math.max(max, d+1);
            }else{
                if(dp[tr][tc]==0 || dp[tr][tc]<d+1){
                    dp[tr][tc]=d+1;
                    check[tr][tc]=1;
                    dfs(tr,tc,d+1);
                }
            }

        }
    }
}

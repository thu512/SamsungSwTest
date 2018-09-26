package 벽돌깨기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    static int[] indexArr;
    static int W;
    static int H;
    static int[][] map;
    static int N;
    static int min;

    //상 하 우 좌
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String args[]) throws Exception
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(bf.readLine());




        for(int test_case = 1; test_case <= T; test_case++)
        {

            String[] input;
            input = bf.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            H = Integer.parseInt(input[2]);
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            min = 999999999;
            indexArr = new int[N];

            dfs(0);


            System.out.println("#"+test_case+" "+min);

        }
    }

    public static void dfs(int depth){
        if(min==0){
            return;
        }

        if(depth == N){
//            for (int i = 0; i < N; i++) {
//                System.out.print(" "+indexArr[i]);
//            }
//            System.out.println();
//            System.out.println();

            int[][] tmpMap = new int[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }

            Queue<Bomb> bombs = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int h = checkH(indexArr[i], tmpMap);
                if(h>=0){
                    bomb(h, indexArr[i], tmpMap, bombs);
                    //내리기
                    down(tmpMap);
                }

            }

            int score = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    //System.out.print(" "+tmpMap[i][j]);
                    if(tmpMap[i][j]!=0){
                        score++;
                    }
                }
                //ystem.out.println();
            }

            //System.out.println();

            min = Math.min(min,score);


            return;
        }

        for (int i = 0; i < W; i++) {
            indexArr[depth]=i;
            dfs(depth+1);
        }

    }

    public static void down(int[][] map){


        for (int i = 0; i < W; i++) {
            for (int j = H-1; j >= 0; j--) {
                if(map[j][i]==0){
                    for (int k = j-1; k >= 0 ; k--) {
                        if(map[k][i]!=0){
                            map[j][i] = map[k][i];
                            map[k][i]=0;
                            break;
                        }
                    }
                }



            }
        }


    }



    public static int checkH(int w, int[][] map){
        int h = -1;
        for (int i = 0; i < H; i++) {
            if(map[i][w] != 0){
                h=i;
                break;
            }
        }

        if(h==-1){
            return -1;
        }else{
            return h;
        }
    }


    public static void bomb(int h, int w, int[][] map, Queue<Bomb> bombs){


        int power = map[h][w];


        if(power != 0){
            bombs.offer(new Bomb(h, w, power));
            while(!bombs.isEmpty()){

                Bomb bomb = bombs.poll();

                int th=bomb.getR();
                int tw=bomb.getC();
                power = bomb.getPower();
                map[th][tw]=0;
                for (int i = 0; i < 4; i++) {
                    th=bomb.getR();
                    tw=bomb.getC();
                    for (int j = 1; j < power; j++) {
                        th += dr[i];
                        tw += dc[i];
                        if(th>=0 && th<H && tw >= 0 && tw < W && map[th][tw]!=0){
                            bombs.add(new Bomb(th, tw, map[th][tw]));
                        }
                    }

                }
            }
        }






    }


}

class Bomb{
    int r;
    int c;
    int power;

    @Override
    public String toString() {
        return "Bomb{" +
                "r=" + r +
                ", c=" + c +
                ", power=" + power +
                '}';
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Bomb(int r, int c, int power) {
        this.r = r;
        this.c = c;
        this.power = power;
    }
}
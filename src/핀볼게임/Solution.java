package 핀볼게임;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    static int N;
    static int[][] map;
    static int max;

    //상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String args[]) throws Exception {

        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();
            map = new int[N][N];
            max = 0;


            Ball start = null;


            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();

                }
            }

            Ball ball;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==0){
                        start = new Ball(i,j);
                        //상 하 좌 우
                        for (int k = 0; k < 4; k++) {

                                //System.out.println("시작볼의 위치: "+i+" , "+j);
                                ball = new Ball(k, i, j);
                                startGame(ball,  start);


                        }
                    }

                }
            }

            System.out.println("#"+test_case+" "+max);
        }
    }

    public static void startGame(Ball ball, Ball start){
        int score = 0;
        int tr;
        int tc;

        //시작 지점, 블랙홀 이면 종료
        while(true){

            tr = ball.getR()+dr[ball.getDir()];
            tc = ball.getC()+dc[ball.getDir()];

            //벽에 부딪쳤을때
            if(tr < 0 || tr>=N || tc < 0 || tc >= N){
                //tr = ball.getR();
                //tc = ball.getC();

                if( ball.getDir() == 0){
                    ball.setDir(1);
                }else if(ball.getDir() == 1){
                    ball.setDir(0);
                }else if(ball.getDir() == 2){
                    ball.setDir(3);
                }else if(ball.getDir() == 3){
                    ball.setDir(2);
                }
                score++;
            }
            else{
                //장애물 만났을때
                if(map[tr][tc] >= 1 && map[tr][tc] <= 5){
                    ball.setDir(makeDir(ball.getDir(), map[tr][tc]));
                    score++;
                }
                //웜홀 만났을때
                else if(map[tr][tc] >= 6 && map[tr][tc] <= 10){
                    Ball warmHall = findWarmHall(tr,tc, map[tr][tc]);
                    tr = warmHall.getR();
                    tc = warmHall.getC();
                }
                if(map[tr][tc]==-1 ){
                    max = Math.max(max, score);
                    break;
                }
            }

            ball.setR(tr);
            ball.setC(tc);

            //System.out.println("볼의 위치: "+tr+" , "+tc+" , "+ball.getDir());


            if((ball.getR() == start.getR()) && (ball.getC() == start.getC()) ){
                max = Math.max(max, score);
                break;
            }



        }
    }

    public static Ball findWarmHall(int r, int c, int num){

        Ball warmHall=null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == num){
                    if(i!=r || j!=c){
                        warmHall = new Ball(i,j);
                    }
                }
            }
        }


        return warmHall;
    }

    public static int makeDir(int dir, int num){

        //상 하 좌 우
        if(dir == 0 && num == 1){
            return 1;
        }
        if(dir == 1 && num == 1){
            return 3;
        }
        if(dir == 2 && num == 1){
            return 0;
        }
        if(dir == 3 && num == 1){
            return 2;
        }


        if(dir == 0 && num == 2){
            return 3;
        }
        if(dir == 1 && num == 2){
            return 0;
        }
        if(dir == 2 && num == 2){
            return 1;
        }
        if(dir == 3 && num == 2){
            return 2;
        }

        //0상 1하 2좌 3우
        if(dir == 0 && num == 3){
            return 2;
        }
        if(dir == 1 && num == 3){
            return 0;
        }
        if(dir == 2 && num == 3){
            return 3;
        }
        if(dir == 3 && num == 3){
            return 1;
        }


        //0상 1하 2좌 3우
        if(dir == 0 && num == 4){
            return 1;
        }
        if(dir == 1 && num == 4){
            return 2;
        }
        if(dir == 2 && num == 4){
            return 3;
        }
        if(dir == 3 && num == 4){
            return 0;
        }


        //0상 1하 2좌 3우
        if(dir == 0 && num == 5){
            return 1;
        }
        if(dir == 1 && num == 5){
            return 0;
        }
        if(dir == 2 && num == 5){
            return 3;
        }
        if(dir == 3 && num == 5){
            return 2;
        }

        return -1;
    }
}

class Ball{
    int dir;
    int r;
    int c;


    public Ball(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Ball() {
    }

    @Override
    public String toString() {
        return "Ball{" +
                "dir=" + dir +
                ", r=" + r +
                ", c=" + c +
                '}';
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
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

    public Ball(int dir, int r, int c) {
        this.dir = dir;
        this.r = r;
        this.c = c;
    }
}
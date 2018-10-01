package 벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static int[][] map;

    static int[][][] check;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        check = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            input = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        Queue<Point> queue = new LinkedList<>();


        queue.offer(new Point(0,0, 0, false));
        check[0][0][0]=1;
        check[1][0][0]=1;

        int min = 999999999;
        while (!queue.isEmpty()){
            Point p = queue.poll();

            if(p.getR()==N-1 && p.getC() == M-1){

                min = p.getD();
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tr = p.getR()+dr[i];
                int tc = p.getC()+dc[i];

                if(tr >= 0 && tr < N && tc >=0 && tc<M){ //&& check[tr][tc] == 0 &&((map[tr][tc]==1 && !p.isBomb()) || map[tr][tc]==0)){
                    if(map[tr][tc]==1 && !p.isBomb() && check[0][tr][tc]==0){
                        queue.offer(new Point(tr, tc, p.getD()+1, true));
                        check[0][tr][tc]=1;
                    }
                    if(map[tr][tc]==0 && p.isBomb() && check[0][tr][tc]==0){
                        queue.offer(new Point(tr, tc, p.getD()+1, p.isBomb()));
                        check[0][tr][tc]=1;
                    }

                    if(map[tr][tc]==0 && !p.isBomb() && check[1][tr][tc]==0) {
                        queue.offer(new Point(tr, tc, p.getD()+1, p.isBomb()));
                        check[1][tr][tc]=1;
                    }

                }
            }

        }

        if(min == 999999999){
            min = -1;
        }else{
            min++;
        }

        System.out.println(min);

    }
}
class Point{
    int r;
    int c;
    int d;
    boolean bomb;

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
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

    public Point(int r, int c, int d, boolean bomb) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.bomb = bomb;
    }
}
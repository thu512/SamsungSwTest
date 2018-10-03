package 레이저통신;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};

    static int m;
    static int n;
    static String[][] map;
    static int[][] check;
    static ArrayList<Point> cs;
    static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new String[n][m];
        check = new int[n][m];

        cs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = bf.readLine().split("");
            map[i] = input;
            for (int j = 0; j < m; j++) {

                if(map[i][j].equals("C")){
                    cs.add(new Point(i,j));
                }
            }
        }

        min = 999999999;
        check[cs.get(0).getR()][cs.get(0).getC()] = 1;
        dfs(cs.get(0).getR(), cs.get(0).getC(), -1, -1);

        System.out.println(min);
    }
    public static void dfs(int r, int c, int d, int s){
        if(r == cs.get(1).getR() && c==cs.get(1).getC()){
            min = Math.min(min, s);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int tr = r+dr[i];
            int tc = c+dc[i];

            if(tr >= 0 && tr < n && tc>=0 && tc<m && check[tr][tc]==0 && !map[tr][tc].equals("*")){
                check[tr][tc] = 1;
                if(d == i){

                    dfs(tr,tc,i,s);

                }else{

                    dfs(tr,tc,i,s+1);

                }
                check[tr][tc] = 0;
            }

        }


    }
}

class Point{
    int r;
    int c;
    int d; //직전 움직인 방향
    int s; //꺾은 횟수

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                ", d=" + d +
                ", s=" + s +
                '}';
    }

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
        this.d = -1;
        this.s = 0;
    }

    public Point(int r, int c, int d, int s) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.s = s;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
}
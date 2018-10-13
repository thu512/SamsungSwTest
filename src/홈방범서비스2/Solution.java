package 홈방범서비스2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int N;
    static int M;
    static int[][] map;
    static int result;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = bf.readLine().split(" ");

            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(input[j]);
                }
            }
            result=0;

            for (int k = 1; k <= N+1; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        bfs(i,j,k);
                    }
                }
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
    public static void bfs(int r, int c, int k){
        int[][] check = new int[N][N];
        int homeCnt=0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r,c,1));
        check[r][c]=1;
        while (!queue.isEmpty()){

            Point p =queue.poll();
            if(map[p.getR()][p.getC()]==1){
                homeCnt++;
            }

            if(p.getD()==k){
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tr = p.getR()+dr[i];
                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<N && tc>=0 && tc<N && check[tr][tc]==0){
                    queue.offer(new Point(tr,tc,p.getD()+1));
                    check[tr][tc]=1;
                }
            }

        }
//        System.out.println();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(" "+check[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        if(result<homeCnt && (k*k)+((k-1)*(k-1))<(homeCnt*M)){
            result = homeCnt;
        }

    }
}
class Point{
    int r;
    int c;
    int d;

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

    public Point(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

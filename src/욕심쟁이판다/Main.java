package 욕심쟁이판다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        int[][] check = new int[n][n];
        String[] input;
        for (int i = 0; i < n; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        int max = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.getD()>o2.getD()){
                    return -1;
                }else if(o1.getD()<o2.getD()){

                    return 1;
                }else{
                    return 0;
                }
            }
        });


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(dp[i][j]!=0){
                    continue;
                }
                dp[i][j]=1;

                queue.offer(new Point(i,j,1,map[i][j]));


                while (!queue.isEmpty()){
                    Point p = queue.poll();


                    if(p.getD()>max){
                        max = p.getD();
                    }

                    for (int k = 0; k < 4; k++) {
                        int tr = p.getR()+dr[k];
                        int tc = p.getC()+dc[k];

                        if(tr>=0 && tr<n && tc>=0 && tc<n && map[tr][tc]>p.getN() && dp[tr][tc]<p.getD()+1){
                            queue.offer(new Point(tr,tc,p.getD()+1,map[tr][tc]));
                            dp[tr][tc]=p.getD()+1;
                        }

                    }

                }
            }
        }

        System.out.println(max);

    }
}
class Point{
    int r;
    int c;
    int d;
    int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
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

    public Point(int r, int c, int d, int n) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.n = n;
    }
}
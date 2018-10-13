package 말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr= {-1,1,0,0,-2,-2,2,2,1,-1,1,-1};
    static int[] dc= {0,0,-1,1,-1,1,-1,1,-2,-2,2,2};


    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(bf.readLine());

        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[0]);

        int[][] map = new int[N][M];
        int[][][] check = new int[K+1][N][M];

        for (int i = 0; i < N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        boolean flag = false;

        Queue<Point> queue = new LinkedList<>();
        check[0][0][0]=1;


        queue.offer(new Point(0,0, 0, 0));
        while (!queue.isEmpty()){
            Point p =queue.poll();
            if(p.getR()==N-1 && p.getC()==M-1){
                System.out.println(p.getL());
                flag = true;
                break;
            }

            for (int i = 0; i < 12; i++) {
                int tr = p.getR()+dr[i];
                int tc = p.getC()+dc[i];

                if (tr >= 0 && tr < N && tc >= 0 && tc < M && map[tr][tc]==0) {

                    if(i<4){
                        if(check[p.getK()][tr][tc]==0){
                            check[p.getK()][tr][tc]=p.getL()+1;
                            queue.offer(new Point(tr,tc,p.getL()+1, p.getK()));
                        }



                    }else{
                        if(p.getK()>=K){
                            break;
                        }
                        if(check[p.getK()+1][tr][tc]==0){
                            check[p.getK()+1][tr][tc]=1;
                            queue.offer(new Point(tr,tc,p.getL()+1, p.getK()+1));
                        }
                    }
                }

            }

        }
        if(!flag){
            System.out.println(-1);
        }
    }
}
class Point{
    int r;
    int c;
    int l;
    int k;

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

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Point(int r, int c, int l, int k) {
        this.r = r;
        this.c = c;
        this.l = l;
        this.k = k;
    }
}

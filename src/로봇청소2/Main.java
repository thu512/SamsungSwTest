package 로봇청소2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        Queue<Robot> que = new LinkedList<>();
        int[][] map = new int[N][M];
        int[][] check = new int[N][M];

        input = bf.readLine().split(" ");
        que.offer(new Robot(Integer.parseInt(input[0]), Integer.parseInt(input[1]),Integer.parseInt(input[2])));

        check[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=1;

        for(int i=0; i<N; i++) {
            input = bf.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 1;

        while(!que.isEmpty()) {
            Robot r = que.poll();
            boolean flag = false;
            //left
            int rd = r.getD();
            for(int d=0; d<4; d++) {
                int td = (rd+3)%4;
                int tr = r.getR()+dr[td];
                int tc = r.getC()+dc[td];

                if(tr>=0 && tr<N && tc>=0 && tc<M && map[tr][tc]==0 && check[tr][tc]==0) {
                    que.offer(new Robot(tr,tc,td));
                    check[tr][tc]=1;
                    result++;
                    flag = true;
                    break;
                }

                rd = td;

            }

            if(!flag) {
                int td = (r.getD()+2)%4;
                int tr = r.getR()+dr[td];
                int tc = r.getC()+dc[td];
                if(tr>=0 && tr<N && tc>=0 && tc<M && map[tr][tc]==0) {
                    que.offer(new Robot(tr,tc,rd));
                }else {
                    break;
                }
            }


        }



        System.out.println(result);

    }

}
class Robot{
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
    public Robot(int r, int c, int d) {
        super();
        this.r = r;
        this.c = c;
        this.d = d;
    }

}
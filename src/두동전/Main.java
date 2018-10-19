package 두동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};



    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        char[][] map = new char[N][M];

        int[][][][] visit = new int[N][M][N][M];

        Queue<Coin> queue = new LinkedList<>();
        Coin c = new Coin();

        boolean flag=false;
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='o' ){
                    if(!flag){
                        c.setR(i);
                        c.setC(j);

                        flag = true;
                    }else{
                        c.setR1(i);
                        c.setC1(j);

                    }

                }
            }
        }

        visit[c.getR()][c.getC()][c.getR1()][c.getC1()]=1;
        queue.offer(c);

        while (!queue.isEmpty()){
            //System.out.println(queue.toString());
            Coin coin = queue.poll();


            if(coin.getD() == 10){
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tr = coin.getR()+dr[i];
                int tc = coin.getC()+dc[i];
                int tr1 = coin.getR1()+dr[i];
                int tc1 = coin.getC1()+dc[i];
                int td = coin.getD()+1;

                boolean flag1 = false;
                boolean flag2 = false;

                if(!(tr>=0 && tr<N && tc>=0 && tc<M)){
                    flag1=true;
                }

                if(!(tr1>=0 && tr1<N && tc1>=0 && tc1<M)){
                    flag2 = true;
                }
                if(!flag1 && flag2){
                    System.out.println(td);
                    return;
                }else if(flag1 && !flag2){
                    System.out.println(td);
                    return;
                }else if(flag1&&flag2){
                    continue;
                }


                if(map[tr][tc]!='#' && map[tr1][tc1]!='#'){
                    if(visit[tr][tc][tr1][tc1]==0){
                        visit[tr][tc][tr1][tc1]=1;
                    }else{
                        continue;
                    }
                }else if(map[tr][tc]=='#' && map[tr1][tc1]!='#'){
                    tr = coin.getR();
                    tc = coin.getC();
                    if(visit[tr][tc][tr1][tc1]==0){
                        visit[tr][tc][tr1][tc1]=1;
                    }else{
                        continue;
                    }
                }else if(map[tr][tc]!='#' && map[tr1][tc1]=='#'){
                    tr1 = coin.getR1();
                    tc1 = coin.getC1();
                    if(visit[tr][tc][tr1][tc1]==0){
                        visit[tr][tc][tr1][tc1]=1;
                    }else{
                        continue;
                    }
                }else if(map[tr][tc]=='#'&&map[tr1][tc1]=='#'){
                    continue;
                }


                if(tr==tr1 && tc==tc1){
                    continue;
                }
                //System.out.println(coin.toString());
                queue.offer(new Coin(tr,tc,tr1,tc1,td));

            }

        }

        System.out.println(-1);


    }
}
class Coin{
    int r;
    int c;
    int r1;
    int c1;
    int d;

    @Override
    public String toString() {
        return "Coin{" +
                "r=" + r +
                ", c=" + c +
                ", r1=" + r1 +
                ", c1=" + c1 +
                ", d=" + d +
                '}';
    }

    public Coin() {
        this.d = 0;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public Coin(int r, int c, int r1, int c1, int d) {
        this.r = r;
        this.c = c;
        this.r1 = r1;
        this.c1 = c1;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

}
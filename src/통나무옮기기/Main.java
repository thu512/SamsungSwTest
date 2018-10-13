package 통나무옮기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {-1,1,0,0,0};
    static int[] dc = {0,0,-1,1,0};
    static int[][] map;
    static int[][][] check;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        map = new int[n][n];
        check = new int[2][n][n];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = bf.readLine().split("");
            for (int j = 0; j < n; j++) {
                if(input[j].equals("B")){
                    map[i][j] = 3;
                }else if(input[j].equals("E")){
                    map[i][j] = 4;
                }else{
                    map[i][j] = Integer.parseInt(input[j]);
                }

            }
        }

        Point s = null;
        Point e = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==3){
                    if(i+1<n && map[i+1][j]==3){
                        s = new Point(i+1, j, 1,0);
                        check[1][i+1][j]=1;
                        map[i][j]=0;
                        map[i+1][j]=0;
                        map[i+2][j]=0;

                    }else if(map[i][j+1]==3){
                        s = new Point(i, j+1, 0,0);
                        check[0][i][j+1]=1;

                        map[i][j]=0;
                        map[i][j+1]=0;
                        map[i][j+2]=0;

                    }
                }else if(map[i][j]==4){
                    if(i+1<n && map[i+1][j]==4){
                        e = new Point(i+1, j, 1,0);

                        map[i][j]=0;
                        map[i+1][j]=0;
                        map[i+2][j]=0;

                    }else if(map[i][j+1]==4){
                        e = new Point(i, j+1, 0,0);

                        map[i][j]=0;
                        map[i][j+1]=0;
                        map[i][j+2]=0;

                    }
                }
            }
        }

        boolean flag = false;
        Queue<Point> que = new LinkedList<>();
        que.offer(s);
        while (!que.isEmpty()){
            Point p = que.poll();


            if(p.getR()==e.getR() && p.getC() == e.getC() && p.getD() == e.getD()){
                System.out.println(p.getN());
                flag=true;
                break;
            }

            for (int i = 0; i < 5; i++) {
                int tr = p.getR()+dr[i];
                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<n && tc>=0 && tc<n && map[tr][tc]==0){
                    if(i==0){
                        if(p.getD()==0){
                            if(check[0][tr][tc]==0 && map[tr][tc-1]==0 && map[tr][tc+1]==0 ){
                                que.offer(new Point(tr,tc,0,p.getN()+1));
                                check[0][tr][tc]=1;
                            }
                        }else{
                            if(check[1][tr][tc]==0 && tr-1>=0 && map[tr-1][tc]==0 ){
                                que.offer(new Point(tr,tc,1,p.getN()+1));
                                check[1][tr][tc]=1;
                            }
                        }
                    }else if(i==1){
                        if(p.getD()==0){
                            if(check[0][tr][tc]==0 && map[tr][tc-1]==0 && map[tr][tc+1]==0 ){
                                que.offer(new Point(tr,tc,0,p.getN()+1));
                                check[0][tr][tc]=1;
                            }
                        }else{
                            if(check[1][tr][tc]==0 && tr+1<n && map[tr+1][tc]==0 ){
                                que.offer(new Point(tr,tc,1,p.getN()+1));
                                check[1][tr][tc]=1;
                            }
                        }
                    }else if(i==2){
                        if(p.getD()==0){
                            if(check[0][tr][tc]==0 && tc-1>=0 && map[tr][tc-1]==0 ){
                                que.offer(new Point(tr,tc,0,p.getN()+1));
                                check[0][tr][tc]=1;
                            }
                        }else{
                            if(check[1][tr][tc]==0 && map[tr-1][tc]==0 && map[tr+1][tc]==0 ){
                                que.offer(new Point(tr,tc,1,p.getN()+1));
                                check[1][tr][tc]=1;
                            }
                        }
                    }else if(i==3){
                        if(p.getD()==0){
                            if(check[0][tr][tc]==0 && tc+1<n && map[tr][tc+1]==0 ){
                                que.offer(new Point(tr,tc,0,p.getN()+1));
                                check[0][tr][tc]=1;
                            }
                        }else{
                            if(check[1][tr][tc]==0 && map[tr-1][tc]==0 && map[tr+1][tc]==0 ){
                                que.offer(new Point(tr,tc,1,p.getN()+1));
                                check[1][tr][tc]=1;
                            }
                        }
                    }else if(i==4){
                        if(p.getD()==0){
                            if(tr-1>=0 && tr+1<n && check[1][tr][tc]==0 && map[tr-1][tc]==0 && map[tr-1][tc+1]==0 && map[tr-1][tc-1]==0
                                    && map[tr+1][tc]==0 && map[tr+1][tc+1]==0 && map[tr+1][tc-1]==0){
                                que.offer(new Point(tr,tc,1,p.getN()+1));
                                check[1][tr][tc]=1;
                            }
                        }else{
                            if(tc-1>=0 && tc+1<n && check[0][tr][tc]==0 && map[tr][tc-1]==0 && map[tr-1][tc-1]==0 && map[tr+1][tc-1]==0
                                    && map[tr][tc+1]==0 && map[tr+1][tc+1]==0 && map[tr-1][tc+1]==0){
                                que.offer(new Point(tr,tc,0,p.getN()+1));
                                check[0][tr][tc]=1;
                            }
                        }
                    }
                }
            }

        }

        if(!flag){
            System.out.println(0);
        }



    }


}
class Point{
    //중심점 좌표
    int r;
    int c;
    //0:가로 / 1:세로
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
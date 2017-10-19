package 연구소;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static int N;
    static int M;
    static int[][] map;
    static int[][] temp;
    static int[][] tar;
    static int max = 0;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        map=new int[N][M];
        temp=new int[N][M];
        tar = new int[N][M];

        ArrayList<Point> birus = new ArrayList<>();

        for(int i=0;i<N; i++){
            for(int j=0;j<M; j++){
                map[i][j]=sc.nextInt();
                temp[i][j]=map[i][j];
                if(map[i][j]==2){
                    birus.add(new Point(i,j));
                }
            }
        }

        int r1;
        int c1;
        int r2;
        int c2;
        int r3;
        int c3;

        for(int i=0;i<N*M-2; i++){
            r1=i/M;
            c1=i%M;
            if(temp[r1][c1]!=0){
                continue;
            }else{
                temp[r1][c1]=1;
            }
            for(int j=i;j<N*M-1; j++){
                r2=j/M;
                c2=j%M;
                if(temp[r2][c2]!=0){
                    continue;
                }else{
                    temp[r2][c2]=1;
                }
                for(int k=j; k<N*M; k++){

                    r3=k/M;
                    c3=k%M;
                    if(temp[r3][c3]!=0){
                        continue;
                    }else{
                        temp[r3][c3]=1;
                    }
                    //==============여기서 2로 감염시키고 남은 0부분 세서 max갱신
                    initArr();
                    for(int x=0; x<birus.size(); x++){

                        bfs(birus.get(x).r,birus.get(x).c);
                    }
                    max=Math.max(max, count());
                    //===================================================
                    temp[r3][c3]=0;
                }
                temp[r2][c2]=0;
            }
            temp[r1][c1]=0;
        }

        System.out.println(max);

    }

    public static void bfs(int r, int c){



        Queue<Point> queue =new LinkedList<>();
        queue.add(new Point(r,c));


        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0; i<4; i++){
                int tr=p.r+dr[i];
                int tc=p.c+dc[i];
                if(tr>=0 && tr<N && tc>=0 && tc<M && tar[tr][tc]==0){
                    tar[tr][tc]=2;
                    queue.add(new Point(tr,tc));
                }
            }

        }


    }

    public static int count(){
        int sum=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tar[i][j]==0){
                  sum++;
                }
            }
        }

        return sum;
    }

    public static void printArr(){
        System.out.println("======================");
        for(int x=0;x<N; x++){
            for(int y=0;y<M; y++){
                System.out.print(tar[x][y]+" ");
            }
            System.out.println("");
        }
        System.out.println("=====================");
    }

    public static void initArr(){
        for(int q=0;q<N; q++){
            for(int w=0;w<M; w++){
                tar[q][w]=temp[q][w];

            }
        }
    }
}

class Point{
    int r;
    int c;

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

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
package 연구소탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {


    static int n;
    static int m;
    static int[][] map;
    static int[][] check;

    static Queue<Point> birus;
    static Queue<Point> person;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};


    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int test_case=1; test_case<=T; test_case++) {
            String[] input = bf.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            map = new int[n][m];
            check = new int[n][m];

            birus = new LinkedList<>();
            person = new LinkedList<>();


            for(int i=0; i<n; i++) {
                input = bf.readLine().split(" ");
                for(int j=0; j<m; j++) {
                    map[i][j]= Integer.parseInt(input[j]);
                    if(map[i][j]==2) {
                        birus.offer(new Point(i,j));
                    }else if(map[i][j]==3) {
                        person.offer(new Point(i,j));
                        check[i][j]=1;
                    }
                }
            }


            int time=0;
            boolean escape = false;
            boolean zombie = false;

            while(true) {

                int bsize = birus.size();
                int psize = person.size();

                time++;


                //1초동안 바이러스 퍼짐
                for(int i=0; i<bsize; i++) {
                    Point p = birus.poll();
                    for(int d=0; d<4; d++) {
                        int tr = p.getR()+dr[d];
                        int tc = p.getC()+dc[d];

                        if(tr>=0 && tr<n && tc>=0 && tc<m && map[tr][tc]!=1) {
                            birus.offer(new Point(tr,tc));
                            map[tr][tc]=2;
                        }
                    }
                }


                //1초동안 삼성이가 모험을 시작함
                int bir=0;
                for(int i=0; i<psize; i++) {
                    Point p = person.poll();

                    for(int d=0; d<4; d++) {
                        int tr = p.getR()+dr[d];
                        int tc = p.getC()+dc[d];

                        if(tr<0 || tr>=n || tc<0 || tc>=m) {
                            escape = true;
                            break;
                        }

                        if(map[tr][tc]==0 && check[tr][tc]==0) {
                            person.offer(new Point(tr,tc));
                            check[tr][tc]=1;
                        }

                        if(map[tr][tc]==2) {
                            bir++;
                        }
                    }

                    if(escape) break;
                }

                //조건 검사
                if(escape) break;
                if(person.size()==0 && bir>0) {
                    zombie = true;
                    break;
                }
                if(person.size()==0 && bir==0) {
                    break;
                }

            }


            if(escape) System.out.println("#"+test_case+" "+time);
            else if(zombie) System.out.println("#"+test_case+" ZOMBIE");
            else System.out.println("#"+test_case+" CANNOT ESCAPE");

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

        super();

        this.r = r;

        this.c = c;

    }



}


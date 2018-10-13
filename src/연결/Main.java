package 연결;



import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;



public class Main {



    static int[] dr = {1,-1,0,0};

    static int[] dc = {0,0,1,-1};





    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));





        String[] input = bf.readLine().split(" ");

        int n = Integer.parseInt(input[0]);

        int m = Integer.parseInt(input[1]);



        int[][] map = new int[m+1][n+1];

        int[][] check = new int[m+1][n+1];



        Point[] ps = new Point[4];







        for(int i=0; i<4; i++) {

            input = bf.readLine().split(" ");

            ps[i] = new Point(Integer.parseInt(input[1]),Integer.parseInt(input[0]));

        }



        int res1 = 1;



        Queue<Point> que = new LinkedList<>();

        check[ps[0].getR()][ps[0].getC()]=1;

        map[ps[0].getR()][ps[0].getC()]=1;

        map[ps[1].getR()][ps[1].getC()]=1;

        check[ps[2].getR()][ps[2].getC()]=1;

        check[ps[3].getR()][ps[3].getC()]=1;



        que.offer(ps[0]);



        boolean success1 = false;

        boolean success2 = false;

        while(!que.isEmpty()) {

            Point p = que.poll();



            if(p.getR() == ps[1].getR() && ps[1].getC()==p.getC()) {

                success1=true;

                Point prev = p.getPrev();

                while(prev.getPrev()!=null) {

                    map[prev.getR()][prev.getC()]=1;

                    prev = prev.getPrev();

                    res1++;

                }



            }



            for(int i=0; i<4; i++) {

                int tr = p.getR()+dr[i];

                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<=m && tc>=0 && tc<=n && check[tr][tc]==0) {

                    Point tp = new Point(tr,tc);

                    tp.setPrev(p);



                    que.offer(tp);

                    check[tr][tc]=1;

                }

            }



        }





        check = new int[m+1][n+1];

        que = new LinkedList<>();

        check[ps[2].getR()][ps[2].getC()]=2;

        map[ps[2].getR()][ps[2].getC()]=2;



        for(int i=0; i<=m; i++) {

            for(int j=0; j<=n; j++) {

                check[i][j]=map[i][j];

            }

        }

        map[ps[3].getR()][ps[3].getC()]=2;

        que.offer(ps[2]);

        res1++;



        while(!que.isEmpty()) {

            Point p = que.poll();



            if(p.getR() == ps[3].getR() && ps[3].getC()==p.getC()) {

                success2 = true;

                Point prev = p.getPrev();

                while(prev.getPrev()!=null) {

                    map[prev.getR()][prev.getC()]=2;

                    prev = prev.getPrev();

                    res1++;

                }



//				System.out.println();

//				for(int i=0; i<=m; i++) {

//					for(int j=0; j<=n; j++) {

//						System.out.print(" "+map[i][j]);

//					}

//					System.out.println();

//				}

                break;

            }



            for(int i=0; i<4; i++) {

                int tr = p.getR()+dr[i];

                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<=m && tc>=0 && tc<=n && check[tr][tc]==0) {

                    Point tp = new Point(tr,tc);

                    tp.setPrev(p);



                    que.offer(tp);

                    check[tr][tc]=1;

                }

            }



        }





        boolean success3 = false;

        boolean success4 = false;

        int res2 = 1;

        check = new int[m+1][n+1];

        map = new int[m+1][n+1];

        que = new LinkedList<>();

        check[ps[2].getR()][ps[2].getC()]=1;

        map[ps[2].getR()][ps[2].getC()]=2;

        map[ps[3].getR()][ps[3].getC()]=2;

        check[ps[0].getR()][ps[0].getC()]=1;

        check[ps[1].getR()][ps[1].getC()]=1;



        que.offer(ps[2]);





        while(!que.isEmpty()) {

            Point p = que.poll();



            if(p.getR() == ps[3].getR() && ps[3].getC()==p.getC()) {

                success3=true;

                Point prev = p.getPrev();

                while(prev.getPrev()!=null) {

                    map[prev.getR()][prev.getC()]=2;

                    prev = prev.getPrev();

                    res2++;

                }



            }



            for(int i=0; i<4; i++) {

                int tr = p.getR()+dr[i];

                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<=m && tc>=0 && tc<=n && check[tr][tc]==0) {

                    Point tp = new Point(tr,tc);

                    tp.setPrev(p);



                    que.offer(tp);

                    check[tr][tc]=1;

                }

            }



        }





        check = new int[m+1][n+1];

        que = new LinkedList<>();

        check[ps[0].getR()][ps[0].getC()]=1;

        map[ps[0].getR()][ps[0].getC()]=1;



        for(int i=0; i<=m; i++) {

            for(int j=0; j<=n; j++) {

                check[i][j]=map[i][j];

            }

        }

        map[ps[1].getR()][ps[1].getC()]=1;

        que.offer(ps[0]);

        res2++;



        while(!que.isEmpty()) {

            Point p = que.poll();



            if(p.getR() == ps[1].getR() && ps[1].getC()==p.getC()) {

                success4=true;

                Point prev = p.getPrev();

                while(prev.getPrev()!=null) {

                    map[prev.getR()][prev.getC()]=1;

                    prev = prev.getPrev();

                    res2++;

                }



//				System.out.println();

//				for(int i=0; i<=m; i++) {

//					for(int j=0; j<=n; j++) {

//						System.out.print(" "+map[i][j]);

//					}

//					System.out.println();

//				}

                break;

            }



            for(int i=0; i<4; i++) {

                int tr = p.getR()+dr[i];

                int tc = p.getC()+dc[i];

                if(tr>=0 && tr<=m && tc>=0 && tc<=n && check[tr][tc]==0) {

                    Point tp = new Point(tr,tc);

                    tp.setPrev(p);



                    que.offer(tp);

                    check[tr][tc]=1;

                }

            }



        }



        if((success1&&success2 && success3&&success4)) {

            int res = Math.min(res1, res2);

            System.out.println(res);



        }else if((success1&&success2) && !(success3&&success4)){

            System.out.println(res1);

        }else if(!(success1&&success2) && (success3&&success4)) {

            System.out.println(res2);

        }else {

            System.out.println("IMPOSSIBLE");

        }



    }



}

class Point{

    int r;

    int c;

    Point prev;







    public Point getPrev() {

        return prev;

    }

    public void setPrev(Point prev) {

        this.prev = prev;

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

    public Point(int r, int c) {

        super();

        this.r = r;

        this.c = c;

    }



}
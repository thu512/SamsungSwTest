package 최솟값으로이동하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int W;
    static int H;

    static int[] dw = {-1,1,0,0,1,-1};
    static int[] dh = {0,0,-1,1,1,-1};


    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {

            W = sc.nextInt();
            H = sc.nextInt();
            int n = sc.nextInt();

            Point[] arr = new Point[n];

            for (int i = 0; i < n; i++) {
                int w=sc.nextInt();
                int h=sc.nextInt();

                arr[i]=new Point(w,h);
            }
            int result = 0;
            for (int i = 0; i < n-1; i++) {
                result += bfs(arr[i].getW(),arr[i].getH(), arr[i+1].getW(), arr[i+1].getH());
            }

            System.out.println("#"+(test_case+1)+" "+result);
        }
    }

    public static int bfs(int sw, int sh, int ew, int eh){
        Queue<Point> queue = new LinkedList<>();
        int min=999999999;
        Point start = new Point(sw, sh,0,0,0);

        queue.add(start);

        while (!queue.isEmpty()){
            Point p = queue.poll();
            //System.out.println(" "+p.toString());
            if(p.getW()==ew && p.getH()==eh){
                min =Math.min(min,p.getD());
                continue;
            }
            for (int i = 0; i < 6; i++) {
                int tw=p.getW()+dw[i];
                int th=p.getH()+dh[i];
                if(tw>0 && tw<=W && th>0 && th<=H && !(tw==p.getCw() && th==p.getCh()) && (p.getD()+1 <min)){
                    queue.add(new Point(tw,th,p.getD()+1,p.getW(),p.getH()));
                }
            }
        }

        return min;
    }
}
class Point{
    int w;
    int h;
    int d;
    int cw;
    int ch;

    public int getCw() {
        return cw;
    }

    public void setCw(int cw) {
        this.cw = cw;
    }

    @Override
    public String toString() {
        return "Point{" +
                "w=" + w +
                ", h=" + h +
                ", d=" + d +
                ", cw=" + cw +
                ", ch=" + ch +
                '}';
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Point(int w, int h, int d, int cw, int ch) {
        this.w = w;
        this.h = h;
        this.d = d;
        this.cw = cw;
        this.ch = ch;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Point(int w, int h) {

        this.w = w;
        this.h = h;
    }
}
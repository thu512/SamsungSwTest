package 수영대회결승전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

public class Solution {

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int n;
    static int[][] map;
    static int[][] check;
    static int min;
    static Point end;

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            n = Integer.parseInt(bf.readLine());

            map = new int[n][n];
            check = new int[n][n];


            String[] input;

            for (int i = 0; i < n; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            input = bf.readLine().split(" ");
            Point start = new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1]),0);

            input = bf.readLine().split(" ");
            end = new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1]),0);


            min = 99999999;


            ArrayList<Point> tmpQue = new ArrayList<>();

            Queue<Point> queue = new LinkedList<>();
            check[start.getR()][start.getC()]=1;
            queue.offer(start);

            while (!queue.isEmpty() ){
                Point p = queue.poll();

                if(end.getR() == p.getR() && end.getC()==p.getC()){
                    min = Math.min(min,p.getTime());

                    break;
                }

                for (int i = 0; i < tmpQue.size(); i++) {
                    if(tmpQue.get(i).getTime() == p.getTime()){
                        queue.offer(tmpQue.get(i));
                        tmpQue.remove(i);
                        i--;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int tr = p.getR()+dr[i];
                    int tc = p.getC()+dc[i];

                    if(tr>=0 && tr<n && tc>=0 && tc<n && check[tr][tc]==0 && map[tr][tc]!=1){
                        //System.out.println(p.getTime());
                        check[tr][tc]=1;
                        if(map[tr][tc]==0){
                            queue.offer(new Point(tr,tc,p.getTime()+1));

                        }else if(map[tr][tc]==2){
                            int tTime = ((p.getTime()/3)*3)+2;
                            if(tTime == p.getTime()){
                                queue.offer(new Point(tr,tc,p.getTime()+1));
                            }else{
                                tmpQue.add(new Point(tr, tc, tTime+1));
                            }
                        }
                    }
                }

                if(queue.isEmpty()){
                    for (int i = 0; i < tmpQue.size(); i++) {

                            queue.offer(tmpQue.get(i));
                            tmpQue.remove(i);
                            i--;

                    }
                }

            }

            if(min==99999999){
                min=-1;
            }

            System.out.println("#"+test_case+" "+min);


        }

    }

}
class Point{
    int r;
    int c;
    int time;

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Point(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

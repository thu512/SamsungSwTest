package 치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {



    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = bf.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        int[][] map = new int[n][n];

        ArrayList<Point> house = new ArrayList<>();
        ArrayList<Point> chickin = new ArrayList<>();

        int answer = 999999999;

        for (int i = 0; i < n;  i++) {
            String[] input2 = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
                if(map[i][j]==1){
                    house.add(new Point(i,j));
                }else if(map[i][j]==2){
                    chickin.add(new Point(i,j));
                }
            }
        }

        ArrayList<Integer> check;
        for (int i = 0; i <(1<<chickin.size()) ; i++) {
            check = new ArrayList<>();

            for (int j = 0; j < chickin.size(); j++) {
                if((i&(1<<j)) != 0 ){
                    //System.out.print(j+" ");
                    check.add(j);
                }
            }
            if(check.size()==m){
                //System.out.println(check.toString());
                int[] distance = new int[house.size()];
                for (int j = 0; j < house.size(); j++) {
                    distance[j] = 999999999;
                    for (int k = 0; k < check.size(); k++) {
                        distance[j] = Math.min(distance[j], cal(house.get(j), chickin.get(check.get(k))));
                        //System.out.println("거리: "+distance[j]);
                    }
                }
                int sum = 0;
                for (int j = 0; j < distance.length; j++) {
                    sum+=distance[j];
                }
                answer = Math.min(sum,answer);
            }
        }

        System.out.println(answer);
    }

    public static int cal(Point p1, Point p2){
        return Math.abs(p1.getR() - p2.getR()) +  Math.abs(p1.getC() - p2.getC());
    }
}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
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
}
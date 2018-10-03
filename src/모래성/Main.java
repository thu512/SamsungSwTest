package 모래성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {1, -1, 1, -1, 0, 0, 1, -1};
    static int[] dc = {1, -1, -1, 1, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int[][] K = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input = bf.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (input[j].equals(".")) {
                    map[i][j] = 0;


                } else {
                    map[i][j] = Integer.parseInt(input[j]);

                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int k = 0; k < 8; k++) {
                    int tr = i + dr[k];
                    int tc = j + dc[k];
                    if (tr >= 0 && tr < n && tc >=0 && tc < m && map[tr][tc] == 0) {
                        K[i][j]++;
                    }
                }
                if (map[i][j]!=0 && map[i][j] <= K[i][j]) {
                    queue.add(new Point(i, j, map[i][j]));
                }

            }
        }


        int queSize = queue.size();

        int result = 0;

        while (!queue.isEmpty()) {


            Point p = queue.poll();
            //System.out.println(queue.toString());
            for (int j = 0; j < 8; j++) {
                int tr = p.getR() + dr[j];
                int tc = p.getC() + dc[j];
                //무너진지점을 큐에 넣고 poll한 지점의 주변은 0의 개수를 한개씩 늘려준다.
                K[tr][tc]++;

                //무너질수 있는 지점을 큐에 삽입
                if (map[tr][tc] != 0 && map[tr][tc] == K[tr][tc]) {
                    queue.add(new Point(tr,tc,0));
                }
            }

            queSize--;

            if(queSize == 0){

                queSize = queue.size();

                result++;
            }

        }

        System.out.println(result);

    }
}

class Point {
    int r;
    int c;
    int h;

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                ", h=" + h +
                '}';
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

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Point(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}
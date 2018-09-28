package 줄기세포배양;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N+K][M+K];

            PriorityQueue<Cell> cells = new PriorityQueue<>(new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2) {
                    if(o1.getLastTime()> o2.getLastTime()){
                        return -1;
                    }else if(o1.getLastTime()< o2.getLastTime()){
                        return 1;

                    }else{
                        if(o1.getOrigin() > o2.getOrigin()){
                            return -1;
                        }else if(o1.getOrigin() < o2.getOrigin()){
                            return 1;
                        }else{
                            return 1;
                        }

                    }
                }
            });

            for (int i = K/2; i < N+K/2; i++) {
                for (int j = K/2; j < M+K/2; j++) {
                    map[i][j] = sc.nextInt();
                    if( map[i][j] != 0){
                        cells.add(new Cell(i,j, map[i][j], map[i][j], K ));
                    }

                }
            }


            while (!cells.isEmpty()){
                Cell cell = cells.poll();

                if(cell.getCurr()==0 && cell.isDie()){
                    map[cell.getR()][cell.getC()] = -1;
                    continue;
                }

                if(cell.getLastTime() == 0){
                    continue;
                }

                if(cell.getCurr() == 0 ){
                    cell.setDie(true);
                    cell.setCurr(cell.getOrigin());
                    cells.add(cell);
                }else{
                    cell.setCurr(cell.getCurr()-1);
                    cell.setLastTime(cell.getLastTime()-1);
                    cells.add(cell);
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int tr = cell.getR() + dr[i];
                    int tc = cell.getC() + dc[i];

                    if(map[tr][tc] !=0 ){
                        continue;
                    }
                    map[tr][tc] = cell.getOrigin();
                    cells.add(new Cell(tr, tc, cell.getOrigin(), cell.getOrigin(), cell.getLastTime()-1));

                }

            }

            int cnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {

                    if(map[i][j] != 0 && map[i][j] != -1){
                        cnt++;
                    }
                }
            }

            System.out.println("#"+test_case+" "+cnt);


        }
    }
}
class Cell{
    int r;
    int c;
    int origin;
    int curr;
    int lastTime;
    boolean active;
    boolean die;

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
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

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDie() {
        return die;
    }

    public void setDie(boolean die) {
        this.die = die;
    }

    public Cell(int r, int c, int origin, int curr, int lastTime) {
        this.r = r;
        this.c = c;
        this.origin = origin;
        this.curr = curr;
        this.lastTime = lastTime;
        this.active = false;
        this.die = false;
    }
}

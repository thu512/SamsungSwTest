package 탈출;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[][] map = new String[N][M];

        Queue<Pair<Integer, Integer>> water = new LinkedList<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        Pair<Integer, Integer> start=null;
        Pair<Integer, Integer> end=null;

        int[][] check = new int[N][M];


        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                if(map[i][j].equals("*")){
                    water.offer(new Pair<>(i,j));
                }else if(map[i][j].equals("S")){
                    start = new Pair<>(i,j);
                    queue.offer(start);
                    check[i][j]=1;
                }else if(map[i][j].equals("D")){
                    end = new Pair<>(i,j);
                }
            }
        }




        int time=0;

        boolean flag = false;
        while (true){


            int waterLen = water.size();
            for (int i = 0; i < waterLen; i++) {
                Pair<Integer, Integer> p = water.poll();

                for (int j = 0; j < 4; j++) {
                    int tr = p.getKey()+dr[j];
                    int tc = p.getValue()+dc[j];

                    if(tr>=0 && tr<N && tc>=0 && tc<M && !map[tr][tc].equals("X") && !map[tr][tc].equals("*") && !map[tr][tc].equals("D")){
                        map[tr][tc]="*";
                        water.offer(new Pair<>(tr,tc));
                    }

                }
            }
//            System.out.println();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(" "+map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println(queue.toString());
            int queLen = queue.size();
            for (int i = 0; i < queLen; i++) {
                Pair<Integer, Integer> p = queue.poll();


                if(p.getKey()==end.getKey() && p.getValue()==end.getValue()){
                    flag = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int tr = p.getKey()+dr[j];
                    int tc = p.getValue()+dc[j];

                    if(tr>=0 && tr<N && tc>=0 && tc<M && !map[tr][tc].equals("X") && !map[tr][tc].equals("*") && check[tr][tc]==0){
                        check[tr][tc]=1;
                        queue.offer(new Pair<>(tr,tc));
                    }

                }
            }



            if(flag){
                break;
            }

            if(water.size()==0 && queue.size()==0){
                break;
            }
            time++;
        }


        if(flag){
            System.out.println(time);
        }else{
            System.out.println("KAKTUS");
        }

    }
}

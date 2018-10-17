package 치즈;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Queue<Pair<Integer,Integer>> removeQue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==1){
                    queue.offer(new Pair<>(i,j));
                }
            }
        }

        Queue<Pair<Integer,Integer>> blankQue = new LinkedList<>();


        blankQue.offer(new Pair<>(0,0));

        map[0][0]=2;


        while (!blankQue.isEmpty()){
            Pair<Integer,Integer> p = blankQue.poll();
            for (int j = 0; j < 4; j++) {
                int tr = p.getKey()+dr[j];
                int tc = p.getValue()+dc[j];
                if(tr>=0 && tr<N && tc>=0 && tc<M && map[tr][tc]==0){
                    map[tr][tc]=2;
                    blankQue.offer(new Pair<>(tr,tc));
                }
            }

        }


//        System.out.println();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(" "+map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        int queSize = queue.size();
        int time = 0;
        while (!queue.isEmpty()){
            time++;

            for (int i = 0; i < queSize; i++) {
                Pair<Integer, Integer> p = queue.poll();
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    int tr = p.getKey()+dr[j];
                    int tc = p.getValue()+dc[j];
                    if(tr>=0 && tr<N && tc>=0 && tc<M && map[tr][tc]==2){
                        cnt++;
                        if(cnt==2){
                            break;
                        }
                    }
                }

                if(cnt>=2){
                    removeQue.offer(p);
                }else{
                    queue.offer(p);
                }
            }
            //System.out.println(removeQue.toString());
            while (!removeQue.isEmpty()){
                Pair<Integer,Integer> p = removeQue.poll();
                map[p.getKey()][p.getValue()]=2;
            }
            makeBlank();
//            System.out.println();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(" "+map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            queSize = queue.size();

        }


        System.out.println(time);

    }


    public static void makeBlank(){
        Queue<Pair<Integer,Integer>> blankQue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(map[i][j]==2){
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(tr>=0 && tr<N && tc>=0 && tc<M && map[tr][tc]==0){
                            map[tr][tc]=2;
                            blankQue.offer(new Pair<>(tr,tc));
                            while (!blankQue.isEmpty()){
                                Pair<Integer,Integer> p = blankQue.poll();
                                for (int d = 0; d < 4; d++) {
                                    int ttr = p.getKey()+dr[d];
                                    int ttc = p.getValue()+dc[d];
                                    if(ttr>=0 && ttr<N && ttc>=0 && ttc<M && map[ttr][ttc]==0){
                                        map[ttr][ttc]=2;
                                        blankQue.offer(new Pair<>(ttr,ttc));
                                    }
                                }

                            }
                            break;
                        }
                    }
                }


            }
        }




    }
}

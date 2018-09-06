package 감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static int[] dirArr;
    static ArrayList<Cctv> cctv;

    //0:왼  1: 하  2: 오른  3: 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        cctv = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(1 <= map[i][j] && map[i][j] <=5 ){
                    cctv.add(new Cctv(i,j,map[i][j]));  //cctv 배열 추가
                }
            }
        }

        dirArr = new int[cctv.size()];

        result=999999999;

        //0:왼  1: 하  2: 오른  3: 상
        //cctv가 있는 / 없는경우
        if(dirArr.length>0){
            for (int i = 0; i < 4; i++) {
                dirArr[0] = i;
                dfs(1);
            }

            System.out.println(result);
        }else{
            int sum=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==0){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }


    }

    public static void dfs(int depth){
        if(depth == cctv.size()){
            //여기서 사각지대 계산
            int[][] tmpMap = new int[N][M];
            copyArr(map,tmpMap);
            draw(tmpMap);
            int sum=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tmpMap[i][j]==0){
                        sum++;
                    }
                }
            }

            result = Math.min(result, sum);
            //System.arraycopy();
            return;
        }
        for (int i = 0; i < 4; i++) {
            dirArr[depth] = i;
            dfs(depth+1);
        }
        return;
    }

    public static void draw(int[][] map){
        for (int i = 0; i < cctv.size(); i++) {
            int r = cctv.get(i).getR();
            int c = cctv.get(i).getC();
            int n = cctv.get(i).getN();

            switch (n){
                case 1:
                    //0:왼  1: 하  2: 오른  3: 상
                    if(dirArr[i]==0){
                        while(c>=0 && map[r][c] != 6){
                            if(map[r][c]==0){
                                map[r][c]=-1;
                            }
                            r += dr[0];
                            c += dc[0];
                        }
                    }else if(dirArr[i]==1){
                        while(r<N && map[r][c] != 6){
                            if(map[r][c]==0){
                                map[r][c]=-1;
                            }
                            r += dr[1];
                            c += dc[1];
                        }
                    }else if(dirArr[i]==2){
                        while(c<M && map[r][c] != 6){
                            if(map[r][c]==0){
                                map[r][c]=-1;
                            }
                            r += dr[2];
                            c += dc[2];
                        }
                    }else if(dirArr[i]==3){
                        while(r>=0 && map[r][c] != 6){
                            if(map[r][c]==0){
                                map[r][c]=-1;
                            }
                            r += dr[3];
                            c += dc[3];
                        }
                    }
                    break;

                case 2:
                    //0:왼  1: 하  2: 오른  3: 상
                    if(dirArr[i]==0 || dirArr[i]==2){
                        int tr = r;
                        int tc = c;

                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }

                        tr = r;
                        tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                    }else if(dirArr[i]==1 || dirArr[i]==3){
                        int tr = r;
                        int tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                        tr = r;
                        tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }
                    }
                    break;


                case 3:

                    //0:왼  1: 하  2: 오른  3: 상
                    if(dirArr[i]==0){
                        int tr = r;
                        int tc = c;

                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }

                        tr = r;
                        tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }
                    }else if(dirArr[i]==1){
                        int tr = r;
                        int tc = c;
                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }

                        tr = r;
                        tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                    }else if(dirArr[i]==2){
                        int tr = r;
                        int tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                        tr = r;
                        tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                    }else if(dirArr[i]==3){
                        int tr = r;
                        int tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }
                        tr = r;
                        tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                    }
                    break;
                case 4:

                    //0:왼  1: 하  2: 오른  3: 상
                    if(dirArr[i]==0){
                        int tr = r;
                        int tc = c;

                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }

                        tr = r;
                        tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }
                        tr = r;
                        tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                    }else if(dirArr[i]==1){
                        int tr = r;
                        int tc = c;
                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }
                        tr = r;
                        tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                        tr = r;
                        tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                    }else if(dirArr[i]==2){
                        int tr = r;
                        int tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                        tr = r;
                        tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }

                        tr = r;
                        tc = c;
                        while(tr<N && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[1];
                            tc += dc[1];
                        }
                    }else if(dirArr[i]==3){
                        int tr = r;
                        int tc = c;
                        while(tr>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[3];
                            tc += dc[3];
                        }
                        tr = r;
                        tc = c;
                        while(tc>=0 && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[0];
                            tc += dc[0];
                        }
                        tr = r;
                        tc = c;
                        while(tc<M && map[tr][tc] != 6){
                            if(map[tr][tc]==0){
                                map[tr][tc]=-1;
                            }
                            tr += dr[2];
                            tc += dc[2];
                        }
                    }
                    break;
                case 5:
                    int tr = r;
                    int tc = c;
                    while(tr>=0 && map[tr][tc] != 6){
                        if(map[tr][tc]==0){
                            map[tr][tc]=-1;
                        }
                        tr += dr[3];
                        tc += dc[3];
                    }
                    tr = r;
                    tc = c;
                    while(tr<N && map[tr][tc] != 6){
                        if(map[tr][tc]==0){
                            map[tr][tc]=-1;
                        }
                        tr += dr[1];
                        tc += dc[1];
                    }
                    tr = r;
                    tc = c;
                    while(tc>=0 && map[tr][tc] != 6){
                        if(map[tr][tc]==0){
                            map[tr][tc]=-1;
                        }
                        tr += dr[0];
                        tc += dc[0];
                    }
                    tr = r;
                    tc = c;
                    while(tc<M && map[tr][tc] != 6){
                        if(map[tr][tc]==0){
                            map[tr][tc]=-1;
                        }
                        tr += dr[2];
                        tc += dc[2];
                    }

                    break;
            }



        }
    }


    public static void copyArr(int[][] arr1, int[][] arr2){
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr2[i][j]=arr1[i][j];
            }
        }
    }
}

class Cctv{
    int r;
    int c;
    int n;

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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Cctv(int r, int c, int n) {
        this.r = r;
        this.c = c;
        this.n = n;
    }
}
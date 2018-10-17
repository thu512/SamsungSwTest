package 체스판다시칠하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int dr[]={1,-1,0,0};
    static int dc[]={0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[][] map = new String[N][M];
        for (int i = 0; i < N; i++) {
            map[i]=bf.readLine().split("");
        }

        int min = 999999999;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i+8 <= N && j+8 <= M){
                    String[][] tmp = copy(map,i,j);
                    min = Math.min(min, count(tmp));
                    tmp = copy(map,i,j);
                    min = Math.min(min, count2(tmp));
                }
            }
        }

        System.out.println(min);
    }

    public static int count(String[][] map){
        int cnt=0;
        int[][] check = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(map[i][j].equals("W")){
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(tr>=0 && tr<8 && tc>=0 && tc<8 && check[tr][tc]==0 && map[tr][tc].equals("W")){
                            cnt++;
                            check[tr][tc]=1;
                            map[tr][tc]="B";
                        }
                    }
                }else{
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(tr>=0 && tr<8 && tc>=0 && tc<8 && check[tr][tc]==0 && map[tr][tc].equals("B")){
                            cnt++;
                            check[tr][tc]=1;
                            map[tr][tc]="W";
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static int count2(String[][] map){
        int cnt=1;
        int[][] check = new int[8][8];

        if(map[0][0].equals("W")){
            map[0][0]="B";
        }else{
            map[0][0]="W";
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(map[i][j].equals("W")){
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(tr>=0 && tr<8 && tc>=0 && tc<8 && check[tr][tc]==0 && map[tr][tc].equals("W")){
                            cnt++;
                            check[tr][tc]=1;
                            map[tr][tc]="B";
                        }
                    }
                }else{
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(tr>=0 && tr<8 && tc>=0 && tc<8 && check[tr][tc]==0 && map[tr][tc].equals("B")){
                            cnt++;
                            check[tr][tc]=1;
                            map[tr][tc]="W";
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static String[][] copy(String[][] map, int r, int c){
        String[][] tmp = new String[8][8];
        for (int i = r; i < r+8; i++) {
            for (int j = c; j < c+8; j++) {
                tmp[i-r][j-c]=map[i][j];
            }
        }
        return tmp;
    }

}

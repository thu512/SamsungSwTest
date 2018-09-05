package 드래곤커브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //0: 우  1: 상  2: 좌 3: 하 4: 대각선 아래
        int[] dr = {0, -1, 0, 1, 1};
        int[] dc = {1, 0, -1, 0, 1};


        int[][] map = new int[101][101];

        int n = Integer.parseInt(bf.readLine());

        int[][] infoArr = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                infoArr[i][j]=Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            //방향 정의
            ArrayList<Integer> dir = new ArrayList<>();
            dir.add(infoArr[i][2]);
            for (int j = 0; j < infoArr[i][3]; j++) {
                for (int k = dir.size()-1; k >=0 ; k--) {
                    int d = dir.get(k);
                    if(d==3){
                        dir.add(0);
                    }else{
                        dir.add(d+1);
                    }
                }
            }

            //점찍기
            int r = infoArr[i][1];
            int c = infoArr[i][0];
            map[r][c]=1;
            for (int j = 0; j < dir.size(); j++) {
                r = r + dr[dir.get(j)];
                c = c + dc[dir.get(j)];
                map[r][c]=1;
            }
        }

        int result=0;
        //개수 세기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                //System.out.print(" "+map[i][j]);
                if(map[i][j]==1 && map[i+dr[0]][j+dc[0]]==1 && map[i+dr[3]][j+dc[3]]==1 && map[i+dr[4]][j+dc[4]]==1){
                    result++;
                }

            }
            //System.out.println(" ");
        }

        System.out.println(result);

    }
}

package 콩많이심기;


import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(bf.readLine());
        int[] dr = {2,0};
        int[] dc = {0,2};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = bf.readLine();
            int r = Integer.parseInt(input.split(" ")[0]);
            int c = Integer.parseInt(input.split(" ")[1]);

            boolean[][] map = new boolean[r][c];
            int result = r*c;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j]=true;
                }
            }


            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {

                    if(!map[i][j]){
                        continue;
                    }

                    for (int k = 0; k < 2; k++) {
                        int tmpR = i+dr[k];
                        int tmpC = j+dc[k];
                        if(tmpR>=0 && tmpR<r && tmpC>=0 && tmpC<c && map[tmpR][tmpC]){
                            map[tmpR][tmpC]=false;
                            result--;
                        }
                    }

                }
            }


            System.out.println("#"+test_case+" "+result);
        }
    }
}
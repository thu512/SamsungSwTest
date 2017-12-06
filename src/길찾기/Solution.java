package 길찾기;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 0; test_case < 10; test_case++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] map = new int[100][100];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <N ; i++) {

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c]=1;
            }

            for (int k = 0; k <100 ; k++) {
                for (int i = 0; i <100 ; i++) {
                    for (int j = 0; j <100 ; j++) {
                        if(map[i][k]==1 && map[k][j]==1){
                            map[i][j]=1;
                        }
                    }
                }
            }

            System.out.println("#" + (test_case + 1) + " "+(map[0][99]==1?1:0));

        }
    }

}



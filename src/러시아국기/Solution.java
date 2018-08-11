package 러시아국기;


import java.util.Scanner;


class Solution {
    static int n;
    static int m;
    static char[][] map;
    static int[][] cost;
    static int min;


    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            min = 999999999;

            n = sc.nextInt();
            m = sc.nextInt();

            map = new char[n][m];
            cost = new int[n][3];   //0-w / 1-b / 2-r

            sc.nextLine();
            for (int i = 0; i < n; i++) {
                map[i]=sc.nextLine().toCharArray();
                if(i==0){
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] != 'W'){
                            cost[i][0]++;
                        }
                    }
                }else if(i==1){
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] != 'W'){
                            cost[i][0]++;
                        }
                        if(map[i][j] != 'B'){
                            cost[i][1]++;
                        }
                    }
                }else if(i==n-2){
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] != 'B'){
                            cost[i][1]++;
                        }
                        if(map[i][j] != 'R'){
                            cost[i][2]++;
                        }
                    }
                }else if(i==n-1){
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] != 'R'){
                            cost[i][2]++;
                        }
                    }
                }else{
                    for (int j = 0; j < m; j++) {
                        if(map[i][j] != 'W'){
                            cost[i][0]++;
                        }
                        if(map[i][j] != 'B'){
                            cost[i][1]++;
                        }
                        if(map[i][j] != 'R'){
                            cost[i][2]++;
                        }
                    }
                }
            }

            int[] flag = {1, 0, 0};
            dfs(0,0,cost[0][0], flag);
            System.out.println("#"+test_case+" "+min);

        }
    }

    public static void dfs(int row, int col, int sum, int[] flag){
        if(row == n-1){
            for (int i = 0; i < 3; i++) {
                if(flag[i]==0){
                    return;
                }
            }
            if(sum < min){
                min = sum;
            }
            return;
        }
        for (int j = col; j <= col+1 && j<3; j++) {
            int check = 0;
            if(flag[j] == 0){
                check = 1;
                flag[j]=1;
            }
            dfs(row+1, j,sum+cost[row+1][j], flag);
            if(check == 1){
                flag[j] = 0;
                check = 0;

            }
        }

    }
}
package 입국심사;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {
            int n=sc.nextInt(); //심사대
            int m =sc.nextInt(); //인원수
            int[][] arr = new int[n][2];

            for (int i = 0; i <n ; i++) {
                arr[i][0]=sc.nextInt();
            }

            int cnt=1;
            while(cnt<=m){
                int min=999999999;
                int index=0;
                for (int i = 0; i <n ; i++) {
                    if(arr[i][0]*(arr[i][1]+1) < min){
                        min=arr[i][0]*(arr[i][1]+1);
                        index=i;
                    }
                }

                arr[index][1]++;
                cnt++;


            }
            int result=0;
            for (int i = 0; i <n ; i++) {
                result = Math.max(result,(arr[i][0]*arr[i][1]));
            }

            System.out.println("#"+(test_case+1)+" "+result);
        }
    }
}

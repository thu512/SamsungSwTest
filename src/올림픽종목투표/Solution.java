package 올림픽종목투표;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int[] A = new int[n];//비용
            int[] B = new int[m];//심사위원 요구 비용
            int[] c = new int[n];//투표


            for (int i = 0; i < n; i++) {
                A[i]=sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                B[i]=sc.nextInt();
            }

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {
                    if(B[i]>=A[j]){

                        c[j]++;
                        break;
                    }
                }

            }
            int max=0;
            int index=0;
            for (int i = 0; i < n; i++) {
                if(max<c[i]){
                    max=c[i];
                    index=i;
                }
            }

            System.out.println("#"+(test_case+1)+" "+(index+1));
        }
    }
}

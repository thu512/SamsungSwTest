package 아름이의돌던지기;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {
            int n= sc.nextInt();
            int[] arr = new int[n];

            int min=1000000;
            int cnt=0;

            for (int i = 0; i < n; i++) {
                arr[i]=Math.abs(sc.nextInt());

                if(arr[i]<min){
                    min = arr[i];
                    cnt=1;
                }
                else if(arr[i]==min){
                    cnt++;
                }
            }




            System.out.println("#"+(test_case+1)+" "+min+" "+cnt);
        }
    }
}

package 스타트와링크;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for (int i=0; i<(1<<n); i++){
            int cnt=0;
            for (int j=0; j<n; j++){
                if((i&(1<<i))!=0){
                    cnt++;
                }
            }

            if(cnt==n/2){
                for (int j=0; j<n; j++){
                    if((i&(1<<i))!=0){
                        cnt++;
                    }
                }
            }


        }



    }


}

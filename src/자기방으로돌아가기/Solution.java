package 자기방으로돌아가기;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] arry = new int[201];
            int n=sc.nextInt();
            int s=0;
            int e=0;
            for(int i=0; i<n; i++){
                s = sc.nextInt();
                e = sc.nextInt();
                if(s%2!=0){
                    s+=1;
                }
                if(e%2!=0){
                    e+=1;
                }
                if(s<e){
                    for(int j=s/2; j<=e/2; j++){
                        arry[j]+=1;
                    }
                }else{
                    for(int j=s/2; j>=e/2; j--){
                        arry[j]+=1;
                    }
                }

            }
            int result=0;
            for (int i = 1; i < arry.length; i++) {
                System.out.print(" "+arry[i]);
                result=Math.max(result,arry[i]);
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
}

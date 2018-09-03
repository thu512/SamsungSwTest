package 진수의홀수약수;


import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        long[] arr = new long[1000001];


        for (int i = 1; i <= 1000000; i++)
        {
            long sum = 0;
            int max = (int)Math.sqrt(i); //절반 만
            for (int j = 1; j <= max; j++)
            {
                if (i%j == 0)
                {//나누어 떨어지면
                    int temp1 = i / j;

                    if (temp1 % 2 != 0 && temp1 == j)
                    {
                        sum += j;
                        continue;
                    }
                    if (temp1 % 2 != 0)
                        sum += temp1;
                    if (j % 2 != 0)
                        sum += j;
                }
            }
            arr[i] = arr[i - 1] + sum;
        }

        for (int test_case = 1; test_case <= T; test_case++) {
            int first = sc.nextInt();
            int last = sc.nextInt();

            System.out.println("#"+test_case+" "+(arr[last]-arr[first-1]));

        }
    }
}
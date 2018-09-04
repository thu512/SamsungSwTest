package 재관이의대량할인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T= Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(bf.readLine());
            String[] input = bf.readLine().split(" ");
            int[] arr = new int[n];

            int sum = 0;
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
                sum+=arr[i];
            }

            Arrays.sort(arr);

            int min=0;
            for (int i = input.length-1; i >=0 && i-2>=0 ; i-=3) {
                min += arr[i-2];

            }

            System.out.println("#"+test_case+" "+(sum-min));
        }
    }
}

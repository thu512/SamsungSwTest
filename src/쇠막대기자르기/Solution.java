package 쇠막대기자르기;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T;
        T=Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = br.readLine();
            int a=0;
            int n=0;

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '('){
                    if(input.charAt(i+1) == ')'){
                        i++;
                        a+=n;
                    }
                    else{
                        a++;
                        n++;
                    }
                }else{
                    n--;
                }
            }
            
            System.out.println("#"+test_case+" "+a);

        }
    }
}
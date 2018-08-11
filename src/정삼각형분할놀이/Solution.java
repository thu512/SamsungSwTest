package 정삼각형분할놀이;


import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int A = sc.nextInt();
            int B = sc.nextInt();

            long result = (long)Math.pow((A/B),2);


            System.out.println("#" + (test_case + 1)+" "+result);

        }
    }

}



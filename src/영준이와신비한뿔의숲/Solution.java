package 영준이와신비한뿔의숲;


import java.util.Scanner;

class Solution {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            int x = a-b;
            int y = b-x;

            System.out.println("#" + (test_case + 1) + " "+y+" "+x);

        }
    }

}



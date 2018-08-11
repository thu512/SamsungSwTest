package 보충학습과평균;


import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int sum=0;
            for (int i = 0; i < 5; i++) {
                int score = sc.nextInt();
                sum += (score >= 40 ? score : 40);
            }



            System.out.println("#" + (test_case + 1) + " "+(sum/5));

        }
    }

}



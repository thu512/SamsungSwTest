package 수진이의팰린드롬;


import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.nextLine();

            int result=0;
            int[] arr = new int[26];

            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i)-97]++;
            }



            for (int i = 0; i < 26; i++) {
                result+=((arr[i]*(arr[i]+1))/2);
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
}

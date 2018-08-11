package 간단한압축풀기;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int n = sc.nextInt();

            sc.nextLine();
            String msg = "";
            char c;
            int num;
            ArrayList<Character> arr = new ArrayList<>();
            arr.add('0');
            for (int i = 0; i < n; i++) {
                msg = sc.nextLine();
                c = msg.split(" ")[0].charAt(0);
                num = Integer.parseInt(msg.split(" ")[1]);
                for (int j = 0; j < num; j++) {
                    arr.add(c);
                }
            }


            System.out.println("#" + (test_case + 1));
            for (int i = 1; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                if (i % 10 == 0) {
                    System.out.println("");
                }
            }
            System.out.println("");
        }
    }

}



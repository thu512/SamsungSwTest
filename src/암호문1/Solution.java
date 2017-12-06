package 암호문1;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);


        for (int test_case = 0; test_case < 10; test_case++) {
            int N = sc.nextInt(); //암호문의 길이
            ArrayList<String> arr = new ArrayList<>();
            sc.nextLine();

            String temp = sc.nextLine();
            for (int i = 0; i < N; i++) {
                arr.add(temp.split(" ")[i]);
            }

            int M = sc.nextInt();
            sc.nextLine();
            String order = sc.nextLine();
            ArrayList<String> ord = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                String tmp = order.split("I")[i];

                String[] t = tmp.split(" ");
                int index = Integer.parseInt(t[1]);
                int n = Integer.parseInt(t[2]);

                for (int j = 0; j < n; j++) {
                    arr.add(index + j, t[3 + j]);
                }

            }


            System.out.print("#" + (test_case + 1));
            for (int i = 0; i <10 ; i++) {
                System.out.print(" "+arr.get(i));
            }
            System.out.println("");

        }
    }


}



package 원재의메모리복구하기;


import java.util.Scanner;

class Solution {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        for (int test_case = 0; test_case < T; test_case++) {
            String value = sc.nextLine();

            char[] binary = value.toCharArray();

            char check='0';
            int result=0;
            for (int i = 0; i <binary.length ; i++) {
                if(binary[i] != check){
                    result++;
                    check = binary[i];
                }
            }


            System.out.println("#" + (test_case + 1)+" "+result);

        }
    }

}



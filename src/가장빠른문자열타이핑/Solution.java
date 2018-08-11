package 가장빠른문자열타이핑;


import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int test_case = 0; test_case < T; test_case++) {
            String msg = sc.nextLine();

            String a = msg.split(" ")[0];
            String b = msg.split(" ")[1];
            int cnt=0;
            for (int i = 0; i <= a.length()-b.length(); i++) {
                //System.out.println(""+a.substring(i,i+b.length()));
                if(a.substring(i,i+b.length()).equals(b)){
                    a=a.replaceFirst(b,"");
                    cnt++;
                    i=0;
                }

            }

            cnt+=a.length();
            System.out.println("#" + (test_case + 1) + " "+cnt);

        }
    }


}



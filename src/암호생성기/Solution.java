package 암호생성기;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 0; test_case < 10; test_case++) {
            int t=sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i <8 ; i++) {
                arr.add(sc.nextInt());
            }

            Boolean flag = true;

            while(flag){
                for (int i = 1; i <=5 ; i++) {
                    int tmp = arr.get(0);
                    arr.remove(0);
                    if(tmp-i <=0 ){
                        flag=false;
                        arr.add(0);
                        break;
                    }
                    arr.add(tmp-i);
                }
            }


            System.out.print("#" + (test_case + 1) + " ");
            for (int i:arr) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

}



package 초보자를위한점프대배치하기;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arry = new int[n];
            for (int i = 0; i < n; i++) {
                arry[i]=sc.nextInt();
            }
            Arrays.sort(arry);
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i <n ; i++) {
                if(i==0){
                    deque.addFirst(arry[i]);
                }else{
                    if(i%2 == 1){
                        deque.addLast(arry[i]);
                    }else{
                        deque.addFirst(arry[i]);
                    }
                }
            }
            Object[] result = deque.toArray();
            int max = 0;
            for (int i = 0; i < n; i++) {
                if(i==n-1){
                    max = Math.max(Math.abs((int)result[0]-(int)result[i]),max);
                }else{
                    max = Math.max(Math.abs((int)result[i]-(int)result[i+1]),max);
                }
            }

            System.out.println("#"+test_case+" "+max);

        }
    }
}
package 덕환이의카드뽑기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            Deque<Long> deque = new ArrayDeque<>();
            for (long i = 1; i <= n; i++) {
                deque.addLast(i);
            }

            System.out.println(deque.toString());
            while(deque.size() > 1){
                for (long i = 0; i < k; i++) {
                    long top = deque.pollFirst();
                    deque.addLast(top);
                }
                System.out.println(deque.toString());
                long first = deque.pollFirst();
                System.out.println(first);
            }




            System.out.println("#"+test_case+" "+deque.peekLast());
        }
    }
}

//1 2 3 4 5 6 7 8
//4 5 6 7 8 1 2 3 - 4
//5 6 7 8 1 2 3
//8 1 2 3 5 6 7 - 8
//1 2 3 5 6 7
//5 6 7 1 2 3 -5
//6 7 1 2 3
//2 3 6 7 1 - 2
//3 6 7 1
//1 3 6 7 -1
//3 6 7
//3 6 7 - 3
//6 7
//7 6 - 7
//6
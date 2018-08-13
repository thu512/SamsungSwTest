package 햄버거다이어트2;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    static int N;
    static int L;
    static ArrayList<Item> items;
    static int max;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            L = sc.nextInt();
            items = new ArrayList<>();
            max = 0;

            for (int i = 0; i < N; i++) {
                items.add(new Item(sc.nextInt(), sc.nextInt()));
            }

            for (int i = 0; i < (1 << (N)); i++){
                int temp = i, idx = 0, good = 0, tcal = 0;
                for (int j = 0; j < N; j++){
                    if ((i & (1 << j))!=0){
                        good += items.get(j).getScore();
                        tcal += items.get(j).getCal();
                        if (tcal > L) break;
                    }
                }
                if (tcal <= L) {
                    max = max < good ? good : max;
                }
            }


            System.out.println("#" + test_case + " " + max);
        }
    }


    static class Item {
        int score;
        int cal;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCal() {
            return cal;
        }

        public void setCal(int cal) {
            this.cal = cal;
        }

        public Item(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }
}
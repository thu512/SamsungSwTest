package 햄버거다이어트;

import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    static int N;
    static int L;
    static ArrayList<Item> items;
    static int max;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            L = sc.nextInt();
            items = new ArrayList<>();
            max = 0;

            for (int i = 0; i < N; i++) {
                items.add(new Item(sc.nextInt(), sc.nextInt()));
            }

            int[] flag = new int[N];

            for (int i = 0; i < N; i++) {
                flag[i]=1;
                dfs(0,items.get(i).getScore(), items.get(i).getCal(), flag);
                flag[i]=0;
            }

            System.out.println("#"+test_case+" "+max);
        }
    }


    public static void dfs(int n, int sumScore, int sumCal, int[] flag){
        
        if(n+1 == N){

            return;
        }

        if(max < sumScore && L > sumCal){
            max = sumScore;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(flag[i]==0 && (sumCal + items.get(i).getCal()) < L){
                flag[i]=1;
                dfs(n+1, sumScore+items.get(i).getScore(), sumCal + items.get(i).getCal(), flag);
                flag[i]=0;
            }
        }


    }

    static class Item{
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
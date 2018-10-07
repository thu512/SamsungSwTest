package 삼성이의쇼핑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static int N;
    static int M;

    static int[] indexArr;
    static int[] check;
    static int max;
    static ArrayList<Prod> pd;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = bf.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            pd = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                input = bf.readLine().split(" ");
                pd.add(new Prod(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            max = 0;
            dfs(0, 0,0);


            System.out.println("#"+test_case+" "+max);

        }
    }
    public static void dfs(int depth, int p, int s){
        if(p>N){
            return;
        }
        if(depth == M){
            max = Math.max(max, s);
            return;
        }

        dfs(depth+1, p+pd.get(depth).getP(), s+pd.get(depth).getS());
        dfs(depth+1, p,s);
    }

}

class Prod{
    int p;
    int s;

    @Override
    public String toString() {
        return "Prod{" +
                "p=" + p +
                ", s=" + s +
                '}';
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public Prod(int p, int s) {
        this.p = p;
        this.s = s;
    }
}

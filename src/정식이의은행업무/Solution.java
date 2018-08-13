package 정식이의은행업무;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Solution
{

    static int[] arry;
    static int[] result;
    static int K;

    public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);


		while(true){
            arry = new int[13];
            result = new int[13];
            K=sc.nextInt();
            if(K!=0){

                for (int i = 0; i < K; i++) {
                    arry[i]=sc.nextInt();
                }
                dfs(0,0);
                System.out.println();
            }else{
                break;
            }
        }

    }

    public static void dfs(int start, int depth){
        if(depth == 6){
            for (int i = 0; i < 5; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println(result[5]);
            return;
        }

        for (int i = start; i < K; i++) {
            result[depth]=arry[i];
            dfs(i+1,depth+1);
        }


    }
}
package 연산자끼워넣기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[] arr;
    static int[] check;
    static int[] num;
    static ArrayList<Integer> opArr;

    static int N;
    static int max;
    static int min;

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        input = bf.readLine().split(" ");

        opArr = new ArrayList<>();
        // 0:+ / 1:- / 2:* / 3:/
        for (int i = 0; i < input.length; i++) {
            int cnt = Integer.parseInt(input[i]);

            for (int j = 0; j < cnt; j++) {
                opArr.add(i);
            }
        }


        N = opArr.size();
        arr = new int[N];
        check = new int[N];
        max=-999999999;
        min=999999999;

        for (int i = 0; i < N; i++) {
            check[i]=1;
            arr[0]=i;
            dfs(1);
            check[i]=0;
        }

        System.out.println(max);
        System.out.println(min);



    }

    public static void dfs(int depth){
        if(depth == N){
            //출력
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(" "+arr[i]);
//            }
//            System.out.println();

            //계산
            int result = num[0];
            for (int i = 0; i < opArr.size(); i++) {
                int op = opArr.get(arr[i]);
                switch (op){
                    case 0:
                        result += num[i+1];
                        break;
                    case 1:
                        result -= num[i+1];
                        break;
                    case 2:
                        result *= num[i+1];
                        break;
                    case 3:
                        result /= num[i+1];
                        break;
                }
            }
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(check[i]==0){
                check[i]=1;
                arr[depth]=i;
                dfs(depth+1);
                check[i]=0;
            }
        }

    }


}

package 요리사;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    static int n;
    static int min;
    static int[][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(bf.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(bf.readLine());

            arr = new int[n][n];

            String[] input;
            for (int i = 0; i < n; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            min = 999999999;



            for (int i = 0; i < (1 << n); i++) {
                ArrayList<Integer> indexArr = new ArrayList<>();
                for (int j = 0; j < n; j++) {

                    if ((i & (1 << j)) != 0) {

                        indexArr.add(j);
                    }
                }

                ArrayList<Integer> other = new ArrayList<>();
                if (indexArr.size() == n / 2) {

                    for (int j = 0; j < n; j++) {
                        if (!indexArr.contains(j)) {


                            other.add(j);
                        }
                    }



                    int result1 = 0;
                    for (int k = 0; k < n / 2; k++) {
                        for (int j = 0; j < n / 2; j++) {
                            if (i == j) {
                                continue;
                            }
                            //System.out.println("i: "+i+" j: "+j);
                            result1 += arr[indexArr.get(k)][indexArr.get(j)];
                        }
                    }

                    int result2 = 0;
                    for (int k = 0; k < n / 2; k++) {
                        for (int j = 0; j < n / 2; j++) {
                            if (i == j) {
                                continue;
                            }

                            result2 += arr[other.get(k)][other.get(j)];
                        }
                    }
                    min = Math.min(min, Math.abs(result1 - result2));

                }

            }

            System.out.println("#"+test_case+" "+min);
        }
    }

}

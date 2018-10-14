package 스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[][] map = new int[n][n];
        String[] input;

        for(int i=0; i<n; i++) {
            input = bf.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        ArrayList<Integer> arr1;
        ArrayList<Integer> arr2;
        int res1;
        int res2;
        int min = 999999999;
        for(int i=0; i<(1<<n); i++) {
            arr1 = new ArrayList<>();
            arr2 = new ArrayList<>();
            res1=0;
            res2=0;
            for(int j=0; j<n; j++) {
                if((i&(1<<j))!=0) {
                    arr1.add(j);
                }else {
                    arr2.add(j);
                }
            }
            if(arr1.size() == n/2) {
                for(int j=0; j<arr1.size()-1; j++) {
                    for(int k=j+1; k<arr1.size(); k++) {
                        res1 += (map[arr1.get(j)][arr1.get(k)]+map[arr1.get(k)][arr1.get(j)]);
                    }
                }
                for(int j=0; j<arr2.size()-1; j++) {
                    for(int k=j+1; k<arr2.size(); k++) {
                        res2 += (map[arr2.get(j)][arr2.get(k)]+map[arr2.get(k)][arr2.get(j)]);
                    }
                }
                min = Math.min(min, Math.abs(res1-res2));
            }


        }

        System.out.println(min);

    }

}

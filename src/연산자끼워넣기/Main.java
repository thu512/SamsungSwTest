package 연산자끼워넣기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] ar;
    static ArrayList<Integer> opt;
    static int[] num;
    static int max;
    static int min;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i <n ; i++) {
            num[i]=sc.nextInt();
        }


        opt = new ArrayList<>();

        for (int j = 0; j <4 ; j++) {
            int c=sc.nextInt();
            for (int i = 0; i < c; i++) {
                opt.add(j);
            }
        }

        ar= new int[opt.size()];

        max=-999999999;
        min=999999999;
        for (int i = 0; i <opt.size() ; i++) {
            ar[i]=i;
        }

        perm(ar,0,opt.size(),opt.size());
        System.out.println((max));
        System.out.println((min));

    }

    public static void perm(int[] arr, int depth, int n, int k){
        if(depth == k){
            //print(arr,arr.length);
            int sum=num[0];

            for (int i = 0; i < opt.size(); i++) {
                switch (opt.get(arr[i])){
                    case 0:
                        sum+=num[i+1];
                        break;
                    case 1:
                        sum-=num[i+1];
                        break;
                    case 2:
                        sum*=num[i+1];
                        break;
                    case 3:
                        sum/=num[i+1];
                        break;
                }
            }
            max= Math.max(max,sum);
            min= Math.min(min,sum);



            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr,i,depth);
            perm(arr,depth+1, n,k);
            swap(arr,i,depth);
        }
        return;

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}

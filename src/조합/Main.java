package 조합;

import java.util.Stack;

public class Main {
    static Stack<Integer> st = new Stack<>();
    static int[] arr=new int[6];

    public static void main(String[] args){
        combination(arr,0,6,3,0);
    }

    static void combination(int[] arr, int index, int n, int k, int target) {

        if (k == 0) {

            for (int i = 0; i<index ; i++) {
                System.out.print(" "+arr[i]);
            }
            System.out.println("");
        } else if (target == n) {

            return;
        } else {

            arr[index] = target;
            // case#1. index에 target으로 채웠어 (index + 1, k - 1, target + 1)
            combination(arr, index + 1, n, k - 1, target + 1);
            // case#2. target이 마음에 안들어서 index 못채웠어 (index, k, target + 1)
            combination(arr, index, n, k, target + 1);
        }

    }

}

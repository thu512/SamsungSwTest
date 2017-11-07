package 조합;

import java.util.Stack;

public class Main {
    static Stack<Integer> st = new Stack<>();
    static int[] arr={0,1,2,3,4,5};

    public static void main(String[] args){
        combine(5,3,1);
    }

    public static void combine(int n, int r, int index){
        if(r==0){

            for(int i:st){
                System.out.print(arr[i]);
            }
            System.out.println("");

        }else if(n==r){
            for(int i=1; i<=n; i++){
                st.add(i);
            }

            for(int i:st){
                System.out.print(arr[index+i]);
            }
            System.out.println("");

            for(int i=1; i<=n; i++){
                st.pop();
            }

        }else{
            st.add(arr[index]);
            combine(n-1,r-1,index+1);

            st.pop();
            combine(n-1,r,index+1);
        }
    }
}

package 최솟값으로이동하기2;

import java.util.Scanner;

public class Solution {


    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {

           int w=sc.nextInt();
           int h=sc.nextInt();
           int n =sc.nextInt();
            Point[] arr = new Point[n];
            for (int i = 0; i < n; i++) {
                arr[i]=new Point(sc.nextInt(),sc.nextInt());
            }

            int result=0;

            for (int i = 0; i <n-1 ; i++) {
                result+= Count(arr[i].getW(),arr[i].getH(),arr[i+1].getW(),arr[i+1].getH());
            }

            System.out.println("#"+(test_case+1)+" "+result);
        }
    }

    public static int Count(int sw, int sh, int ew, int eh){
        int result=0;
        if((ew>sw && eh>sh) || (ew<sw && eh < sh)){
            result = Math.max(Math.abs((ew-sw)),Math.abs((eh-sh)));
        }else{
            if(((ew-sw)<0) && ((eh-sh)>=0)){
                result= Math.abs((ew-sw))+(eh-sh);
            }else if(((ew-sw)>=0) && ((eh-sh)<0)){
                result= Math.abs((eh-sh))+(ew-sw);
            }else{
                result = Math.max(Math.abs((ew-sw)),Math.abs((eh-sh)));
            }
        }

        return result;
    }

}

class Point{
    int w;
    int h;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Point(int w, int h) {
        this.w = w;
        this.h = h;
    }
}
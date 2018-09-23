package 보물상자비밀번호;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(bf.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = bf.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            String num = bf.readLine();

            int digitLen = n/4;

            ArrayList<Long> arr = new ArrayList<>();

            for (int i = 0; i < n/4; i++) {
                for (int j = 0; j < n; j+=digitLen) {
                    //System.out.print(" "+num.substring(j,j+digitLen));
                    long tmp = Long.parseLong(num.substring(j,j+digitLen),16);
                    if(!arr.contains(tmp)){
                        arr.add(tmp);
                    }

                }
                num = shiftStr(num);
                //System.out.println();
            }

            arr.sort(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    if(o1 < o2){
                        return 1;
                    }else if(o1 > o2){
                        return -1;
                    }else{
                        return 0;
                    }

                }
            });
            //System.out.println(arr.toString());
            System.out.println("#"+test_case+" "+arr.get(k-1));
        }
    }

    public static String shiftStr(String str){
        StringBuilder sb = new StringBuilder(str);
        char tmp = str.charAt(str.length()-1);
        sb.deleteCharAt(str.length()-1);
        sb.insert(0,tmp);

        return sb.toString();
    }
}
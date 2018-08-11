    package 의석이의우뚝선산;

    import java.util.ArrayList;
    import java.util.Scanner;

    class Solution
    {
        public static void main(String args[]) throws Exception
        {

            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++)
            {
                int n = sc.nextInt();
                int result=0;
                int r=0;
                int l=0;


                ArrayList<Integer> arry = new ArrayList<>();


                for (int i = 0; i < n; i++) {
                    arry.add(sc.nextInt());
                }


                for (int i = 1; i < n; i++) {
                    if(r>0 && l==0 && arry.get(i) > arry.get(i-1)){
                        r=0;
                    }
                    if(r>0 && l>0 && arry.get(i) > arry.get(i-1)){
                        result += r*l;
                        r=0;
                        l=0;
                    }
                    if(arry.get(i) > arry.get(i-1)){
                        l++;
                    }
                    if(arry.get(i) < arry.get(i-1)){
                        r++;
                    }
                }
                if(l>0 && r>0){
                    result += l*r;
                }

                System.out.println("#"+test_case+" "+result);
            }
        }
    }

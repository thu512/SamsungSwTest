package 진기의최고급붕어빵;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {
            int n=sc.nextInt(); //n명 손님
            int m=sc.nextInt(); //m초마다
            int k=sc.nextInt(); //k개씩 추가

            int[] man = new int[11112];

            for(int i=0; i<n; i++){
                man[sc.nextInt()]++;
            }

            boolean flag=true;
            String result="";
            int b=0;

            for(int i=1; i<11112; i++){

                if((i%m)==0){
                    b+=k;
                }

                if(man[i]>0){
                    if(b-man[i]<0){
                        result="Impossible";
                        flag=false;
                        break;
                    }else{
                        b-=man[i];
                    }
                }

            }

            if(flag){
                result="Possible";
            }
            if(man[0]>0){
                result="Impossible";
            }
            System.out.println("#"+(test_case+1)+" "+result);
        }
    }
}

package 승률비교하기;
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] msg = sc.nextLine().split(" ");
            float var1 = Float.parseFloat(msg[0])/Float.parseFloat(msg[1]);
            float var2 = Float.parseFloat(msg[2])/Float.parseFloat(msg[3]);
            System.out.println(var1);
            System.out.println(var2);


            if(var1 > var2){
                System.out.println("#"+test_case+" ALICE");
            }else if(var1 < var2){
                System.out.println("#"+test_case+" BOB");
            }else{
                System.out.println("#"+test_case+" DRAW");
            }
        }
    }
}
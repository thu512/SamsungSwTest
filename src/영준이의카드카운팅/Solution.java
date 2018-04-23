package 영준이의카드카운팅;

/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
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
            boolean[][] arr = new boolean[4][13];
            int[] arr2 = new int[4];
            String msg = sc.nextLine();
            boolean error=false;
            for (int i = 0; i <msg.length() ; i+=3) {
                int j=i;
                String num="";
                char c = msg.charAt(i);
                num+=String.valueOf(msg.charAt(i+1))+String.valueOf(msg.charAt(i+2));
                switch(c){
                    case 'S':
                        if(arr[0][Integer.parseInt(num)-1]){
                            error=true;
                            break;
                        }
                        arr[0][Integer.parseInt(num)-1]=true;
                        arr2[0]++;
                        break;
                    case 'D':
                        if(arr[1][Integer.parseInt(num)-1]){
                            error=true;
                            break;
                        }
                        arr[1][Integer.parseInt(num)-1]=true;
                        arr2[1]++;
                        break;
                    case 'H':
                        if(arr[2][Integer.parseInt(num)-1]){
                            error=true;
                            break;
                        }
                        arr[2][Integer.parseInt(num)-1]=true;
                        arr2[2]++;
                        break;
                    case 'C':
                        if(arr[3][Integer.parseInt(num)-1]){
                            error=true;
                            break;
                        }
                        arr[3][Integer.parseInt(num)-1]=true;
                        arr2[3]++;
                        break;
                }
                if(error){
                    break;
                }
            }
            if(error){
                System.out.println("#" + test_case + " ERROR");
            }else {
                System.out.println("#" + test_case + " " + (13 - arr2[0]) + " " + (13 - arr2[1]) + " " + (13 - arr2[2]) + " " + (13 - arr2[3]));
            }
        }
    }
}
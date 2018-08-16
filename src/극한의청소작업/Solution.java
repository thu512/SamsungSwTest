
import java.math.BigInteger;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        long[][] fourNum = new long[13][10];
        long digit = 1;

        for (int i = 1; i < 13; i++)
        {
            fourNum[i][1] = fourNum[i - 1][9] + fourNum[i - 1][1];

            for(int j = 2; j < 10; j++)
            {
                if(j == 5)
                {
                    fourNum[i][j] += fourNum[i][j - 1] + digit;
                    continue;
                }
                fourNum[i][j] = fourNum[i][j - 1] + fourNum[i][1];
            }

            digit *= 10;
        }


//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(" "+fourNum[i][j]);
//            }
//            System.out.println();
//        }

        for (int test_case = 1; test_case <= T; test_case++) {
            long bottom = sc.nextLong();
            boolean btmMinus = bottom < 0 ? true:false;
            if(btmMinus){
                bottom *= -1;
            }
            long top = sc.nextLong();
            boolean topMinus = top < 0 ? true:false;
            if(topMinus){
                top *= -1;
            }
            long tmpTop = top;
            long tmpBtm = bottom;
            int topDig = (int)(Math.log10(top)+1);
            int btnDig = (int)(Math.log10(bottom)+1);

            double n = Math.pow(10,topDig);

            long topRes = 0;
            for (int i = topDig-1; i >= 0; i--) {
                topRes += fourNum[i+1][(int)(tmpTop/Math.pow(10,i))];
                tmpTop %= (long)(Math.pow(10,i));
            }

            long btnRes = 0;
            for (int i = btnDig-1; i >= 0; i--) {
                btnRes += fourNum[i+1][(int)(tmpBtm/Math.pow(10,i))];

                tmpBtm %= (long)(Math.pow(10,i));
            }

            long result=0;
            if (btmMinus && !topMinus){
                result = top - topRes + bottom - btnRes -1;
            }else if(topMinus && btmMinus){
                result = bottom -top - btnRes  + topRes;
            }
            else if(!btmMinus && !topMinus){
                result = top - bottom - topRes + btnRes;

            }


            System.out.println("#"+test_case+" "+result);
        }
    }


}
// 25 23 22 21 20 19 18 17 16 15 13 12= 10
//1 - 1
//2 - 2
//3 - 3
//4 - 14
//511713642346 + 55592509193 + 5900636088 + 441719674 + 46519217 + 4748472 + 345706 + 34073 + 3168 + 214 + 17 + 1

//68618940391 + 13026431198 + 1837738533 + 56953279 + 10434062 + 1405677 + 40951 + 6878 + 813 + 21
//789789789789 - 573700158169 + 123123123123 - 83551951803
package 빠른휴대전화키패드;

import java.util.HashMap;
import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        HashMap<Integer,String> keyboard = new HashMap<>();
        keyboard.put(2,"abc");
        keyboard.put(3,"def");
        keyboard.put(4,"ghi");
        keyboard.put(5,"jkl");
        keyboard.put(6,"mno");
        keyboard.put(7,"pqrs");
        keyboard.put(8,"tuv");
        keyboard.put(9,"wxyz");
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String msg1 = sc.nextLine();
            String key = msg1.split(" ")[0];
            String msg2 = sc.nextLine();
            String[] word = msg2.split(" ");
            int cnt=0;
            for (int i = 0; i < word.length; i++) {
                if(word[i].length()==key.length()){
                    boolean flag=true;
                    for (int j = 0; j < word[i].length(); j++) {
                        int k=Integer.parseInt(String.valueOf(key.charAt(j)));
                        if(!keyboard.get(k).contains(String.valueOf(word[i].charAt(j)))){
                            flag =false;
                            break;
                        }
                    }
                    if(flag){
                        cnt++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}

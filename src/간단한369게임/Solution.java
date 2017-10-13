package 간단한369게임;


import java.util.*;

class Solution {
	
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String result="";
		for(int i=1; i<=T; i++) {
			int x=cnt(i);
			if(x==0) {
				result+=i+" ";
			}else {
				String v="";
				for(int j=0; j<x; j++) {
					v+="-";
				}
				result+=v+" ";
			}
			
		}
		System.out.println(result);
		
	}
	
	public static int cnt(int n) {
		int cnt=0;
		if(n<10) {
			if(n%3==0) {
				return 1;
			}
		}else if(n<100) {
			String j=String.valueOf(n);
			for(int i=0; i<2; i++) {
				if(j.charAt(i)=='3'||j.charAt(i)=='6'||j.charAt(i)=='9') {
					cnt++;
				}
			}
			return cnt;
		}else if(n<1000){
			String j=String.valueOf(n);
			for(int i=0; i<3; i++) {
				if(j.charAt(i)=='3'||j.charAt(i)=='6'||j.charAt(i)=='9') {
					cnt++;
				}
			}
			return cnt;
		}
		
		return cnt;
	}
}



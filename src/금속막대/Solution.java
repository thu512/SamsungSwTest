package 금속막대;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
            int n=sc.nextInt();
            ArrayList<Size> arr = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                arr.add(new Size(sc.nextInt(), sc.nextInt()));
            }

            Queue<Size> queue = new LinkedList<>();
            ArrayList<Size> res;
            ArrayList<ArrayList<Size>> list = new ArrayList<>();

            for (int i = 0; i <n ; i++) {
                res = new ArrayList<>();
                queue.add(arr.get(i));
                res.add(arr.get(i));
                while(!queue.isEmpty()){
                    Size s = queue.poll();

                    for (int j = 0; j <n ; j++) {
                        if(!s.equals(arr.get(j)) && s.getRight() == arr.get(j).getLeft()){
                            queue.add(arr.get(j));
                            res.add(arr.get(j));
                        }
                    }
                }

                list.add(res);
            }
            int index=0;
            int max=0;

//            for (int i = 0; i <list.size() ; i++) {
//                for (int j = 0; j <list.get(i).size() ; j++) {
//                    System.out.print(" "+list.get(i).get(j).toString());
//                }
//                System.out.println("");
//            }
            for (int i = 0; i <list.size() ; i++) {
                if(max<list.get(i).size()){

                    max=list.get(i).size();
                    index=i;
                }
            }
            System.out.print("#"+(test_case+1));
            for (int j = 0; j <list.get(index).size() ; j++) {
                System.out.print(" "+list.get(index).get(j).toString());
            }
            System.out.println("");
		}
	}

}

class Size{
    int left;
    int right;

    @Override
    public String toString() {
        return left+" "+right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Size(int left, int right) {
        this.left = left;
        this.right = right;
    }
}


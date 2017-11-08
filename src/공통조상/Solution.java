package 공통조상;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int v=sc.nextInt();
			int e=sc.nextInt();

			int r1=sc.nextInt();
			int r2=sc.nextInt();

			ArrayList<Edge> arr = new ArrayList<>();


			for (int i = 0; i <e ; i++) {
				arr.add(new Edge(sc.nextInt(), sc.nextInt()));
			}

			ArrayList<Integer> r1_p = new ArrayList<>();
			ArrayList<Integer> r2_p = new ArrayList<>();



			while(r1!=1){
				for (int i = 0; i <e ; i++) {
					if(arr.get(i).getSon()==r1){
						r1=arr.get(i).getParent();
						r1_p.add(r1);
						break;
					}
				}
			}

			while(r2!=1){
				for (int i = 0; i <e ; i++) {
					if(arr.get(i).getSon()==r2){
						r2=arr.get(i).getParent();
						r2_p.add(r2);
						break;
					}
				}
			}


			int result = 0;
            for (int i = 0; i <r1_p.size() ; i++) {
                boolean flag=true;
                for (int j = 0; j <r2_p.size() ; j++) {
                    if(r1_p.get(i).intValue()==r2_p.get(j).intValue()){
                        result=r1_p.get(i);
                        //System.out.println(result);
                        flag=false;
                        break;
                    }
                }
                if(!flag) break;
            }
            //print(r1_p);
            //print(r2_p);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(result);
            int size=1;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for (int i = 0; i <e ; i++) {
                    if(arr.get(i).getParent() == node){
                        queue.add(arr.get(i).getSon());
                        size++;
                    }
                }

            }

            System.out.println("#"+(test_case+1)+" "+result+" "+size);
			
		}
	}

	public static void print(ArrayList<Integer> arr){
        for (int i = 0; i <arr.size() ; i++) {
            System.out.print("  "+arr.get(i));
        }
        System.out.println("");
    }
}

class Edge{
	int parent;
	int son;

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getSon() {
		return son;
	}

	public void setSon(int son) {
		this.son = son;
	}

	public Edge(int parent, int son) {

		this.parent = parent;
		this.son = son;
	}
}


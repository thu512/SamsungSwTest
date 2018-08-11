package Knapsack;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static int K;
    static int N;
    static ArrayList<Item> items;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int max=0;
            N = sc.nextInt();
            K = sc.nextInt();
            items = new ArrayList<>();
            items.add(new Item(0,0,0));

            for (int i = 0; i < N; i++) {
                items.add(new Item(sc.nextInt(), sc.nextInt(),i));
            }
            items.get(0).setBound(bound(items.get(0)));
            //print("bound: "+bound(items.get(0)));
            PriorityQueue<Item> pq = new PriorityQueue<>();

            pq.offer(items.get(0));

            while(!pq.isEmpty()){
                //print(pq.toString());
                Item v=pq.poll();
                //print("빠짐: "+v.toString());

                if(v.getBound() >max){
                    Item u = new Item();
                    u.setLevel(v.getLevel()+1);
                    u.setWeight(v.getWeight()+items.get(u.getLevel()).getWeight());
                    u.setValue(v.getValue()+items.get(u.getLevel()).getValue());

                    if(u.getWeight() <= K && u.getValue()> max){
                        max = u.getValue();
                    }

                    u.setBound(bound(u));
                    //print("bound1: "+bound(u));
                    if(u.getBound() > max){
                        pq.offer(u);
                        //print(u.toString());
                    }
                    u = new Item();
                    u.setLevel(v.getLevel()+1);
                    u.setWeight(v.getWeight());
                    u.setValue(v.getValue());
                    u.setBound(bound(u));

                    //print("bound2: "+bound(u));
                    if(u.getBound() > max){
                        pq.offer(u);
                        //print(u.toString());
                    }

                }
            }


            System.out.println("#" + (test_case + 1) + " "+max);
        }

    }

    static int bound(Item i) {
        int j,k;
        int totW;
        int result;

        if (i.getWeight() > K) {
            return 0;
        }
        else{
            result = i.getValue();
            j=i.getLevel()+1;
            totW = i.getWeight();
            while(j<N && totW+items.get(j).getWeight() <= K){
                totW+=items.get(j).getWeight();
                result+=items.get(j).getValue();
                j++;
            }
            k=j;
            if(k<=N){
                result+= (K-totW) * (items.get(k).getValue()/items.get(k).getWeight());
            }
            return result;
        }
    }

    static void print(String msg){
        System.out.println(""+msg);
    }
}

class Item implements Comparable<Item>{
    int value;
    int weight;
    int level;
    int bound;

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                ", level=" + level +
                ", bound=" + bound +
                '}';
    }

    public Item() {
    }

    public Item(int weight, int value, int level) {
        this.value = value;
        this.weight = weight;
        this.level = level;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Item i) {
        if (this.getBound() > i.getBound()) {
            return -1;
        } else if (this.getBound() < i.getBound()) {
            return 1;
        }

        return 0;
    }
}
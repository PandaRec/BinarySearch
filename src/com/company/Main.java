package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        WorkInFile wr = new WorkInFile();
                wr.write();

                ArrayList<Integer> arr = wr.ReadFile();

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        //original search
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==num){
                System.out.println("Найдено "+i);
                break;
            }
        }
        System.out.println("-------------------------");

        for(int i =0;i<arr.size();i++){
            tree.insertNode(arr.get(i));
        }
        //tree.printTree(); - test print

        Node node = tree.findNodeByValue(num);
        if(node!=null){
            node.printNode();
        }

    }


}

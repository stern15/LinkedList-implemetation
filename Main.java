package com.myAbstractChallenge;


public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(null);
        String stringData = "2 4 1 5 7 3 8 6 9 8";
        String[] data = stringData.split(" ");
        for(String s:data){
            myLinkedList.addItem(new Node(s));
        }
        System.out.println("the size is: "+myLinkedList.getSize());
        myLinkedList.traverse(myLinkedList.getRoot());

        myLinkedList.removeItem(new Node("1"));
        System.out.println("the size is: "+myLinkedList.getSize());
        myLinkedList.traverse(myLinkedList.getRoot());
        myLinkedList.removeItem(null);



    }
}

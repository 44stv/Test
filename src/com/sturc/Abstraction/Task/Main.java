package com.sturc.Abstraction.Task;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null);

        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "5 7 1 4 9 8 6 2 3 0";

        String []data = stringData.split(" ");
        for (String s : data){
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());

        list.removeItem(new Node("5"));

        list.traverse(list.getRoot());
    }
}

package com.sturc.Abstraction.Task;

public class Main {

    public static void main(String[] args) {

        SearchTree searchTree = new SearchTree(null);

        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "5 7 1 4 9 8 6 2 3 0";

        String []data = stringData.split(" ");
        for (String s : data){
            searchTree.addItem(new Node(s));
        }

        searchTree.traverse(searchTree.getRoot());

        searchTree.removeItem(new Node("4"));

        searchTree.traverse(searchTree.getRoot());
    }
}

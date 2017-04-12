package com.Viki20170411;

public class Node {
    Node next;
    int value;
    public Node(int value){
    	this.value = value;
    }
    public Node(Node node,int value){
    	this.next = node;
    	this.value = value;
    }
    
}

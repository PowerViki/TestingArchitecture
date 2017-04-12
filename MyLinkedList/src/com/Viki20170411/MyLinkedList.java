package com.Viki20170411;

public class MyLinkedList {
    private Node head = null;
    private int size=0;
    
    public MyLinkedList(int value){
    	head = new Node(value);
    	size++;
    }

	
	public void add(int value){
		if(head==null){
			head = new Node(value);
			size++;
			return;
		}
		Node node = new Node(value);
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = node;
		size++;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void modify(int index,int value){
		Node temp = head;
		int count=1;
		while(count!=index){
			temp = temp.next;
			count++;
		}
		temp.value = value;
	}
	
	public void delete(int index){
		Node temp = head;
		int count=1;
		if(index>1 && index<=size){
		while(count!=index-1){
			temp = temp.next;
			count++;
		}
		temp.next = temp.next.next;
		}else if(index == 1){
			head = head.next;
		}else{
			return;
		}
		size--;
	}
	
	public int get(int index){
		if(index>0 && index<=size){
		Node temp = head;
		int count = 1;
		while(count !=index){
			temp = temp.next;
			count++;
		}
		return temp.value;
		}
		return (Integer) null;
	}
	
	public void printAll(){
		Node temp = head;
		if (head == null)
			return;
		while(temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public void getCommonPart(Node head1,Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		while(temp1.next!=null && temp2.next!=null){
			if(temp1.value<temp2.value){
				temp1 = temp1.next;
			}else if(temp1.value>temp2.value){
				temp2 = temp2.next;
			}else{
				System.out.println(temp1.value);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		
	}
	
/*	public void reverseprint(Node temp){
		temp = head;
		if(temp!=null && temp.next!=null){
			System.out.println(temp.value);
			reverseprint(temp.next);
		}else if(temp.next == null){
			System.out.println(head.value);
		}else{
			return;
		}
	}*/
	
	public Node reverseList(){
		Node cur=null;
		Node pre =null;
		Node next = null;
		if(head == null){
			return null;
		}
		cur = head;
		while(cur!=null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			
		}
		head = pre;
		return head;
	}

}

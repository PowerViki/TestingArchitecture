package com.Viki20170411;

public class MyLinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList ls = new MyLinkedList(1);

		ls.add(2);
		ls.add(3);
		ls.modify(2, 5);
		ls.printAll();
		ls.reverseList();
		ls.printAll();
	}

}

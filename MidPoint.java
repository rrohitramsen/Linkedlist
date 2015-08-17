package com.rrohit.algo.linkedlist;
/*
 * @author rrohit
 */

public class MidPoint {
	
	public <T>Node<T> findMidNode(Node<T> head) {
		
		if (head == null) {
			System.out.println("List Empty ::");
			return null;
		}
		
		Node<T> mid = head, fast = head;
		while (fast.getNext() != null) {
			fast = fast.getNext();
			if (fast.getNext() != null) {
				fast = fast.getNext();
				mid = mid.getNext();
			}
		}
		return mid;
	}
	
	public void displayReverse(Node head){
		if(head ==  null){
			return;
		}
		displayReverse(head.getNext());
		System.out.print(head);
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=1; i<5; i++) {
			list.add(i);
		}
		list.display();
		MidPoint mp = new MidPoint();
		System.out.println("Mid = "+mp.findMidNode(list.getHead()));
		mp.displayReverse(list.getHead());
	}

}

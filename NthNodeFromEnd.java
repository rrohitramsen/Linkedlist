package com.rrohit.algo.linkedlist;
/*
 * @author rrohit
 */
public class NthNodeFromEnd {
	
	public <T>Node<T> findNthNodeFromEnd(Node<T> head, int n) {
		
		if (head == null) {
			return null;
		}
		
		Node<T> nthNode = head, current = head;
		int count = 1;
		
		while (count < n) {
			current = current.getNext();
			if (current == null) {
				System.out.println("Inavlid n :: "+n+" size of Linked List = "+count);
				return null;
			}
			count++;
		}
		
		while (current.getNext() != null) {
			nthNode = nthNode.getNext();
			current = current.getNext();
		}
		
		return nthNode;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=1; i<10; i++) {
			list.add(i);
		}
		list.display();
		NthNodeFromEnd nth = new NthNodeFromEnd();
		Node node = nth.findNthNodeFromEnd(list.getHead(), 10);
		System.out.println("3rd Node from End = "+node);
		System.out.println("Size = "+list.getSize());
		
	}

}

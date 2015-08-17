package com.rrohit.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class HasCycle {
	
	public <T> Node<T> hashCycleUsingMap(Node<T> head) {
		
		if (head == null) {
			return null;
		}
		
		Map<Node<T>, Node<T>> map = new HashMap<Node<T>, Node<T>>();
		Node<T> current = head;
		while(current.getNext() != null) {
			
			if (map.containsKey(current)) {
				return current;
			}
			map.put(current, current.getNext());
			current = current.getNext();
		} 
		System.out.println("No Loop : Null Terminated List");
		return null;
	}
	
	public <T> Node<T> hashCycle(Node<T> head) {
		
		if (head == null) {
			return null;
		}
		
		Node<T> slow = head, fast = head;
		
		while (fast != null) {
			fast = fast.getNext();
			if (fast == head) {
				System.out.println("Head : Loop Found");
				return fast;
			}
			if (fast == null) {
				System.out.println("No Loop: Null Terminated");
				return null;
			}
			if (slow == fast) {
				System.out.println("Loop Found :");
				return slow;
			}
			
			fast = fast.getNext();
			if (slow == fast) {
				System.out.println("Loop Found :");
				return slow;
			}
			slow = slow.getNext();
		}
		return null;
	}
	
	public int findSize(Node head) {
		Node current = head;
		int size=1;
		while (current.getNext() != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	
	
	public <T> Node<T> findLoopNode(Node<T> head){
		
		Node<T> loopNode = hashCycle(head);
		if (loopNode == null) {
			System.out.println("Null Terminated Linked List");
			return null;
		}
		
		/*
		 * Loop found, now break the list and find out the intersection point.
		 */
		Node<T> head1 = loopNode.getNext();
		loopNode.setNext(null);
		
		Node<T> current = head, current1= head1;
		int size = findSize(head); // list size
		int size1 =  findSize(head1); // list1 size
		System.out.println("Size of loop = "+size1);
		
		int diff = 0;
		if (size > size1) {
			diff = size-size1;
			while (diff>0){
				current = current.getNext();
				diff--;
			}
		}else{
			diff = size1-size;
			while (diff>0){
				current1 = current1.getNext();
				diff--;
			}
		}
		
		while (current != current1) {
			current = current.getNext();
			current1 = current1.getNext();
		}
		System.out.println("Loop Node ::"+current);
		return current;
	} 
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Node<Integer> loopNode = null;
		for (int i=1; i<10; i++) {
			Node<Integer> node = new Node<Integer>(i);
			list.add(node);
			if (i==1){
				loopNode = node;
			}
		}
		list.getTail().setNext(loopNode);
		
		//list.display();
		HasCycle hc = new HasCycle();
		System.out.println("Loop Node : "+hc.findLoopNode(list.getHead()));
	}
	

}

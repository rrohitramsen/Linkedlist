package com.rrohit.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 *@author : rrohit 
 */

public class DeepCopy {
	
	private RandomNode head;
	private RandomNode tail;
	public DeepCopy(){
		head = null;
		tail = null;
	}
	
	public void add(int data){
		this.add(new RandomNode(data));
	}
	
	public void add(RandomNode node){
		if (this.head == null) {
			head = node;
			tail = head;
		}else {
			tail.next = node;
			tail = node;
		}
	}
	
	public void display(RandomNode head){
		RandomNode current = head;
		while(current != null){
			System.out.print("["+current.data+"]-->[Random-"+current.random.data+",Next-->");
			current = current.next;
		}
		System.out.print("null");
	}
	
	public RandomNode deepCopyUsingHashMap(){
		if (this.head == null){
			return null;
		}
		
		Map<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();
		RandomNode current = head;
		RandomNode newNode = null;
		while(current != null){
			newNode = new RandomNode(current.data);
			map.put(current, newNode);
			current = current.next;
		}
		current = head;
		while (current != null){
			newNode = map.get(current);
			newNode.next = map.get(current.next);
			newNode.random = map.get(current.random);
			newNode = newNode.next;
			current = current.next;
		}
		return map.get(head);
	}
	
	/*
	 * In constant space, not more then required to clone linked list
	 * But this is not the right approach in run time because we are destroying the original linked list.
	 * if anybody wants to access original linked list then that is gone.
	 * Can't revert back the original till cloning completes because some node random can pint back to previous node as well.
	 */
	public RandomNode deepCopyInPlace() {
		if (this.head == null){
			return null;
		}
		
		RandomNode current = head;
		RandomNode newNode, temp;
		
		while (current != null){
			temp = current.next;
			newNode = new RandomNode(current.data);
			current.next = newNode;
			newNode.next = temp;
			current = temp;
		}
		current = head;
		RandomNode head1 = null, clone=null;
		while (current != null){
			temp = current.next;
			if (head1 == null){
				head1 = temp;
				head1.random = current.random.next;
				clone = head1;
			}else{
				clone.next = temp; 
				clone = clone.next;
				clone.random = current.random.next;
			}
			current = temp.next;			
		}
		clone.next = null;
		return head1;
	}
	
	public class RandomNode{
		int data;
		RandomNode next;
		RandomNode random;
		public RandomNode(){}
		public RandomNode(int data) {
			this.random = null;
			this.next = null;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		DeepCopy dp = new DeepCopy();
		DeepCopy.RandomNode n1 = dp.new RandomNode(1);
		DeepCopy.RandomNode n2 = dp.new RandomNode(2);
		DeepCopy.RandomNode n3 = dp.new RandomNode(3);
		DeepCopy.RandomNode n4 = dp.new RandomNode(4);
		DeepCopy.RandomNode n5 = dp.new RandomNode(5);
		DeepCopy.RandomNode n6 = dp.new RandomNode(6);
		DeepCopy.RandomNode n7 = dp.new RandomNode(7);
		dp.add(n1);
		dp.add(n2);
		dp.add(n3);
		dp.add(n4);
		dp.add(n5);
		dp.add(n6);
		dp.add(n7);
		n1.random=n3;
		n2.random=n4;
		n3.random=n5;
		n4.random=n6;
		n5.random=n7;
		n6.random=n3;
		n7.random=n2;
		dp.display(dp.head);
		System.out.println("\n After Cloning");
//		RandomNode clone = dp.deepCopyUsingHashMap();
		RandomNode clone = dp.deepCopyInPlace();
		dp.display(clone);
	}

}

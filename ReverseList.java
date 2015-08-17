package com.rrohit.algo.linkedlist;

public class ReverseList {
	
	public Node reverseList(Node head) {
		if (head == null) {
			return null;
		}
		Node nextNode = null, prevNode = null, current= head;;
		while (current != null) {
			
			nextNode = current.getNext(); 
			current.setNext(prevNode);
			prevNode = current;
			current = nextNode;
		}
		return prevNode;
	}
	
	public <T>Node<T> reverseListInPairs(Node<T> head){
		
		if (head== null || head.getNext() == null) {
			return head;
		}
		
		Node<T> current = head, temp =null, temp2 = null, prev = null;
		head = head.getNext();
		while (current!= null && current.getNext() != null) {
			
			temp = current.getNext();
			temp2 = temp.getNext();
			
			temp.setNext(current);
			current.setNext(temp2);
			
			//prev will be used in 2nd pair onwards
			if (prev != null) {
				prev.setNext(temp);
			}
			prev = current;
			
			current = current.getNext();
		}
		return head;
	}
	
	public <T>Node<T> reverseListInK(Node<T> head, int k){
		
		Node<T> current = head,
				prev = null,
				nextNode = null;
		int count =0;
		
		while (current != null && count<k) {
			nextNode = current.getNext();
			current.setNext(prev);
			prev = current;
			current = nextNode;
			count++;
		}
		
		if (nextNode != null) {
			head.setNext(reverseListInK(nextNode, k));
		}
		return prev;
	}
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=1; i<6; i++) {
			list.add(i);
		}
		list.display();
		
		ReverseList rl = new ReverseList();
		/*Node head = rl.reverseList(list.getHead());
		list.setHead(head);
		list.display();*/
		list.display();
		/*Node head1 = rl.reverseListInPairs(list.getHead());
		list.setHead(head1);
		list.display();*/
		
		Node head1 = rl.reverseListInK(list.getHead(),3);
		list.setHead(head1);
		list.display();
	}

}

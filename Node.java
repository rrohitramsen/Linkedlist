package com.rrohit.algo.linkedlist;
/*
 * @author rrohit
 */
public class Node<T> {
	
	private Node<T> next;
	private T value;
	
	public Node(){
		this.next = null;
	}
	
	public Node(T value){
		this();
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public String toString() {
		return "["+this.getValue()+"]-->";
	}

}

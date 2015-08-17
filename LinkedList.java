package com.rrohit.algo.linkedlist;

public class LinkedList<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public LinkedList(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public boolean add(T value){
		return this.add(new Node<T>(value));
	}
	
	/*
	 * Adding at last
	 */
	public boolean add(Node<T> node){
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		}else {
			tail.setNext(node);
			tail = node;
		}
		size++;
		return true;
	}
	
	
	public boolean remove(T value){
		
		if (this.head ==  null) {
			return false;
		}else {
			Node<T> current = head;
			Node<T> prev = current;
			boolean found = false;
			while (current.getNext() != null) {
				if (current.getValue().equals(value)) {
					found = true;
					break;
				}
				prev = current;
				current = current.getNext();
			}
			if (found) {
				if (tail.getValue().equals(value)) {
					prev.setNext(null);
					tail = prev;
					current = null;
				}else {
					Node<T> temp = current;
					prev.setNext(current.getNext());
					temp = null;
					return true;
				}
			}
			return false;
		}
		
	}
	
	public void clear(){
		size = 0;
		head = tail = null;
	}
	
	public void display() {
		Node<T> current = head;
		while (current != null) {
			System.out.print("["+current.getValue()+"]-->");
			current = current.getNext();
		}
		System.out.println("[null]");
	}
	
}

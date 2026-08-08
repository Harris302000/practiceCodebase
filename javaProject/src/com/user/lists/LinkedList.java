 package com.user.lists;

public class LinkedList {

	private Node head;
	private Node tail;
	private int length;

	public Node getHead() {
		System.out.println("Head::" + head.value);
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		System.out.println("Tail::" + tail.value);
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getLength() {
		System.out.println("Length::" + length);
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public class Node {

		public int value;
		public Node next;

		Node(int value) {
			this.value = value;
			next = null;
		}

	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;

	}

	public void printLinkedList() {

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}

	}

	public void append(int value) {

		Node NewNode = new Node(value);

		if (length == 0) {
			head = NewNode;
			tail = NewNode;
		} else {
			tail.next = NewNode;
			tail = NewNode;
		}

		length++;

	}

	public Node removeLast() {

		Node temp = head;
		Node pre = head;

		if (length == 0)
			return null;

		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}

		tail = pre;
		tail.next = null;
		length--;

		if (length == 0) {
			head = null;
			tail = null;

		}

		return temp;

	}

	public void prepend(int value) {

		Node NewNode = new Node(value);

		if (length == 0) {
			head = NewNode;
			tail = NewNode;
		} else {
			NewNode.next = head;
			head = NewNode;
		}

		length++;

	}

	public Node removeFirst() {

		if (length == 0) {
			return null;
		}

		Node temp = head;
		head = head.next;
		temp.next = null;

		length--;

		if (length == 0) {
			head = null;
			tail = null;
		}

		return temp;
	}

	public Node get(int index) {

		if (index >= length || index < 0) {
			return null;
		}

		Node temp = head;

		for (int i = 0; i < index; i++) {

			temp = temp.next;

		}

		return temp;
	}

	public boolean set(int index, int value) {

		Node temp = get(index);

		if (temp != null) {
			temp.value = value;
			return true;

		}

		return false;

	}

	public boolean insert(int index, int value) {

		if (index < 0 || index > length)
			return false;

		if (index == 0) {
			prepend(value);
			return true;
		}

		if (index == length) {
			append(value);
			return true;
		}

		Node newNode = new Node(value);

		Node temp = get(index - 1);

		newNode.next = temp.next;

		temp.next = newNode;

		length++;

		return true;
	}

	public Node remove(int index, int value) {

		if (index < 0 || index >= length)
			return null;

		if (index == 0)
			return removeFirst();

		if (index == length - 1)
			return removeLast();

		Node prev = get(index - 1);
		Node temp = prev.next;

		prev.next = temp.next;
		temp.next = null;

		length--;

		return temp;
	}

	public void reverse() {

		Node temp = head;
		head = tail;
		tail = temp;

		Node before = null;
		Node after = temp.next;

		while (temp != null) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}

	}

	public Node findMiddleNode() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;

			fast = fast.next.next;

		}

		return slow;

	}

	public boolean hasLoop() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}

		}

		return false;

	}

	public Node findKthFromEnd(int k) {

		if (k <= 0) {
			return null;
		}

		// Both pointers start at the head
		Node slow = head;
		Node fast = head;

		// Move the fast pointer k steps ahead
		for (int i = 0; i < k; i++) {
			// If fast hits null before k steps,
			// the list has fewer than k nodes
			if (fast == null) {
				return null;
			}
			fast = fast.next;
		}

		// Move both pointers until fast hits the end
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		// Slow is now at the k-th node from the end
		return slow;

	}

	public void removeDuplicates() {

		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.value == current.value) {
					runner.next = runner.next.next;
					length -= 1;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}

	}

	public int binaryToDecimal() {

		int num = 0;

		Node current = head;

		while (current != null) {

			num = (2 * num) + current.value;

			current = current.next;

		}

		return num;

	}

}

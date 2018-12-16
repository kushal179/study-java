package study;

class Node {
	int data;
	Node next = null;

	public Node(int data) {
		this.data = data;
	}

	void append(int d) {
		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	Node delete(Node head, int d) {
		Node n;
		if (head.data == d || head.next == null)
			return head;

		n = head;

		while (n.next != null) {
			if (d == n.next.data) {
				n.next = n.next.next;
				break;
			}
			n = n.next;
		}
		return n.next;
	}
}

public class LinkedListPrac {

	/**
	 * @param args
	 */
	Node head;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

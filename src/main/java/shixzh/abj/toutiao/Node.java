package shixzh.abj.toutiao;

/**
 * 1.求单链表的中节点
 * 链表定义：链表是常用的数据结构，链表中的节点是顺次相连的，单链表中每个节点只能知道其下一个节点，
 * 这样的特性使得其查找复杂度高，但是删除和增加节点复杂度为O(1)。
 * 实现思路：使用快慢指针，两个指针分别从头结点出发，第一个指针每次移动一步，
 * 第二个指针每次移动两步，当第一个指针到达链表的尾节点时，第二个指针的位置恰为中节点。
 * 
 * 2.判断单链表中是否有环(链表头尾不相连)
 * 实现思路：思路与上题基本一致，仍然是快慢指针，快指针的速度是慢指针的两倍，
 * 若快指针到达尾节点（=null）时两指针未相遇(==)，则无环，反之即有环。
 * @author shixzh
 *
 */
public class Node {

	int value;
	Node next;

	public Node(int n, Node node) {
		this.value = n;
		this.next = node;
	}

	public static Node getMiddleNode(Node head) {
		if (head.next == null)
			return head;
		Node target = head;
		Node temp = head;
		while (temp != null && temp.next != null) {
			target = target.next;
			temp = temp.next.next;
		}
		return target;
	}

	public static boolean hasCycle(Node head) {
		if (head.next == null)
			return false;
		Node fastNode = head;
		Node slowNode = head;
		while (fastNode != null && slowNode != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if (slowNode == fastNode)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(4, node3);
		Node node5 = new Node(5, node4);
		Node node6 = new Node(6, node5);
		System.out.println(getMiddleNode(node6).value);
		System.out.println(hasCycle(node6));
	}
}

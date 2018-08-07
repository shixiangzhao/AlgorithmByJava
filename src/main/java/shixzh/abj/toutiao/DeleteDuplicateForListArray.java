package shixzh.abj.toutiao;

/**
 * 删除链表中重复的节点
 * 
 * @author shixiang.zhao
 *
 */
public class DeleteDuplicateForListArray {
	// 结点定义，包括当前结点的值和next指向
	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public String toString() {
			return val + "";
		}
	}

	// 删除值相等的节点
	public static ListNode deleteDuplicateNode(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		// 定义一个临时的头结点，因为头结点也可能被删除
		ListNode root = new ListNode();
		root.next = head;
		ListNode prev = root;
		ListNode node = head;

		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				// 若有连续相同的结点，则node要一直++
				while (node.next != null && node.next.val == node.val)
					node = node.next;
				prev.next = node.next; // note的父节点的子节点变为node的子节点
			} else {
				prev.next = node; // note的父节点的子节点变为node
				prev = prev.next; // prev++
			}
			node = node.next; // node++
		}
		return root.next;
	}

	// 打印出来删除后的结果
	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head + "->");
			head = head.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		// 按照结点的定义新建一个链表
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		// 调用delete函数，传入n1的值，当成头结点
		ListNode result = deleteDuplicateNode(n1);
		print(result);

	}
}

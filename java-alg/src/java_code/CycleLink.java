package java_code;

public class CycleLink {
	public static void main(String[] args) {
		Node node1 = new Node(5);
		Node node2 = new Node(3);
		Node node3 = new Node(7);
		Node node4 = new Node(2);
		Node node5 = new Node(6);
		Node node6 = new Node(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node4;
		
		System.out.println(isCycle(node1));
		
	}
	
	private static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static class Results{
		private boolean flag;
		private Node node;
		private int node_len;
		private int cycle_len;
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		
		public void setNode(Node node) {
			this.node = node;
		}
		
		public void setNode_len(int node_len) {
			this.node_len = node_len;
		}
		public void setCycle_len(int cycle_len) {
			this.cycle_len = cycle_len;
		}
		@Override
		public String toString() {
			return "循环链表：" + flag + "\n" +
					"相遇节点：" + node + "\n" +
					"相遇长度：" + node_len + "\n" +
					"循环长度：" + cycle_len;
		}
	}
	
	public static Results isCycle(Node head) {
		Node p1 = head;
		Node p2 = head;
		Results rs = new Results();
		
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				rs.setFlag(true);
				rs.setNode(p1);
				break;
			}

		}
		if(rs.flag) {
			p1 = rs.node;
			p2 = rs.node;
			int len = 0;
			while(true) {
				p1 = p1.next;
				p2 = p2.next.next;
				len++;
				if(p1 == p2) break;
			}
			rs.setCycle_len(len);
			
			p1 = head;
			p2 = rs.node;
			len = 0;
			while(true) {
				len++;
				if(p1 == p2) break;
				p1 = p1.next;
				p2 = p2.next;
			}
			rs.setNode_len(len);
		}
		else rs.flag = false;
		return rs;
	}
}

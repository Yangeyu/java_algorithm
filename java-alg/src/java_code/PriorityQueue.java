package java_code;

import java.util.Arrays;

public class PriorityQueue {
	private int[] array;
	private int size;
	public PriorityQueue() {
		array = new int[32];
	}
	
	/**
	 * 入队
	 * @param key
	 */
	public void enQueue(int key) {
		if(size >= array.length) {
			resize();
		}
		array[size++] = key;
		upAdjust();
	}
	
	/**
	 * 出队
	 * @return
	 * @throws Exception
	 */
	public int deQueue() throws Exception {
		if(size <= 0) {
			throw new Exception("the queue is empty!");
		}
		int head = array[0];
		array[0] = array[--size];
		downAdjust();
		return head;
	}
	
	/**
	 * 上浮
	 */
	public void upAdjust() {
		int childIndex = size-1;
		int parentIndex = (childIndex-1)/2;
		int temp = array[childIndex];
		//比较子节点与父节点的大小
		//子节点要小于最大节点0
		while(childIndex > 0 && temp > array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex-1)/2;
		}
		array[childIndex] = temp;
	}
	
	/**
	 * 下沉
	 * 删除节点时头结点的值为最后一个节点的值
	 */
	public void downAdjust() {
		int parentIndex = 0;
		int childIndex = 1;
		int temp = array[0];
		while(childIndex < size) {
			if(array[childIndex+1] > array[childIndex]) {
				childIndex += 1;
			}
			if(temp < array[childIndex]) {
				array[parentIndex] = array[childIndex];
				parentIndex = childIndex;
				childIndex = parentIndex*2 +1;
			}else break;
		}
		array[parentIndex] = temp;
	}
	
	/**
	 * 扩展容量
	 */
	private void resize() {
		int newsize = this.size * 2;
		this.array = Arrays.copyOf(this.array, newsize);
		
	}
	@Override
	public String toString() {
		return Arrays.toString(this.array);
	}
	
	public static void main(String[] args) throws Exception {
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.enQueue(3);
		priorityQueue.enQueue(5);
		priorityQueue.enQueue(10);
		priorityQueue.enQueue(2);
		priorityQueue.enQueue(7);
		System.out.println(priorityQueue.toString());
		System.out.println("出队元素：" + priorityQueue.deQueue());
		System.out.println("出队元素：" + priorityQueue.deQueue());
		
		
	}
}


package counter;

public class ArrayQueue<E> implements Queue<E>{
	
	private int containerSize = 10;
	private E[] container;
	private int front = -1;
	private int rear = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		this.container = (E[]) new Object[containerSize];
	}

	@Override
	public void enqueue(E e) {
		if (this.size() >= containerSize*0.75) {
			this.reshape();
		}
		if (isEmpty()) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear+1)%containerSize;
		}
		container[rear] = e;
	}

	@Override
	public E dequeue() {
		E e = container[front];
		front = (front+1)%containerSize;
		if (front > rear) {
			front = -1;
			rear = -1;
		}
		return e;
	}

	@Override
	public E front() {
		return container[front];
	}

	@Override
	public boolean isEmpty() {
		return front == -1;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = front; i < rear+1; ++i) {
			stringBuffer.append(container[i].toString());
			stringBuffer.append(" ");
		}
		return stringBuffer.toString();
	}
	
	public int size() {
		return (rear + containerSize + 1 - front) % containerSize;
	}
	
	private void reshape() {
		this.containerSize *= 2;
		@SuppressWarnings("unchecked")
		E[] newContainer = (E[]) new Object[this.containerSize];
		int index = 0;
		for (int i = front; i < rear+1; ++i) {
			newContainer[index++] = this.container[i]; 
		}
		front = 0;
		rear = index-1;
		this.container = newContainer;
	}
	
}

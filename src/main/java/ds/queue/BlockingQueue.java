package ds.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	
	private Object[] arr;
	private int putIndex, takeIndex;
	private int size;
	private int currentSize;
	private ReentrantLock lock;
	private Condition notFull, notEmpty;
	
	public BlockingQueue(int size) {
		this.arr = new Object[size];
		this.size = size;
		this.putIndex = this.takeIndex = 0;
		
		lock = new ReentrantLock(true);
		notEmpty = lock.newCondition();
		notFull = lock.newCondition();
	}
	
	public void enqueue(T obj) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			while(currentSize==size) {
				notFull.await();
			}
			Object[] elems = this.arr;
			elems[putIndex] = obj;
			if(++putIndex==elems.length) {
				putIndex = 0;
			}
			currentSize++;
			notEmpty.signal();
		}finally {
			lock.unlock();
		}
	}
	
	public T dequeue() throws InterruptedException {
		T item = null;
		lock.lock();
		try {
			while(currentSize==0) {
				notEmpty.await();
			}
			Object[] elems = this.arr;
			item = (T)elems[takeIndex];
			elems[takeIndex] = null;
			if(--takeIndex==elems.length) {
				takeIndex=0;
			}
			currentSize--;
			notEmpty.signal();
		}finally {
			lock.unlock();
		}
		
		return item;
	}

}

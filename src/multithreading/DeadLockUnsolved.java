package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockUnsolved {
	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);
	
	public static void main(String[] args) {
		
		DeadLockUnsolved deadLock = new DeadLockUnsolved();
		
		
		new Thread(deadLock::worker1,"worker1").start();
		new Thread(deadLock::worker2,"worker2").start();
	}
	
	public void worker1() {
		lock1.lock();
		System.out.println("worker 1 acquires lock 1...");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lock2.lock();
		System.out.println("worker 1 acquired lock 2 ....");
		
		lock1.unlock();
		lock2.unlock();
	}
	
	public void worker2() {
		lock2.lock();
		System.out.println("worker 2 acquires lock 2...");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lock1.lock();
		System.out.println("worker 2 acquired lock 1 ....");
		
		lock1.unlock();
		lock2.unlock();
	}
}

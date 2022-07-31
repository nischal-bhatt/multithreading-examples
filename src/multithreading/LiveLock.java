package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);
	
	public static void main(String[] args) {
		
		LiveLock liveLock = new LiveLock();
		
		
		new Thread(liveLock::worker1,"worker1").start();
		new Thread(liveLock::worker2,"worker2").start();
	}
	
	public void worker1() {
		
		while(true)
		{
			try {
				lock1.tryLock(50,TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("worker 1 acquires the lock...");
			System.out.println("worker 1 trues to get lock 2...");
			
			
			if (lock2.tryLock())
			{
				System.out.println("worker 1 acquires lock 2");
				lock2.unlock();
			}else
			{
				System.out.println("worker 1 cannot acquire lock 2");
			    
			    continue;
			}
			
			break;
			
		}
		
		
		
		lock1.unlock();
		lock2.unlock();
	}
	
	public void worker2() {
		
		while(true)
		{
			try {
				lock2.tryLock(50,TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("worker 2 acquires the lock2...");
			System.out.println("worker 2 trues to get lock 1...");
			
			
			if (lock1.tryLock())
			{
				System.out.println("worker 2 acquires lock 1");
				lock1.unlock();
			}else
			{
				System.out.println("worker 2 cannot acquire lock 1");
				
				continue;
			}
			
			break;
			
		}
		
		lock1.unlock();
		lock2.unlock();
	}
}

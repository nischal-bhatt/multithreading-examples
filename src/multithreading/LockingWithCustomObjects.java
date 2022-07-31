package multithreading;

public class LockingWithCustomObjects {

	public static int counter1 = 0;
	public static int counter2 = 0;
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();
	// we have to make sure this method is called 
	// only by a single thread at a time;
	//usually it is not a good practise to use synchronized like thi
	// in the method itself
	public static void increment1() 
	{
		//class level locking
		// rule of thumb - we synchronize blocks that are 100% necessary.. so we dont synchronze an entire method
		synchronized(lock1) {
		counter1 ++;
		}
	}
	
	//whenever a thread is executing a synchronized method,
	//it obtains a lock of that entire class.. 
	// because ProblemsWithSynchronization object has a single lock: this is why the methods 
	// cannot be executed at the same time (time slicing)
	public static void increment2() 
	{
		//now because of this, the two acquired locks are not using the 
		// same intrinsic lock of the class
		//at the same time != parallel - CPU time slicing
		synchronized(lock2)
		{
		counter2 ++;
		}
	}
	
	public static void process () {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i =0; i<100; i++)
				{
					increment1();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i =0; i<100; i++)
				{
					increment2();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
		t1.join();
		t2.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("the counter1 is " + counter1);
		System.out.println("the counter2 is " + counter2);
		
	}
	
	public static void main(String[] args) {

		process();
	}

}

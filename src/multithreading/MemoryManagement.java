package multithreading;

public class MemoryManagement {

	public static int counter = 0;
	
	// we have to make sure this method is called 
	// only by a single thread at a time;
	public static synchronized void increment() 
	{
		counter ++;
	}
	
	public static void process () {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i =0; i<100; i++)
				{
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i =0; i<100; i++)
				{
					increment();
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
		
		System.out.println("the counter is " + counter);
		
	}
	
	public static void main(String[] args) {

		process();
	}

}

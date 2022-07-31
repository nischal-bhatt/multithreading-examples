package multithreading;

class Process {
	public void produce() throws InterruptedException {

		synchronized(this)
		{
			Thread.sleep(100);
			System.out.println("running the produce method");
			wait();
			System.out.println("again in the produce method");
		}
	}

	public void consume() throws InterruptedException {

		Thread.sleep(1000);
		
		synchronized(this)
		{
		     System.out.println("consumer method is executed");
		     notify();
		}
	}
}

public class WaitAndNotify {

	public static void main(String[] args) {

		Process process = new Process();
		
		
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t2.start();
		t1.start();
	}

}

package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {

	private BlockingQueue<Integer> queue;
	
	public FirstWorker(BlockingQueue<Integer> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		 int counter = 0;
		 while (true)
		 {
			 try {
				queue.put(counter);
				System.out.println("putting item in queue.. " + counter);
				counter++;
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
	
}


class SecondWorker implements Runnable {

	private BlockingQueue<Integer> queue;
	
	public SecondWorker(BlockingQueue<Integer> queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run() {
		 while (true)
		 {
			 try {
				int counter = queue.take();
				System.out.println("taking item item from queue.. " + counter);
				
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
	
}

public class BlockingQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = 
				new ArrayBlockingQueue<>(10);
		
		FirstWorker firstWorker = new FirstWorker(queue);
		SecondWorker secondWorker = new SecondWorker(queue);
		
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
	}
}

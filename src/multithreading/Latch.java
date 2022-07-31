package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Workerlatch implements Runnable {

	private int id;
	private CountDownLatch latch;

	public Workerlatch(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		doWork();
		latch.countDown();
	}

	private void doWork() {
		try {
			System.out.println("Thread with ID " + this.id + " starts working");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class Latch {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);
		// if change to 10 from 5 what happens?

		ExecutorService service = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
			service.execute(new Workerlatch(i, latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("all tasks have been finished...");
        service.shutdown();
	}
}

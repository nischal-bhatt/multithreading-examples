package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	public static void main(String[] args) {
		
		ExecutorService newSingleThreadExecutor = Executors.newFixedThreadPool(3);
	
	
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("my task1");
				
			}
			
		};
		
		Runnable task2 = () -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("my task2");
		};
		
		newSingleThreadExecutor.submit(task1);
		newSingleThreadExecutor.submit(task2);
		newSingleThreadExecutor.shutdown();
	}
}

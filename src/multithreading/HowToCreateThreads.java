package multithreading;

class Runner3 implements Runnable {
	

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 3: " + i);
		}
	}
}

class Runner4 implements Runnable{
	

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner 4: " + i);
		}
	}
}

public class HowToCreateThreads {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runner3());
		Thread t2 = new Thread(new Runner4());
		
		t1.start();
		t2.start();
		//this is multithreading with time slicing 
		//this is NOT parallel execution
		// only a single cpu core is being used

	}

}

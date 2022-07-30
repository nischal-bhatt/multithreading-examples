package multithreading;

class Runner7 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println("Runner7 : " + i);
		}
	}
}

class Runner8 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println("Runner8 : " + i);
		}
	}
}

public class WaitForThreadsToFinish {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Runner7();
		Thread t2 = new Runner8();

		t1.start();
		t2.start();
		
		//t1.join();
		t2.join();
		//now main threads only waits for t2 to finish!
		
		System.out.println("finished with threads");
	}

}

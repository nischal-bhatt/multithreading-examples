package multithreading;

class VolatileWorker implements Runnable {

	private volatile boolean terminated;
	// to avoid caching of terminated flag variable

	@Override
	public void run() {
		while (!terminated) {
			System.out.println("working class is running...");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.terminated = isTerminated;
	}

}

public class Volatile {
	public static void main(String[] args) {

		VolatileWorker w = new VolatileWorker();
		
		Thread t1 = new Thread(w);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		w.setTerminated(true);
		System.out.println("algorithm is terminated");
	}
}

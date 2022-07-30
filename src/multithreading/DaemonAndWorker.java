package multithreading;

class DaemonWorker implements Runnable {

	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("daemon thread is running...");
		}
		
	}
	
}

class NormalWorker implements Runnable {

	@Override
	public void run() {
		
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("normal thread is finished...");
		
		
	}
	
}

public class DaemonAndWorker {

     public static void main(String[] args) {
		
//    	 String name = Thread.currentThread().getName();
//	     System.out.println(name);
//	     System.out.println(name + " is a worker thread ");
//	     garbage collection is a daemon thread
//	     daemon threads are terminated by jvm when all other worker threads are terminated
     
        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());
        t1.setDaemon(true);

        t1.start();
        t2.start();
     }
}

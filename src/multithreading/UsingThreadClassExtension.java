package multithreading;

class Runner5 extends Thread {
	public void run() 
	{
		for (int i =0; i<10; i++)
		{
			try {
				Thread.sleep(100);
				//cease execution for 100 millisecs
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner5 : " + i);
		}
		
	}
}

class Runner6 extends Thread {
	public void run() 
	{
		for (int i =0; i<10; i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner6 : " + i);
		}
		
	}
}

public class UsingThreadClassExtension {

	public static void main(String[] args) {

		Thread t1 = new Runner5();
		Thread t2 = new Runner6();
		
		t1.start();
		t2.start();
	}

}

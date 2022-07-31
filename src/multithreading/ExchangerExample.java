package multithreading;

import java.util.concurrent.Exchanger;

class FirstThread implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public FirstThread(Exchanger<Integer> exchanger)
	{
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			counter++;
			System.out.println("first thread incremented the counter " + counter);
		    try {
				counter=exchanger.exchange(counter);
				System.out.println("first thread get the counter " + counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class SecondThread implements Runnable {

	private int counter;
	private Exchanger<Integer> exchanger;
	
	public SecondThread(Exchanger<Integer> exchanger)
	{
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			counter--;
			System.out.println("second thread decremented the counter " + counter);
		    try {
				counter=exchanger.exchange(counter);
				System.out.println("second thread get the counter " + counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ExchangerExample {

	public static void main(String[] args) {
		
		Exchanger<Integer> exchanger = new Exchanger<>();
		
		FirstThread t1 = new FirstThread(exchanger);
		SecondThread t2 = new SecondThread(exchanger);
		
		new Thread(t1).start();
		new Thread(t2).start();
	}
}

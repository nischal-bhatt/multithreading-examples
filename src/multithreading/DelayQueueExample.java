package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<DelayWorker> queue =
				new DelayQueue<>();
		
		try {
			queue.put(new DelayWorker("this is the first msg", 2000));
			queue.put(new DelayWorker("this is the second msg", 10000));
			queue.put(new DelayWorker("this is the third msg", 4500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class DelayWorker implements Delayed{

	private long duration;
	private String message;
	
	public DelayWorker(String message, long duration)
	{
		this.message = message;
		this.duration = System.currentTimeMillis() + duration;
	}
	
	@Override
	public int compareTo(Delayed o) {
		// this is the method that can compare obnjects
		
		if (duration < ((DelayWorker)o).getDuration())
		{
			return -1;
		}
		
		
		if (duration > ((DelayWorker)o).getDuration())
		{
			return +1;
		}
		
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DelayWorker [message=" + message + "]";
	}
	
	
}
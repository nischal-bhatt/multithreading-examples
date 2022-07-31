package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorkerPrior implements Runnable {

	private BlockingQueue<Person> queue;

	public FirstWorkerPrior(BlockingQueue<Person> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			queue.put(new Person(12, "adam"));
			queue.put(new Person(55, "kevin"));
			queue.put(new Person(27, "ana"));
			Thread.sleep(2000);
			queue.put(new Person(31, "daniel"));
			Thread.sleep(1000);
			queue.put(new Person(15, "joe"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class SecondWorkerPrior implements Runnable {

	private BlockingQueue<Person> queue;

	public SecondWorkerPrior(BlockingQueue<Person> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
			System.out.println(queue.take());
			Thread.sleep(5000);
			System.out.println(queue.take());
			Thread.sleep(2000);
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Person implements Comparable<Person>
{

	private int age;
	private String name;
	
	
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}



	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}



	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.getName());
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
}

public class PriorityBlockingQueueExample {

	public static void main(String[] args) {

		BlockingQueue<Person> queue =
				new PriorityBlockingQueue<>();
		
		FirstWorkerPrior first = new FirstWorkerPrior(queue);
		SecondWorkerPrior second = new SecondWorkerPrior(queue);
	
		new Thread(first).start();
		new Thread(second).start();
	}
}

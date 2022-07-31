package multithreading;

public class CopyOnWrite {

	public static void main(String[] args) {
		ConcurrentArray ca = new ConcurrentArray();
		ca.simulate();
	}
}

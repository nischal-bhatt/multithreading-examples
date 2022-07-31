package multithreading;

public class SequentialSumApp {

	public static void main(String[] args) {
		
		int[] nums  = {1,2,3,4,5,6};
		
		SequentialSum s = new SequentialSum();
		System.out.println(s.sum(nums));
		
	}
}

package multithreading;

import java.util.Random;

public class ParallelWorkerMain {

	public static void main(String[] args) {
		
		Random random = new Random();	
		
		int[] nums = new int[500000000];
		
		for (int i =0; i<500000000; i++)
		{
			nums[i] = random.nextInt(100);
		}
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
		SequentialSum seq = new SequentialSum();
		long start = System.currentTimeMillis();
		System.out.println("sum +_" + seq.sum(nums));
		System.out.println("Time : " + (System.currentTimeMillis() - start));
		
		
		
		ParallelSum parllel = new ParallelSum(availableProcessors);
		
		start = System.currentTimeMillis();
		
		System.out.println(parllel.sum(nums));
		System.out.println("Time : " + (System.currentTimeMillis() - start));
		
		
	}
}

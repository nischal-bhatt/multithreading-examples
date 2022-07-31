package multithreading;

public class ParallelSum {

	private ParallelWorker[] workers;
	private int numOfthreads;
	
	public ParallelSum(int numOfThreads)
	{
		this.numOfthreads = numOfThreads;
		this.workers = new ParallelWorker[numOfthreads];
	}
	
	public int sum(int[] nums)
	{
		int size= (int)Math.ceil(nums.length * 1.0/numOfthreads);
	    
		for (int i =0; i<numOfthreads; ++i)
		{
			workers[i] = new ParallelWorker(nums,i*size, (i+1)*size);
			workers[i].start();
		}
		
		try {
			for (ParallelWorker worker: this.workers)
			{
				worker.join();
			}
		}catch (InterruptedException e)
		{
			
		}
		
		int total = 0;
		
		for (ParallelWorker worker: workers)
		{
			total += worker.getPartialSum();
		}
		
		return total;
	}
	
}

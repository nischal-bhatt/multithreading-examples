package multithreading;

public class ParallelWorker extends Thread{
	
	private int[] nums;
	private int low;
	private int high;
	private int partialSum;
	
	
	
	public ParallelWorker(int[] nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = Math.min(nums.length, high);
	}


	public void run () {
		
	 partialSum = 0;
	 
	 for (int i = low; i<high; i++)
	 {
		 partialSum += nums[i];
	 }
		
		
		
	}


	public int[] getNums() {
		return nums;
	}


	public void setNums(int[] nums) {
		this.nums = nums;
	}


	public int getLow() {
		return low;
	}


	public void setLow(int low) {
		this.low = low;
	}


	public int getHigh() {
		return high;
	}


	public void setHigh(int high) {
		this.high = high;
	}


	public int getPartialSum() {
		return partialSum;
	}


	public void setPartialSum(int partialSum) {
		this.partialSum = partialSum;
	}
	
	

}

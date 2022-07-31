package multithreading;

public class ParallelMergeSort {

	 private int[] nums;
	 
	 private int[] tempArray;
	 
	 public ParallelMergeSort(int[] nums)
	 {
		 this.nums = nums;
		 this.tempArray = new int[nums.length];
	 }
	 
	 public void parallelMergeSort(int low, int high, int numOfThreads)
	 {
		 if (numOfThreads <= 1)
		 {
			 mergeSort(low,high);
			 return;
		 }
		 
		 int middle = (low  + high) /2 ;
		 
		 Thread leftSorted = createThread(low, middle, numOfThreads);
		 Thread rightSorted = createThread(middle + 1, high, numOfThreads);
		 
		 leftSorted.start();
		 rightSorted.start();
		 
		 try {
			leftSorted.join();
			rightSorted.join();
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 merge(low,middle,high);
	 }
	 
	 private Thread createThread(int low, int high, int numOfThreads)
	 {
		 return new Thread()
				 {
			         public void run()
			         {
			        	 parallelMergeSort(low,high,numOfThreads/2);
			         }

					
				 };
	 }
	 
	 public void sort() 
	 {
		 mergeSort(0, nums.length - 1);
	 }
	 
	 private void mergeSort(int low, int high) {
		
		 if (low >= high)
		 {
			 return ;
		 }
		 
		 //middle item
		 
		 int middleIndex = (low + high)/2;
		 
		 mergeSort(low, middleIndex);
		 
		 mergeSort(middleIndex + 1, high);
		 
		 //combine the sub solutions
		 
		 merge(low, middleIndex, high);
		
	}

	private void merge(int low, int middleIndex, int high) {
		
		for (int i = low; i<=high; i++)
		{
			tempArray[i] = nums[i];
		}
		
		int i = low;
		int j = middleIndex + 1;
		int k = low;
		
		while (i <= middleIndex && j <=high)
		{
			if (tempArray[i] < tempArray[j])
			{
				nums[k] = tempArray[i];
				++i;
			}else {
				nums[k] = tempArray[j];
				++j;
			}
			
			++k;
		}
		
		while (i<=middleIndex)
		{
			nums[k] = tempArray[i];
			++k;
			++i;
		}
		
		
		while (j<=high)
		{
			nums[k] = tempArray[j];
			++k;
			++j;
		}
		
		
		
	}

	public void showArray() 
	 {
		 for (int i =0; i<nums.length; ++i)
		 {
			 System.out.println(nums[i] + " ");
		 }
	 }
	 
	 private void swap (int i , int j)
	 {
		 int temp = nums[i];
		 nums[i] = nums[j];
		 nums[j] = temp;
	 }
}

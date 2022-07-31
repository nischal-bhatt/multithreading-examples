package multithreading;

public class MergeSortMain {

	public static void main(String[] args) {
	//	int[] nums = {5,-1,0,7,2,3,2,1,0,1,2};
		
		
		int[] nums = {8,8,2,4,7};
		
		
		MergeSort sort = new MergeSort(nums);
		sort.sort();
		sort.showArray();
	}
}

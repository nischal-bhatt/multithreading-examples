package multithreading;

import java.util.Arrays;

public class StreamsExample {

	public static void main(String[] args) {
		int[] nums = {1,5,3,-2,9,12};
		int sum = 0;
		for (int i =0; i<nums.length; i++)
		{
			sum= sum+ nums[i];
			
		}
		System.out.println(sum);
		
		
		Arrays.stream(nums).forEach(System.out::println);
	int a=	Arrays.stream(nums).sum();
		System.out.println(a);
	}
}

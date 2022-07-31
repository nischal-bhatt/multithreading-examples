package multithreading;

import java.util.stream.IntStream;

public class ParallelStreams {

	public static void main(String[] args) {
		
		long currenttime = System.currentTimeMillis();
		long numofprimes=IntStream.range(2, Integer.MAX_VALUE/100).filter(ParallelStreams::isPrime).count();
		System.out.println("num of primes seq= " + numofprimes);
		System.out.println("time taken = " + (System.currentTimeMillis() - currenttime));
		
		
		System.out.println("----------------------");
		
		
		currenttime = System.currentTimeMillis();
		 numofprimes=IntStream.range(2, Integer.MAX_VALUE/100).parallel().filter(ParallelStreams::isPrime).count();
		System.out.println("num of primes parallel= " + numofprimes);
		System.out.println("time taken = " + (System.currentTimeMillis() - currenttime));
	}
	
	public static boolean isPrime(long num)
	{
		if (num <= 1) return false;
		
		if (num == 2) return true;
		
		if (num%2 == 0) return false;
		
		long maxDivisor =  (long)Math.sqrt(num);
		
		for (int i =3; i<maxDivisor; i+=2)
		{
			if (num%i==0)
			{
				return false;
			}
			
			
		}
		
		return true;
	}
}

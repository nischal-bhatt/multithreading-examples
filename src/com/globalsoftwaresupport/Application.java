package com.globalsoftwaresupport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;

		Philosopher[] philosophers = null;

		Chopstick[] chopsticks = null;

		try {
			philosophers = new Philosopher[Constants.NUMPHILO];
			chopsticks = new Chopstick[Constants.NUMCHOPSTIX];
		
		    for(int i =0; i<Constants.NUMCHOPSTIX; ++i)
		    {
		    	chopsticks[i] = new Chopstick(i);
		    	
		    }
		    
		    executorService = Executors.newFixedThreadPool(Constants.NUMPHILO);
		
		    for (int i =0; i<Constants.NUMPHILO; ++i)
		    {
		    	philosophers[i] = new Philosopher(i,chopsticks[i],chopsticks[(i+1)%Constants.NUMCHOPSTIX]);
		        executorService.execute(philosophers[i]);
		    }
		    
		    Thread.sleep(Constants.SIMRUNTIME);
		    
		    
		    for (Philosopher p : philosophers)
		    {
		    	p.setFull(true);
		    }
		    
		} finally {
			executorService.shutdown();
			
			while (!executorService.isTerminated())
			{
				Thread.sleep(1000);
				
			}
			
			for (Philosopher p : philosophers)
			{
				System.out.println(p + " eat " + p.getEatingCounter() + " times!");
			}
		}
	}

}

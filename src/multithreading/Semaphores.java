package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3,true);
	
	public void download() 
	{
		try {
			semaphore.acquire();
			downloadData();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
	}

	private void downloadData() {
		try {
			System.out.println("downloading data from web...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

public class Semaphores {
    public static void main(String[] args) {
		//create multiple threads 
    	
    	ExecutorService svc = Executors.newCachedThreadPool();
	
        for (int i =0; i<12; i++)
        {
        	svc.execute(new Runnable() {

				@Override
				public void run() {
					Downloader.INSTANCE.download();
					
				}
        		
        	});
        }
    
    }
}

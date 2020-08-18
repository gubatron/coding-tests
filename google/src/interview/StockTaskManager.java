package interview;

import java.util.HashMap;

// ------------------
//  class StockTaskManager
//		main controlling class that can be extended to
//		operate with any number of sub-tasks.  default is 4,
//		but this could extend to any number.
// ------------------
public class StockTaskManager extends Thread {
	
	private StockTask[] tasks;
	private static int NUM_TASKS = 4;
	
	private HashMap<String, Integer> results = new HashMap<String, Integer>();
	
	public StockTaskManager( int numTrades, StockEngine engine ) {
		
		// allocate worker threads
		int numMainTaskThreads = NUM_TASKS;
		int numExtraTaskThreads = ( numTrades % NUM_TASKS != 0) ? 1 : 0;
		tasks = new StockTask[ numMainTaskThreads + numExtraTaskThreads ];
		
		// create 'normal' worker threads to handle numTrades / NUM_TASKS tasks
		for( int i=0; i < numMainTaskThreads; i++ ) {
			tasks[i] = new StockTask( numTrades / NUM_TASKS, engine);
		}
		
		// create last worker thread to handle any remaining tasks ( numTrades % NUM_TASKS tasks )
		if ( numExtraTaskThreads == 1 )
			tasks[ numMainTaskThreads ] = new StockTask( numTrades % NUM_TASKS, engine);
	}
	
	public HashMap<String, Integer> getResults() {
		return results;
	}

	public void run() {
		
		// start workers
		for( StockTask t : tasks ) {
			t.start();
		}
		
		// wait for results
		for( StockTask t : tasks ) {
			
			try {
				
				t.join();
				aggregateData( t );
				
			} catch (InterruptedException e) {
				// don't expect to be interupted, but just in case
				e.printStackTrace();
			}
		}
	}
	
	private void aggregateData ( StockTask t ) {
		
		HashMap< String, Integer> threadResults = t.getResults();
		
		for ( String symbol : threadResults.keySet()) {
			
			Integer myCount = results.get(symbol);
			myCount = myCount == null ? 0 : myCount;
			
			Integer threadCount = threadResults.get(symbol);
			
			results.put( symbol, myCount + threadCount );
		}
	}
}

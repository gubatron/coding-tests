package interview;

import java.util.HashMap;

// --------------
// class StockTask
//		main task class for operating a series
//		of requests against a StockEngine to get
//		a set of random results and making them available
//		after execution.
// --------------
public class StockTask extends Thread {

	private HashMap<String, Integer> results = new HashMap<String, Integer>();
	
	private int numStockTrades;
	private StockEngine engine;
	
	public StockTask( int numStockTrades, StockEngine engine ) {
		this.numStockTrades = numStockTrades;
		this.engine = engine;
	}
	
	public HashMap<String, Integer> getResults() {
		return results;
	}

	public void run() {
		
		do {
			
			String symbol = engine.generateRandomStock();
			
			Integer count = results.get(symbol);
			count = count == null ? new Integer(1) : count+1;
			
			results.put( symbol, count );
			
		} while (--numStockTrades > 0);
	}
}

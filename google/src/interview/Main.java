package interview;

import java.util.HashMap;

public class Main {

	// ---------------------------------
	//  main() - sample execution of the StockEngine
	//   does 3 things:
	//     1) generates a set of 2000 stocks
	//     2) initializes the StockEngine with those stocks
	//     3) simulate stock trading using the StockTaskManager
	// ----------------------------------
	public static void main( String[] args ) {
		
		// generate a collection of 10 stocks
		Stock[] stocks = StockFactory.generateStocks( 100 );
		
		// determine total volume
		int totalVolume = StockFactory.determineTotalVolume( stocks );
		
		// initialize the stock engine
		StockEngine engine = new StockEngine_Distributed();
		//engine = new StockEngine_Centralized();
		engine.Setup( stocks );
		
		// initialize and start the simulation thread
		StockTaskManager taskManager = new StockTaskManager(totalVolume, engine);
		taskManager.start();
		
		try {
			
			// wait until the taskManager finishes the task
			taskManager.join();			
			
			// display results
			displayStockData( stocks, taskManager.getResults() );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	//--------------------------------
	// displayStockData - formats the output of the stock data
	//   both the original and the test results
	//--------------------------------
	private static void displayStockData( Stock[] stocks, HashMap<String, Integer> results  ) {
		
		// determine original volume
		int originalVolume = StockFactory.determineTotalVolume( stocks );
		
		// determine total simulated volume
		int simulatedVolume = 0;
		
		for ( String symbol : results.keySet()) {
			simulatedVolume += results.get(symbol);
		}
		
		double totalOrigVolumePct = 0;
		double totalSimulatedVolumePct = 0;
		
		System.out.println(" symbol     trades        vol  simTrades     simVol");
		
		for ( Stock s : stocks ) {
			
			double pctVol = (float)s.getVolume() / (float)originalVolume;
			
			totalOrigVolumePct += pctVol;
			
			int simulatedTrades = results.get(s.getSymbol());
			double simulatedPctVol = (float)simulatedTrades / (float)simulatedVolume;
			
			totalSimulatedVolumePct += simulatedPctVol;
			
			System.out.format(" %6s %10d %10.8f %10d %10.8f\n", s.getSymbol(), s.getVolume(), pctVol, simulatedTrades, simulatedPctVol  );
		}
		
		System.out.format(" %6s %10d %10.8f %10d %10.8f\n", "total:", originalVolume, totalOrigVolumePct, simulatedVolume, totalSimulatedVolumePct );
	}
}

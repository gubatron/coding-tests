package interview;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;


// =========================
//  class StockEngine_Centralized
//		implements StockEngine interface.
//
//		major specialization is that this will keep track
//		of which stock trades have been performed and while
//		the ordering of the stocks will be random, the result
//		of an operation of the same number of stocks as the original
//		will be identical.
// =========================
public class StockEngine_Centralized implements StockEngine {

	private Stock[] origStocks = null;
	private Vector<Stock> stocks = null;
	private Random indexGenerator = null;
	
	public StockEngine_Centralized() {
	}
	

	@Override
	public void Setup( Stock[] stocks ) {
		
		// store stocks
		origStocks = stocks;
		
		
		// initialize random number generator 
		// (uses system time as seed by default)
		this.indexGenerator = new Random();
	}
	

	@Override
	public synchronized String generateRandomStock() {
		
		if ( null == origStocks ) {
			// Stock engine was not initialized
			return null;
		}
		
		if ( stocks == null || stocks.size() == 0 ) {
			// stocks have run out / not been set yet
			stocks = new Vector<Stock>( Arrays.asList( StockFactory.copyStocks( origStocks ) ) );
		}
		
		// return random stock symbol
		// --------------------------
		
		// nextInt() returns an int in the range of [0..stocks.length)
		int index = indexGenerator.nextInt( stocks.size() );
		
		// get a stock symbol O(1)
		Stock stock = stocks.elementAt(index);
		int volume = stock.getVolume() - 1;
		
		// if all of a certain stock are used up
		// remove the stock from the list which could be an O(n) operation
		if ( volume == 0 )
			stocks.removeElementAt( index );
		else
			stock.setVolume( volume );
		
		return stock.getSymbol();
	}
}

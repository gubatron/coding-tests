package interview;

import java.util.Random;


// ===========================
//  StockEngine_Distributed
//
//		implementation of a StockEngine.
//
//		this one is distributed and more random - it takes a copy
//      of the stock data, but does not guarantee it will generate
//      an exactly set of stock symbols identical to the original.
//      however, on average it will closely approximate the original source.
// ===========================
public class StockEngine_Distributed implements StockEngine {

	private Stock[] myStocks = null;
	private Random indexGenerator = null;
	private int totalTrades = 0;
	
	public StockEngine_Distributed() {
		
	}
	
	@Override
	public void Setup(Stock[] stocks) {
		
		// store stocks
		this.myStocks = StockFactory.copyStocks(stocks);
		
		// initialize random number generator 
		// (uses system time as seed by default)
		this.indexGenerator = new Random();

		// initialize total trades count
		this.totalTrades = StockFactory.determineTotalVolume(myStocks);
		
	}

	@Override
	public String generateRandomStock() {
		
		int tradeNum = indexGenerator.nextInt( totalTrades );
		int curTradeCount = 0;
		
		for ( Stock s : myStocks ) {
			
			int vol = s.getVolume();
			
			// see if the random guess is within this stock value
			if ( tradeNum >= curTradeCount && tradeNum < curTradeCount + vol ) {
				
				// it is!
				return s.getSymbol();
				
			}
			else
				curTradeCount += vol;
		}
		
		// should never get here
		assert(false);
		
		return null;
	}

	
}

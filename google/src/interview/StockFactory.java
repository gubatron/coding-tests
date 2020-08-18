package interview;


/*
 * class StockFactory
 * 
 * 		static method class providing functionality for 
 * 		generating stock objects and their appropriate symbols / volumes
 */
public class StockFactory {
	
	/*
	 * generateStocks( int count )
	 * 		returns an array of count Stocks that are
	 * 		each randomly generated.
	 */
	public static Stock[] generateStocks( int count ) {
		
		Stock[] stocks = new Stock[ count ];
		
		for ( int i=0; i < count; i++ ) {
			
			// random symbol generation
			char a = generateRandomLetter();
			char b = generateRandomLetter();
			char c = generateRandomLetter();
			char d = generateRandomLetter();
			String symbol = new StringBuilder().append(a).append(b).append(c).append(d).toString();
			
			// random volume generation
			int volume = generateRandomVolume();
			
			stocks[i] = new Stock(symbol, volume);
		}
		
		
		return stocks;
	}
	
	// "deep" copy an array of stocks
	public static Stock[] copyStocks( Stock[] stocks) {
		Stock[] newStocks = new Stock[ stocks.length ];
		
		for( int i=0; i < stocks.length; i++) {
			newStocks[i] = new Stock( stocks[i] );
		}
		
		return newStocks;
	}
	
	// determine total volume, by summing volume of all stocks
	public static int determineTotalVolume( Stock[] stocks ) {
		int totalVolume = 0;
		
		for ( Stock s : stocks ) {
			totalVolume += s.getVolume();
		}
		
		return totalVolume;
	}
	
	// generate a random letter in the range of 'A'..'Z'
	private static char generateRandomLetter() {
		return (char)( ( int )'A' + (int)(Math.random() * 26) );
	}
	
	// generate a random volume in the range of 0..999998
	private static int generateRandomVolume() {
		return (int) (Math.random() * 9999999);
	}
}

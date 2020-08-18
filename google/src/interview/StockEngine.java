package interview;

/*
 * interface StockEngine
 * 		the main engine for generating random stocks from a
 *		collection of stocks provided.
 *
 */
public interface StockEngine {

	/*
	 * void Setup( Stock[] stocks )
	 * 
	 * 		initializes the StockEngine with a set of stocks.
	 * 		also initializes the random number generator.  by default
	 * 		Java.util.Random uses the current system time to seed the
	 * 		random number generator.
	 */
	public void Setup( Stock[] stocks );
	
	/*
	 * String GenerateRandomStock()
	 * 		returns a random stock from the set of stocks provided
	 * 		in the setup() function. returns null if the stocks have
	 * 		not been intialized.
	 */
	public String generateRandomStock();
}

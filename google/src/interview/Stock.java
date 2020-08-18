package interview;

/*
 * class Stock
 * 		simple stock class for exposing
 * 		stock symbol and it's associated volume.
 */
public class Stock {

	
	private String symbol;
	private int volume;

	public Stock( String symbol, int volume ) {
		this.symbol = symbol;
		this.volume = volume;
	}
	
	public Stock( Stock s ) {
		this.symbol = s.symbol;
		this.volume = s.volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getVolume() {
		return volume;
	}
}

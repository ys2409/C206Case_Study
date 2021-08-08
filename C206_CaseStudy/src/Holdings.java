
public class Holdings {
	
	private double holdings;
	private String currencyISO;
	
	public Holdings(double holdings, String currencyISO) {
		this.holdings = holdings;
		this.currencyISO = currencyISO;
	}
	public String getCurrencyISO() {
		return currencyISO;
	}
	public double getHoldings() {
		return holdings;
	}

}

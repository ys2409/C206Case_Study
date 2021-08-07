public class Currency {
	
	private String currencyISO;
	private String currencyName;
	private double holdings;
	private double buyRate;
	private double sellRate;
	
	public Currency(String currencyISO, double holdings, String currencyName, double buyRate, double sellRate) {
		this.currencyISO = currencyISO;
		this.currencyName = currencyName;
		this.holdings = holdings;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}

	public String getCurrencyISO() {
		return currencyISO;
	}
	public double getHoldings() {
		return holdings;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public double getBuyRate() {
		return buyRate;
	}

	public double getSellRate() {
		return sellRate;
	}
}
	
	
	


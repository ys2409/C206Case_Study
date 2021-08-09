
public class transaction {
		private double amount;
		private double received;
		private String currency;
		private String converted;
		private String date;
		public transaction(String date, String currency, double amount,String converted, double received) {
			this.date = date;
			this.currency = currency;
			this.amount = amount;
			this.received = received;
			this.converted = converted;
		}
		public String getDate() {
			return date;
		}
		public String getCurrency() {
			return currency;
		}
		public double getAmount() {
			return amount;
		}
		public String getConverted() {
			return converted;
		}
		public double getReceived() {
			return received;
		}

}

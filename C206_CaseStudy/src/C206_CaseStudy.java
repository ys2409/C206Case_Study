import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Currency> currencyList = new ArrayList<Currency>();

		currencyList.add(new Currency("SGD", 100000.00, "Singapore", 2.8, 3.4));
		currencyList.add(new Currency("EUR", 100000.00, "Europe", 3.0, 3.5));

		int option = 0;
		C206_CaseStudy.menu();
		option = Helper.readInt("Enter an option > ");
		while (option != 6) {

			

			if (option == 1) {
				// View all items
				C206_CaseStudy.setHeader("VIEW");
				viewTypeMenu();

				int viewType = Helper.readInt("Enter option to select item type > ");

				if(viewType == 1) {
					for (int i = 0; i < currencyList.size(); i++) {
						String iso = currencyList.get(i).getCurrencyISO();	
						double holding = currencyList.get(i).getHoldings();
						System.out.println("Our company currently holds "+ holding + " "+iso);
					}

					
				} else if (viewType == 2) {

					
				} else if (viewType == 3) {
					C206_CaseStudy.setHeader("VIEW COMPANY AMOUNT IN CURRENCIES");

					//Assuming original company money is in sgd currency
					double EURcompanyMoney = 100000.00;
					for (int i = 0; i < currencyList.size(); i++) {
						if (currencyList.get(i).getCurrencyISO() == "EUR") {
							System.out.println("Original Currency: " + currencyList.get(i).getCurrencyName());
							System.out.println(
									currencyList.get(i).getCurrencyISO() + " " + String.format("%.2f", EURcompanyMoney));
						} else {
							double convertedAmt = EURcompanyMoney * currencyList.get(i).getSellRate();
							System.out.println("Currency: " + currencyList.get(i).getCurrencyName());
							System.out.println(
									currencyList.get(i).getCurrencyISO() + " " + String.format("%.2f", convertedAmt));
						}
						System.out.println(" ");
					}
				} else {
					System.out.println("Invalid");
				}
			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");
				itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a currency
					Currency c = inputCurrency();
					C206_CaseStudy.addCurrency(currencyList, c);

				} else if (itemType == 2) {
					// Add holdings

				} else if (itemType == 3) {
					// Add walk in exchange transaction

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Loan item
				C206_CaseStudy.setHeader("DELETE");
			}

			else if (option == 4) {
				C206_CaseStudy.setHeader("SEARCH");				

			} else {
				System.out.println("Bye!");
			}

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
		}
		

	}

	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println("1. View list of currencies");
		System.out.println("2. Add new currencies");
		System.out.println("3. Delete currency");
		System.out.println("4. Search for holding of currency");
		System.out.println("5. Edit holdings");
		 
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}

	private static void itemTypeMenu() {
		System.out.println("1. Add Currency");
		System.out.println("2. Add Holdings");
		System.out.println("3. Add walk in exchange transactions \n");
	}
	
	private static void viewTypeMenu() {
		System.out.println("1. View all holdings");
		System.out.println("2. View Currency");
		System.out.println("3. View Company Amount \n");
		
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	// ================================= Option 1 View
	// =================================

	// ================================= Option 2 View
	// =================================
	public static Currency inputCurrency() {
		String currencyISO = Helper.readString("Enter currency ISO > ");
		String currencyName = Helper.readString("Enter currency name  > ");
		double currentHoldings = Helper.readDouble("Enter current holdings > ");
		double buyRate = Helper.readDouble("Enter buy rate > ");
		double sellRate = Helper.readDouble("Enter sell rate >");

		Currency c = new Currency(currencyISO, currentHoldings, currencyName, buyRate, sellRate);
		return c;

	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency c) {

		currencyList.add(c);
		System.out.println("Currency added!");
	}

	// ================================= Option 3 Delete
	// =================================

	// ================================= Option 4 Search
	// =================================

}

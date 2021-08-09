import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Currency> currencyList = new ArrayList<Currency>();

		currencyList.add(new Currency("SGD", "Singapore", 2.8, 3.4));
		currencyList.add(new Currency("EUR", "Europe", 3.0, 3.5));

		int option = 0;

		while (option != 5) {
			
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

				C206_CaseStudy.setHeader("View");
				itemTypeMenu1();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// View currency -faz

				} else if (itemType == 2) {
					// View holdings -royce

				} else if (itemType == 3) {
					// View company money -ys

				} else {
					System.out.println("Invalid type");
				}

				
			} else if (option == 2) {
				// Add a new item 
				C206_CaseStudy.setHeader("ADD");
				itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add currency -faz
					Currency c = inputCurrency();
					C206_CaseStudy.addCurrency(currencyList, c);

				} else if (itemType == 2) {
					// Add holdings -royce

				} else if (itemType == 3) {
					// Add walk in exchange transaction - izwan

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE");
				itemTypeMenu2();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// delete currency - faz

				} else if (itemType == 2) {
					// delete holdings - royce

				} else {
					System.out.println("Invalid type");
				}
			}else if (option == 4) {
				C206_CaseStudy.setHeader("SEARCH");
				itemTypeMenu3();
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Search for holding - ys

				} else if (itemType == 2) {
					// Search currency rates - dom

				} else {
					System.out.println("Invalid type");
				}
			} else {
				System.out.println("BYE!");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println("1. View All");
		System.out.println("2. Add All");
		System.out.println("3. Delete All ");
		System.out.println("4. Search All");
		System.out.println("5. Quit");

	}

	private static void itemTypeMenu() {
		System.out.println("1. Add Currency");
		System.out.println("2. Add Holdings");
		System.out.println("3. Add walk in exchange transactions \n");
	}


	private static void itemTypeMenu1() {
		System.out.println("1. View Currency");
		System.out.println("2. View Holdings");
		System.out.println("3. View company money");
	}

	private static void itemTypeMenu2() {
		System.out.println("1. Delete Currency");
		System.out.println("2. Delete Holdings");
	}

	private static void itemTypeMenu3() {
		System.out.println("1. Search for holdings");
		System.out.println("2. Search for currency rate");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	// ================================= Option 1 View
	// =================================

	// View currency - faz

	// View holdings - royce

	// View company money - ys
	// Assuming original company money is in sgd currency
//	double EURcompanyMoney = 100000.00;
//	for(int i = 0;i<currencyList.size();i++)
//	{
//		if (currencyList.get(i).getCurrencyISO() == "EUR") {
//			System.out.println("Original Currency: " + currencyList.get(i).getCurrencyName());
//			System.out.println(currencyList.get(i).getCurrencyISO() + " " + String.format("%.2f", EURcompanyMoney));
//		} else {
//			double convertedAmt = EURcompanyMoney * currencyList.get(i).getSellRate();
//			System.out.println("Currency: " + currencyList.get(i).getCurrencyName());
//			System.out.println(currencyList.get(i).getCurrencyISO() + " " + String.format("%.2f", convertedAmt));
//		}
//		System.out.println(" ");
//	}

	// ================================= Option 2 View
	// =================================

	// add currency - faz
	public static Currency inputCurrency() {
		String currencyISO = Helper.readString("Enter currency ISO > ");
		String currencyName = Helper.readString("Enter currency name  > ");
		double buyRate = Helper.readDouble("Enter buy rate > ");
		double sellRate = Helper.readDouble("Enter sell rate >");

		Currency c = new Currency(currencyISO,  currencyName, buyRate, sellRate);
		return c;

	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency c) {

		currencyList.add(c);
		System.out.println("Currency added!");
	}

	// add holdings - royce

	// add walk in exchange transaction - izwan

	// ================================= Option 3 Delete
	// =================================

	// delete currency - faz

	// delete holdings - faz

	// ================================= Option 4 Search
	// =================================

	// search holdings -ys

	// search currecncy rate - dom

}

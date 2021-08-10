import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		ArrayList<Holdings> holdingList = new ArrayList<Holdings>();
		ArrayList<transaction> transactionList = new ArrayList<transaction>();

		holdingList.add(new Holdings(100000.00, "SGD"));
		holdingList.add(new Holdings(100000.00, "EUR"));
		holdingList.add(new Holdings(100000.00, "MYR"));
		currencyList.add(new Currency("SGD", "Singapore", 2.8, 3.4));
		currencyList.add(new Currency("EUR", "Europe", 3.0, 3.5));
		currencyList.add(new Currency("MYR", "Malaysia", 2.0, 3.8));

		int option = 0;

		while (option != 6) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

				C206_CaseStudy.setHeader("View");
				itemTypeMenu1();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// View currency -faz
					C206_CaseStudy.viewAllCurrency(currencyList);

				} else if (itemType == 2) {
					// View holdings -royce
					Helper.line(80, "-");
					System.out.println("HOLDINGS HELD BY COMPANY");
					Helper.line(80, "-");
					for (int i = 0; i < holdingList.size(); i++) {
						
						System.out.println("We currently hold:" + holdingList.get(i).getHoldings()
								+ holdingList.get(i).getCurrencyISO());
					}

				} else if (itemType == 3) {
					for (int i = 0; i < holdingList.size(); i++) {
						if (holdingList.get(i).getCurrencyISO().equalsIgnoreCase("SGD")) {
							System.out.println("SGD  SGD" + holdingList.get(i).getHoldings());
						} else {

							double convertToSGD = holdingList.get(i).getHoldings() * 3.4;

							System.out.println(holdingList.get(i).getCurrencyISO() + "  SGD" + convertToSGD);

						}

					}

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
					addHoldings(holdingList);
				}
			} else if (option == 3) {
				C206_CaseStudy.setHeader("DELETE");
				itemTypeMenu2();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// delete currency - faz

					C206_CaseStudy.deleteCurrency(currencyList);

				} else if (itemType == 2) {
					// delete holdings - royce

				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 4) {
				C206_CaseStudy.setHeader("SEARCH");
				itemTypeMenu3();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Search for holding - ys
					String currIso = Helper.readString("Enter Currency ISO to Search > \n");
					for (int x = 0; x < holdingList.size(); x++) {
						if (holdingList.get(x).getCurrencyISO().equalsIgnoreCase(currIso)) {
							if (holdingList.get(x).getCurrencyISO().equalsIgnoreCase("SGD")) {
								System.out.println("SGD" + holdingList.get(x).getHoldings());
							} else {
								System.out.println(
										holdingList.get(x).getCurrencyISO() + holdingList.get(x).getHoldings());

								double convertToSGD = holdingList.get(x).getHoldings() * 3.4;

								System.out.println("SGD" + convertToSGD);

							}
						}
					}

				} else if (itemType == 2) {
					// Search currency rates - dom

				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 5) {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
				String date = LocalDateTime.now().format(format);
				itemTypeMenu4();
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					double amount = Helper.readDouble("Enter amount > ");
					String ConverTo = Helper.readString("Enter convert to currency ISO > ");
					double rate = findSellRate(ConverTo, currencyList);
					double convertedAmt = checkCurrencySell(amount, rate);
					converter(amount, ConverTo, convertedAmt,transactionList);
					transactionList.add(new transaction(date,"SGD",amount,ConverTo,convertedAmt));
				} else if (itemType == 2) {
					double amount = Helper.readDouble("Enter amount > ");
					String currency = Helper.readString("Enter currency ISO > ");
					double rate = findBuyRate(currency, currencyList);
					double convertedAmt = checkCurrencyBuy(amount, rate);
					converter2(currency, amount, convertedAmt,transactionList);
					transactionList.add(new transaction(date,currency,amount,"SGD",convertedAmt));
				}else if(itemType==3) {
					String output = String.format("%-26s%-10s%-8s   %-12s%-10s\n","Date","Currency","Amount","Currency","Amount(Customer receive)");
					for(int x = 0;x<transactionList.size();x++) {
						output += String.format("%-26s%-10s%-8.2f=  %-12s%-10.2f\n", transactionList.get(x).getDate(),transactionList.get(x).getCurrency(),
								transactionList.get(x).getAmount(), transactionList.get(x).getConverted(),transactionList.get(x).getReceived());
					}System.out.println(output);
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
		System.out.println("5. Add Walk in transactions");
		System.out.println("6. Quit");

	}

	private static void itemTypeMenu() {
		System.out.println("1. Add Currency");
		System.out.println("2. Add Holdings");
	}

	private static void itemTypeMenu1() {
		System.out.println("1. View Currency");
		System.out.println("2. View Holdings");
		System.out.println("3. All currencies in SGD value");
	}

	private static void itemTypeMenu2() {
		System.out.println("1. Delete Currency");
		System.out.println("2. Delete Holdings");
	}

	private static void itemTypeMenu3() {
		System.out.println("1. Search for holdings");
		System.out.println("2. Search for currency rate");
	}

	private static void itemTypeMenu4() {
		System.out.println("1. SELL");
		System.out.println("2. BUY");
		System.out.println("3. View Transaction List");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	// ================================= Option 1 View
	// =================================

	// View currency - faz

	public static String retrieveAllCurrency(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {

			output += String.format("%-15s %-20s %-15.2f %-20.2f\n", currencyList.get(i).getCurrencyISO(),
					currencyList.get(i).getCurrencyName(), currencyList.get(i).getBuyRate(),
					currencyList.get(i).getSellRate());
		}
		return output;
	}

	public static void viewAllCurrency(ArrayList<Currency> currencyList) {
		C206_CaseStudy.setHeader("CURRENCY LIST");
		String output = String.format("%-15s %-20s %-15s %-20s\n", "CURRENCY ISO", "CURRENCY NAME", "BUY RATE",
				"SELL RATE");
		output += retrieveAllCurrency(currencyList);
		System.out.println(output);
	}

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

		Currency c = new Currency(currencyISO, currencyName, buyRate, sellRate);
		return c;

	}

	public static void addCurrency(ArrayList<Currency> currencyList, Currency c) {

		currencyList.add(c);
		System.out.println("Currency added!");
	}

	// add holdings - royce

	// add walk in exchange transaction - izwan
	//SELL currency
	private static void converter(double amount, String ConverTo, double convertedAmt,ArrayList<transaction> transactionList) {
		String output = String.format("%-26s%-10s%-8s   %-12s%-10s\n","Date","Currency","Amount","Currency","Amount(Customer receive)");;
		String currency = "SGD";
		if (convertedAmt == 0) {
			System.out.println("Invalid currency entered!");
		} else {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
			String date = LocalDateTime.now().format(format);
			output += String.format("%-26s%-10s%-8.2f=  %-12s%-10.2f\n", date, currency, amount, ConverTo,
					convertedAmt);
			System.out.println(output);
		}for(int x = 1;x<transactionList.size();x++) {
			System.out.println(transactionList.get(x).getAmount());
		}
	}

	private static void converter2(String currency, double amount, double convertedAmt, ArrayList<transaction> transactionList) {
		// BUY currency
		String output = String.format("%-26s%-10s%-8s   %-12s%-10s\n","Date","Currency","Amount","Currency","Amount(Customer receive)");
		String ConverTo = "SGD";
		if (convertedAmt == 0) {
			System.out.println("Invalid currency entered!");
		} else {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
			String date = LocalDateTime.now().format(format);
			output += String.format("%-26s%-10s%-8.2f=  %-12s%-10.2f\n", date, currency, amount, ConverTo,
					convertedAmt);
			System.out.println(output);
		}
	}
	private static double checkCurrencySell(double amount, double rate) {
		double conversion = 0;
		conversion = amount * rate;
		return conversion;
	}

	private static double checkCurrencyBuy(double amount, double rate) {
		double conversion = 0;
		conversion = amount * rate;
		return conversion;
	}

	public static double findBuyRate(String currency, ArrayList<Currency> currencyList) {
		double Buyrate = 0;
		double SGDRate = 2.8;
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyISO().equals(currency)) {
				Buyrate = currencyList.get(i).getBuyRate() / SGDRate;
			}
		}
		return Buyrate;
	}

	public static double findSellRate(String currency, ArrayList<Currency> currencyList) {
		double Sellrate = 0;
		double SGDRate = 3.4;
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getCurrencyISO().equals(currency)) {
				Sellrate = currencyList.get(i).getBuyRate() / SGDRate;
			}
		}
		return Sellrate;
	}

	// ================================= Option 3 Delete
	// =================================

	// delete currency - faz

	public static void deleteCurrency(ArrayList<Currency> currencyList) {
		String ISO = Helper.readString("Enter currency ISO > ");

		for (int x = 0; x < currencyList.size(); x++) {
			if (currencyList.get(x).getCurrencyISO().equalsIgnoreCase(ISO)) {
				currencyList.remove(x);
				System.out.println("Currency is removed!");
			} 
			
		}
	}
	public static void addHoldings(ArrayList<Holdings> holdingList) {
		String addISO = Helper.readString("Enter ISO > ");
		double addOption = Helper.readDouble("How much do you want to add > ");

		for (int i = 0; i < holdingList.size(); i++) {
			if (addISO .equals(holdingList.get(i).getCurrencyISO())) {
				double x  = holdingList.get(i).getHoldings() + addOption;
				holdingList.get(i).setHoldings(x);
				
				System.out.println(
						"We now hold:  " + x + " " + holdingList.get(i).getCurrencyISO());
			}
		}

	} 


	// delete holdings - royce

	// ================================= Option 4 Search
	// =================================

	// search holdings -ys

	// search currecncy rate - dom

}

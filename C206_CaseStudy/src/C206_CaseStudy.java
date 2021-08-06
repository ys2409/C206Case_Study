
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		while (option != 6) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a currency
				} else if (itemType == 2) {
					// Add holdings

				}else if (itemType == 3) {
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

			} else if (option == 5) {
			} else if (option == 6) {
			}
			System.out.println("Bye!");
		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE MANAGEMENT SYSTEM");
		System.out.println("1. View list of currencies");
		System.out.println("2. Add new currencies");
		System.out.println("3.Delete currency");
		System.out.println("4. Search for holding of currency");
		System.out.println("5. Add walk-in exchange transaction");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//================================= Option 1 View =================================
	
	//================================= Option 2 View =================================
	
	//================================= Option 1 Delete =================================
	
	//================================= Option 4 Search =================================
	
}

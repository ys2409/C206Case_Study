import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency c1;
	private Currency c2;
	private Holdings h1;
	private transaction t1;
	private transaction t2;
	

	private ArrayList<Currency> currencyList;
	private ArrayList<Holdings> holdingList;
	private ArrayList<transaction> transactionList;
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
	String date = LocalDateTime.now().format(format);


	public C206_CaseStudyTest() {
		super();
	}
	

	@Before
	public void setUp() throws Exception {
		c1 = new Currency("SGD", "Singapore", 2.8, 3.4);
		c2 = new Currency("EUR", "Europe", 3.0, 3.5);
		h1 = new Holdings(10000.0,"EUR");
		t1 = new transaction(date,"SGD",200.00,"EUR",176.47);
		t2 = new transaction(date,"MYR",130.00,"SGD",92.86);
		
		currencyList = new ArrayList<Currency>();
		holdingList = new ArrayList<Holdings>();
		transactionList = new ArrayList<transaction>();
	}
	//fazlina
	@Test
	public void testAddCurrency() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Currency arraylist to add to", currencyList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCurrency(currencyList, c1);
		assertEquals("Test if that Currency arraylist size is 1?", 1, currencyList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Currency is added same as 1st item of the list?", c1, currencyList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Test that Currency arraylist size is 2?", 2, currencyList.size());
	}
	//fazlina
	@Test
	public void testRetrieveAllCurrency() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Currency arraylist to add to", currencyList);

		// test if the list of currency retrieved from the SourceCentre is empty
		String allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);
		String testOutput = "";
		assertEquals("Check that ViewAllCurrencylist", testOutput, allCurrency);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCurrency(currencyList, c1);
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertEquals("Test if that Currency arraylist size is 2?", 2, currencyList.size());

		// test if the expected output string same as the list of currency retrieved
		// from the SourceCentre
		allCurrency = C206_CaseStudy.retrieveAllCurrency(currencyList);

		testOutput = String.format("%-15s %-20s %-15.2f %-20.2f\n", "SGD", "Singapore", 2.8, 3.4);
		testOutput += String.format("%-15s %-20s %-15.2f %-20.2f\n", "EUR", "Europe", 3.0, 3.5);

		assertEquals("Check that ViewAllCurrencylist", testOutput, allCurrency);

	}
	
	//fazlina
	@Test
	public void testDeleteCurrency() {
		
	}
	
	
	//royce
	@Test
	public void testAddHoldings() {
		assertNotNull("Test if there is an arraylist for holding list", holdingList);
		
		holdingList.add(h1);
		assertSame("Test if holdingList size is 1",holdingList.size(),1);
		
		C206_CaseStudy.addHoldings(holdingList, "EUR",200.0);
		double x = C206_CaseStudy.holdingAmt(holdingList, "EUR");
		System.out.println(x);
		assertEquals(x,10200.0,holdingList.get(0).getHoldings());
	}
	@Test
	  public void testRedHoldings() {
	    assertNotNull("Test if there is an arraylist for holding list", holdingList);
	    
	    holdingList.add(h1);
	    assertSame("Test if holdingList size is 1",holdingList.size(),1);
	    
	    C206_CaseStudy.redHoldings(holdingList, 200.0,"EUR");
	    double x = C206_CaseStudy.holdingAmt(holdingList, "EUR");
	    System.out.println(x);
	    assertEquals(x,9800.0,holdingList.get(0).getHoldings());  
	  }
	//izwan
	@Test
	public void TestBuyTransaction() {
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertSame("Test that currencyList size is 1",currencyList.size(),1);
		
		double value = C206_CaseStudy.findBuyRate("EUR", currencyList);
		double rate = 3.5/3.4;
		assertEquals("Test if rate is the same as expected",value,rate,1.0294);
		
		double total = C206_CaseStudy.checkCurrencyBuy(200, value);
		double expected = 200 * rate;
		assertEquals("Test if amount results in expected value",total,expected,205.8823);
	}
	//izwan
	@Test
	public void TestSellTransaction() {
		C206_CaseStudy.addCurrency(currencyList, c2);
		assertSame("Test that currencyList size is 1",currencyList.size(),1);
		
		double value = C206_CaseStudy.findSellRate("EUR", currencyList);
		double rate = 2.8/3.0;
		assertEquals("Test if rate is the same as expected",value,rate,0.9333);
		
		double total = C206_CaseStudy.checkCurrencySell(200, value);
		double expected = 200 * rate;
		assertEquals("Test if amount results in expected value",total,expected,186.66666);
	}
	//izwan
	@Test
	public void TestTransaction() {
		assertNotNull("Test if transaction arrayList exists",transactionList);
		
		transactionList.add(t1);
		transactionList.add(t2);
		assertSame("Test that transactionList size is 2",transactionList.size(),2);
		
		String output = String.format("%-26s%-10s%-8s   %-12s%-10s\n","Date","Currency","Amount","Currency","Amount(Customer receive)");
		for(int x = 0;x<transactionList.size();x++) {
			output += String.format("%-26s%-10s%-8.2f=  %-12s%-10.2f\n", transactionList.get(x).getDate(),transactionList.get(x).getCurrency(),
					transactionList.get(x).getAmount(), transactionList.get(x).getConverted(),transactionList.get(x).getReceived());
		}
		String result = C206_CaseStudy.displayTransaction(transactionList);
		assertEquals("Test if output and the result is the same",output,result);
	}

	@After
	public void tearDown() throws Exception {
	}

}

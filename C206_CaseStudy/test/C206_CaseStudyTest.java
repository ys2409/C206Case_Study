import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency c1;
	private Currency c2;
	private Holdings h1;
	

	private ArrayList<Currency> currencyList;
	private ArrayList<Holdings> holdingList;


	public C206_CaseStudyTest() {
		super();
	}
	

	@Before
	public void setUp() throws Exception {
		c1 = new Currency("SGD", "Singapore", 2.8, 3.4);
		c2 = new Currency("EUR", "Europe", 3.0, 3.5);
		h1 = new Holdings(10000.0,"EUR");
		
		currencyList = new ArrayList<Currency>();
		holdingList = new ArrayList<Holdings>();
	}

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

	@After
	public void tearDown() throws Exception {
	}

}

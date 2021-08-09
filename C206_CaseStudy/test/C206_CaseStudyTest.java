import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency c1;
	private Currency c2;
	

	private ArrayList<Currency> currencyList;


	public C206_CaseStudyTest() {
		super();
	}
	

	@Before
	public void setUp() throws Exception {
		c1 = new Currency("SGD", "Singapore", 2.8, 3.4);
		c2 = new Currency("EUR", "Europe", 3.0, 3.5);
		
		currencyList = new ArrayList<Currency>();
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
	
	
	
	@After
	public void tearDown() throws Exception {
	}

}

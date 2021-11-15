import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void testSearch() {
		assertNotNull(new Linear());
	}
	
	@Test
	void testFindPosition() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(1, searcher.findPosition(central.getBankList(), 100));
	}
	
	@Test
	void testFindArrayListOfISortableInt() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals("java", searcher.find(central.getBankList(), 300).getName());
	}
	
	@Test
	void testFindArrayListOfISortableString() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(100, searcher.find(central.getBankList(), "unit").getId());
	}
	
	@Test
	void testFindGeneral() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(2, searcher.findGeneral(central.getBankList(), "java", 300, SearchBy.ID));
	}
	
	@Test
	void testFindGeneralIfDoesntExist() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		try {
			central.createBank("test", 200);
			central.createBank("unit", 100);
			assertEquals(2, searcher.findGeneral(central.getBankList(), "java", 300, SearchBy.ID));
		} catch (Exception e) {
		    fail("There is no bank to look for");
		}
	}
	
	@Test
	void testGetTypeSearch() throws Exception {
		Search searcher = new Linear();
		assertEquals(false, searcher.getTypeSearch(SearchBy.NAME));
	}
	
	@Test
	void testGetTypeComparator() throws Exception {
		Search searcher = new Linear();
		assertEquals(true, searcher.getTypeComparator(Comparator.EQUAL_TO));
	}

	@Test
	void testIsEqual() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(true, searcher.isEqual(central.getBankList(), SearchBy.NAME, 1, "unit", 100));
	}
	
	@Test
	void testIsGreaterThan() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(false, searcher.isGreaterThan(central.getBankList(), SearchBy.ID, 1, "unit", 100));
	}
	
	@Test
	void testGetTime() throws Exception {
		Search searcher = new Linear();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertNotNull(searcher.getTime(central.getBankList()));
	}
}

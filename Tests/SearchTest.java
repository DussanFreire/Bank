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

}

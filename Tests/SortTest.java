import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortTest {

	@Test
	void testSort() {
		assertNotNull(new Bubble());
	}

	@Test
	void testGetSorted() throws Exception {
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		Sort sorter = new Bubble();
		assertEquals(100, ((ISortable) sorter.getSorted(central.getBankList(), OrderBy.ID).get(0)).getId());
	}

	@Test
	void testGetTypeOrder() throws Exception {
		Sort sorter = new Bubble();
		assertEquals(true, sorter.getTypeOrder(OrderBy.ID));
	}

	@Test
	void testGetTime() throws Exception {
		Sort sorter = new Bubble();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertNotNull(sorter.getTime(central.getBankList()));
	}

	@Test
	void testGetMemory() throws Exception {
		Sort sorter = new Bubble();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertNotNull(sorter.getMemory(central.getBankList()));
	}

	@Test
	void testGreaterThan() throws Exception {
		Sort sorter = new Bubble();
		CentralBank central = new CentralBank();
		central.createBank("test", 200);
		central.createBank("unit", 100);
		central.createBank("java", 300);
		assertEquals(true, sorter.greaterThan(central.getBankList(), 0, OrderBy.ID));
	}

}

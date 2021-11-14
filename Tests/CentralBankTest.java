import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CentralBankTest {

	@Test
	void testCentralBank() {
		assertNotNull(new CentralBank());
	}

	@Test
	void testCreateBank() {
		CentralBank central = new CentralBank();
		central.createBank("test", 100);
		central.createBank("unit", 200);
		assertEquals(100, central.getBankList().get(0).getId());
	}

	@Test
	void testGetBankList() {
		CentralBank central = new CentralBank();
		central.createBank("test", 100);
		central.createBank("unit", 200);
		assertEquals(2, central.getBankList().size());
	}

}

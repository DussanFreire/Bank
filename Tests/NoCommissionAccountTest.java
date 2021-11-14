import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoCommissionAccountTest {

	@Test
	void testGetMonthlyReport() {
		Account account = new HousingAccount(1,1);
		account.enterMoney(100);
		assertEquals(122, account.getMonthlyReport(), 0.01);
	}

	@Test
	void testNoCommissionAccount() {
		assertNotNull(new HousingAccount(100,100));
	}

}

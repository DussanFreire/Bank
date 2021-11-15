import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommissionAccountTest {

	@Test
	void testCommissionAccount() {
		assertNotNull(new CurrentAccount(100,100));
	}

	@Test
	void testGetMonthlyReport() {
		Account account = new CurrentAccount(1,1);
		account.enterMoney(100);
		assertEquals(109.9, account.getMonthlyReport(), 0.01);
	}
}

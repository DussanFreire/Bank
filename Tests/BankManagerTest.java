import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankManagerTest {

	@Test
	void testBankManager() {
		assertNotNull(new BankManager());
	}

	@Test
	void testCreateCustomer() {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		assertEquals(1, manager.getCustomerList().size(), 0.01);
	}

	@Test
	void testCreateAccount() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createAccount(new CurrentAccount(1,1));
		assertEquals(1, manager.getAccountList().size(), 0.01);
	}

	@Test
	void testGetAccount() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		Account account = new CurrentAccount(1,1);
		manager.createAccount(account);
		assertEquals(account, manager.getAccount(1));
	}

	@Test
	void testUpdateAccount() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createAccount(new CurrentAccount(1,1));
		manager.updateAccount(new InvestmentFund(1,1));
		assertEquals(AccountType.INVEST, manager.getAccount(1).getType());
	}

	@Test
	void testGetCustomer() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		assertEquals(1, manager.getCustomer(1).getId());
	}

	@Test
	void testUpdateCustomer() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		Customer customer = new Customer(1, "Sergio", "M", "S", 7);
		manager.updateCustomer(customer);
		assertEquals("Sergio", manager.getCustomer(1).getName());
	}

	@Test
	void testDeleteAccountCustomer() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createCustomer(2, "S", "A", "B", 6);
		manager.createAccount(new CurrentAccount(1,1));
		manager.deleteAccountCustomer(1, 2);
		assertEquals(0, manager.getCustomer(1).accountsNumbers.size());
	}
	
	@Test
	void testDeleteAccountCustomerWithoutCustomer() throws Exception {
		BankManager manager = new BankManager();
		try {
			manager.createCustomer(2, "S", "A", "B", 6);
			manager.createAccount(new CurrentAccount(1,1));
			fail("This most throw an error");
			manager.deleteAccountCustomer(1, 2);
		} catch (Exception e) {
			final String expected =  "The element does not exist in the list";
			assertEquals(expected, e.getMessage());
		}
	}

	@Test
	void testAddAccountCustomer() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createCustomer(2, "S", "A", "B", 6);
		manager.createAccount(new CurrentAccount(1,1));
		manager.addAccountCustomer(1, 2);
		assertEquals(1, manager.getCustomer(2).accountsNumbers.size());
	}
	

	@Test
	void testChangeClientAccount() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createCustomer(2, "S", "A", "B", 6);
		manager.createAccount(new CurrentAccount(1,1));
		manager.changeClientAccount(1, 2);
		assertEquals(1, manager.getCustomer(2).accountsNumbers.size());
	}
	
	@Test
	void testChangeClientAccountWithoutCustomer() throws Exception {
		BankManager manager = new BankManager();
		try {
			manager.createCustomer(1, "V", "M", "S", 7);
			manager.createAccount(new CurrentAccount(1,1));
			manager.changeClientAccount(1, 2);
			fail("This most throw an error");
		} catch (Exception e) {
			final String expected =  "The element does not exist in the list";
			assertEquals(expected, e.getMessage());
		}
		
	}

	@Test
	void testGetCustomerAccountName() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createAccount(new CurrentAccount(1,1));
		assertEquals("V", manager.getCustomerAccountName(1));
	}

	@Test
	void testGetCustomerList() {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createCustomer(2, "S", "A", "B", 6);
		assertEquals(2, manager.getCustomerList().size());
	}

	@Test
	void testGetAccountList() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createAccount(new CurrentAccount(1,1));
		assertEquals(1, manager.getAccountList().size());
	}

	@Test
	void testGetMonthlyReportList() throws Exception {
		BankManager manager = new BankManager();
		manager.createCustomer(1, "V", "M", "S", 7);
		manager.createAccount(new CurrentAccount(1,1));
		manager.createAccount(new CurrentAccount(2,1));
		manager.createAccount(new CurrentAccount(3,1));
		assertEquals(3, manager.getMonthlyReportList().size());
	}

}

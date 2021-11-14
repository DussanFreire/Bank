import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testAccount() {
		assertNotNull(new HousingAccount(1,1));
	}

	@Test
	public void testEnterMoney() {
		Account account = new CurrentAccount(1,1);
		account.enterMoney(100);
		double result = account.checkBalance();
		assertEquals(100, result, 0.01);
	}

	@Test
	public void testUpdatePoints() {
		Account account = new InvestmentFund(1,1);
		account.enterMoney(100);
		assertEquals(10,account.getPoints());
	}

	@Test
	public void testCheckBalance() {
		Account account = new HousingAccount(1,1);
		account.enterMoney(500);
		assertEquals(500, account.checkBalance(), 0.01);
	}

	@Test
	public void testChangeClient() {
		Account account = new CurrentAccount(1,1);
		account.changeClient(100);
		assertEquals(100, account.getCustomerNumber());
	}

	@Test
	public void testGetPoints() {
		Account account = new HousingAccount(1,1);
		account.enterMoney(500);
		assertEquals(50, account.getPoints(), 0.01);
	}

	@Test
	public void testGetId() {
		Account account = new HousingAccount(1,1);
		assertEquals(1, account.getId(), 0.01);
	}

	@Test
	public void testGetCustomerNumber() {
		Account account = new InvestmentFund(1,1);
		assertEquals(1, account.getCustomerNumber(), 0.01);
	}

	@Test
	public void testGetType() {
		Account account = new CurrentAccount(1,1);
		assertEquals(AccountType.CURRENT, account.getType());
	}

	@Test
	public void testSetManager() {
		Account account = new InvestmentFund(1,1);
		account.setManager(new BankManager());
		assertNotNull(account.manager);
	}

	@Test
	public void testGetName() throws Exception {
		Bank bank = new RegularBank("test", 100);
		Customer customer = new Customer(50, "Juslan", "Vargas", "Max Fernandez 1313, 4717878", 75486663);
		bank.addCustomer(customer);
		bank.addAccount(AccountType.INVEST, 1, 50);
		Account account = bank.getAccount(1);
		assertEquals("Juslan", account.getName());
	}

	@Test
	public void testGetElementString() {
		Account account = new CurrentAccount(1,1);
		assertEquals("1 1 0.11 0.0 0 CURRENT", account.getElementString());
	}

	@Test
	public void testGetMonthlyReportString() {
		Account account = new CurrentAccount(1,1);
		assertEquals("1 -1.1", account.getMonthlyReportString());
	}

}

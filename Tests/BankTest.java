import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankTest {
	
	@Test
	void testBank() {
		assertNotNull(new RegularBank("bank",1));
	}
	
	@Test
	void testAddAccount() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(1, "V", "M", "S", 7));
		bank.addAccount(AccountType.INVEST, 1, 1);
		assertEquals("V", bank.getAccountList().get(0).getName());
	}
	
	@Test
	void testUpdateCustomer() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.updateCustomer(new Customer(10, "Sergio", "M", "S", 7));
		assertEquals("Sergio", bank.getCustomer(10).getName());
	}
	
	@Test
	void testGetElementString() {
		Bank bank = new RegularBank("test", 100);
		assertEquals("100 test REGULAR", bank.getElementString());
	}
	
	@Test
	void testChangeClientAccountWithoutCustomer() throws Exception {
		Bank bank = new RegularBank("test", 100);
		try {
			bank.addCustomer(new Customer(10, "V", "M", "S", 7));
			bank.addAccount(AccountType.INVEST, 1, 10);
			bank.changeClientAccount(1, 20);
			fail("This most throw an error");
		} catch (Exception e) {
			final String expected =  "The element does not exist in the list";
			assertEquals(expected, e.getMessage());
		}
	}
	
	
	@Test
	void testGetCustomer() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		assertEquals(7, bank.getCustomer(10).getCellPhone());
	}
	
	@Test
	void testGetCustomerList() {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.addCustomer(new Customer(20, "Sergio", "M", "S", 7));
		assertEquals(2, bank.getCustomerList().size());
	}
	
	@Test
	void testAddCustomerIntStringStringStringInt() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(1, "V", "M", "S", 7);
		assertEquals("V", bank.getCustomerList().get(0).getName());
	}
	
	@Test
	void testGetId() {
		Bank bank = new RegularBank("test", 100);
		assertEquals(100, bank.getId());
	}
	
	@Test
	void testChangeClientAccount() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.addAccount(AccountType.INVEST, 1, 10);
		bank.addCustomer(new Customer(20, "Sergio", "M", "S", 7));
		bank.changeClientAccount(1, 20);
		assertEquals("Sergio", bank.getAccount(1).getName());
	}
	
	@Test
	void testAddCustomerCustomer() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(1, "V", "M", "S", 7));
		assertEquals("V", bank.getCustomerList().get(0).getName());
	}
	
	@Test
	void testGetAccountList() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.addAccount(AccountType.INVEST, 1, 10);
		assertEquals(1, bank.getAccountList().size());
	}
	
	@Test
	void testGetAccount() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.addAccount(AccountType.INVEST, 1, 10);
		assertEquals(10, bank.getAccount(1).getCustomerNumber());
	}
	
	@Test
	void testUpdateAccount() throws Exception {
		Bank bank = new RegularBank("test", 100);
		bank.addCustomer(new Customer(10, "V", "M", "S", 7));
		bank.addAccount(AccountType.INVEST, 1, 10);
		bank.updateAccount(new CurrentAccount(1,10));
		assertEquals(AccountType.CURRENT, bank.getAccount(1).getType());
	}
	
	@Test
	void testGetName() {
		Bank bank = new RegularBank("test", 100);
		assertEquals("test", bank.getName());
	}

}

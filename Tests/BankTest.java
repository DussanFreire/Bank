import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankTest {
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

}

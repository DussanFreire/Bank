import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomer() {
		assertNotNull(new Customer(1, "Victor", "Montano", "Shakeaspeare 1010, 4503455", 79794464));
	}

	@Test
	public void testAddAccount() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		customer.addAccount(100);
		assertEquals(1, customer.accountsNumbers.size(), 0.01);
	}

	@Test
	public void testGetId() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals(1, customer.getId(), 0.01);
	}

	@Test
	public void testGetLastName() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals("M", customer.getLastName());
	}

	@Test
	public void testGetAddressAndPhone() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals("S", customer.getAddressAndPhone());
	}

	@Test
	public void testGetCellPhone() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals(7, customer.getCellPhone(), 0.01);
	}

	@Test
	public void testChangeAccount() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		customer.addAccount(100);
		customer.addAccount(200);
		customer.changeAccount(200);
		assertEquals(1, customer.accountsNumbers.size(), 0.01);
	}

	@Test
	public void testGetName() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals("V", customer.getName());
	}

	@Test
	public void testGetElementString() {
		Customer customer = new Customer(1, "V", "M", "S", 7);
		assertEquals("1 V M S 7", customer.getElementString());
	}

}

package pl.linuxpolska.drools.simple.osgi;

import pl.linuxpolska.drools.simple.model.Customer;

/**
 * 
 * @author ghalajko
 *
 */
public class Utils {

	/**
	 * 
	 * @return
	 */
	public static Customer customerLow() {
		return new Customer(1000);
	}

	/**
	 * 
	 * @return
	 */
	public static Customer customerNormal() {
		return new Customer(5000);
	}

	/**
	 * 
	 * @return
	 */
	public static Customer customerVip() {
		return new Customer(9001);
	}

}

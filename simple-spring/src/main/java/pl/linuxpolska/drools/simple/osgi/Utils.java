package pl.linuxpolska.drools.simple.osgi;

import java.util.Random;

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
	 *	/**
	 * 
	 */
	private static Random rand = new Random(12345);

	/**
	 * 
	 * @return
	 */
	public static Customer customer() {
		return new Customer(rand.nextInt(9999));
	}

}

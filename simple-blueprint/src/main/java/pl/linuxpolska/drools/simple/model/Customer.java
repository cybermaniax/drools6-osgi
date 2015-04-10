/**
 * 
 */
package pl.linuxpolska.drools.simple.model;

import java.io.Serializable;

/**
 * @author ghalajko
 *
 */
public class Customer implements Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private int salary;

	/**
	 * IS VIP.
	 */
	private CustomerType type;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * 
	 * @param salary
	 */
	public Customer(int salary) {
		super();
		this.salary = salary;
	}

	/**
	 * 
	 * @return
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * 
	 * @return
	 */
	public CustomerType getType() {
		return type;
	}

	/**
	 * 
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(CustomerType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [salary=" + salary + ", type=" + type + "]";
	}

}

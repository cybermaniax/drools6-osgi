package pl.linuxpolska.drools.simple.osgi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.kie.api.command.Command;
import org.kie.internal.command.CommandFactory;

import pl.linuxpolska.drools.simple.model.Customer;

/**
 * 
 * @author ghalajko
 *
 */
public class Utils {
	/**
	 * 
	 */
	private Random rand = new Random(12345);

	/**
	 * 
	 * @return
	 */
	public Customer customer() {
		return new Customer(rand.nextInt(9999));
	}

	/**
	 * 
	 * @param exchange
	 */
	public void insertAndFireAll(Exchange exchange) {
		final Message in = exchange.getIn();
		final Object body = in.getBody();

		
		final List<Command<?>> commands = new ArrayList<Command<?>>(2);
		commands.add(CommandFactory.newInsert(body));
		commands.add(CommandFactory.newFireAllRules());

		Command<?> batch = CommandFactory.newBatchExecution(commands);
		in.setBody(batch);
	}

}

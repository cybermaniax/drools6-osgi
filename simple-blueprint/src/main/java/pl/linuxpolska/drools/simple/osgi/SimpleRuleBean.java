package pl.linuxpolska.drools.simple.osgi;

import static pl.linuxpolska.drools.simple.osgi.Utils.customerLow;

import java.util.ArrayList;
import java.util.List;

import org.drools.core.impl.StatelessKnowledgeSessionImpl;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.linuxpolska.drools.simple.model.Customer;

/**
 * 
 * @author ghalajko
 *
 */
public class SimpleRuleBean {
	/**
	 * LOGGER.
	 */
	protected static final transient Logger logger = LoggerFactory
			.getLogger(SimpleRuleBean.class);
	/**
	 * StatelessKieSession
	 */
	private StatelessKnowledgeSessionImpl ksession;

	/**
	 * 
	 */
	public void start() throws Exception {
		Customer customer = customerLow();

		logger.info("KieSession fireAllRules. {}");

		List<Command<?>> commands = new ArrayList<Command<?>>();

		commands.add(CommandFactory.newInsert(customer, "customer"));
		commands.add(CommandFactory.newFireAllRules("num-rules-fired"));
		ExecutionResults results = ksession.execute(CommandFactory
				.newBatchExecution(commands));

		int fired = Integer.parseInt(results.getValue("num-rules-fired")
				.toString());

		customer = (Customer) results.getValue("customer");

		logger.info("After rule rules-fired={} {}", fired, customer);
	}

	/**
	 * 
	 * @param kieSession
	 */
	public void setKieSession(StatelessKnowledgeSessionImpl kieSession) {
		this.ksession = kieSession;
	}

}

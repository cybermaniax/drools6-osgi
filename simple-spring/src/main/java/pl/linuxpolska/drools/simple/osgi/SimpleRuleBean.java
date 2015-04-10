package pl.linuxpolska.drools.simple.osgi;

import static pl.linuxpolska.drools.simple.osgi.Utils.customer;

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

		for (int i = 0; i < 10; i++) {
			Customer customer = customer();
			logger.info("------------------- START ----------------------------------");
			logger.info("KieSession fireAllRules. {}", customer);

			List<Command<?>> commands = new ArrayList<Command<?>>();

			commands.add(CommandFactory.newInsert(customer, "customer"));
			commands.add(CommandFactory.newFireAllRules("num-rules-fired"));
			ExecutionResults results = ksession.execute(CommandFactory
					.newBatchExecution(commands));

			int fired = Integer.parseInt(results.getValue("num-rules-fired")
					.toString());

			customer = (Customer) results.getValue("customer");

			logger.info("After rule rules-fired={} {}", fired, customer);
			logger.info("------------------- STOP ----------------------------------");
		}

	}

	/**
	 * @param ksession
	 *            the ksession to set
	 */
	public void setKsession(StatelessKnowledgeSessionImpl ksession) {
		this.ksession = ksession;
	}
}

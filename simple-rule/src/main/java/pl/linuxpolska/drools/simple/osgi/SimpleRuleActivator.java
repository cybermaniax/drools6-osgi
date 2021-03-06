package pl.linuxpolska.drools.simple.osgi;

import static pl.linuxpolska.drools.simple.osgi.Utils.customerLow;
import static pl.linuxpolska.drools.simple.osgi.Utils.customerNormal;
import static pl.linuxpolska.drools.simple.osgi.Utils.customerVip;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.linuxpolska.drools.simple.model.Customer;

/**
 * 
 * @author ghalajko
 *
 */
public class SimpleRuleActivator implements BundleActivator {
	/**
	 * LOGGER.
	 */
	protected static final transient Logger logger = LoggerFactory
			.getLogger(SimpleRuleActivator.class);

	/**
	 * KieSession.
	 */
	private KieSession ksession;

	/**
	 * 
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		KieServices ks = KieServices.Factory.get();
		KieContainer kcont = ks.newKieClasspathContainer(getClass()
				.getClassLoader());
		KieBase kbase = kcont.getKieBase("SimpleRuleKBase");
		logger.info("KieSession newKieSession.");
		ksession = kbase.newKieSession();

		ksession.addEventListener(new DebugAgendaEventListener());
		ksession.addEventListener(new DebugRuleRuntimeEventListener());

		Customer customer = customerLow();

		logger.info("KieSession fireAllRules. {}", customer);
		FactHandle fh = ksession.insert(customer);
		ksession.fireAllRules();
		ksession.delete(fh);
		logger.info("After rule {}", customer);

		customer = customerNormal();
		logger.info("KieSession fireAllRules. {}", customer);
		fh = ksession.insert(customer);
		ksession.fireAllRules();
		ksession.delete(fh);
		logger.info("After rule {}", customer);
		
		customer = customerVip();
		logger.info("KieSession fireAllRules. {}", customer);
		fh = ksession.insert(customer);
		ksession.fireAllRules();
		ksession.delete(fh);
		
		logger.info("After rule {}", customer);
	}

	/**
	 * 
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (ksession != null) {
			ksession.dispose();
			logger.debug("KieSession disposed.");
		}

	}

}

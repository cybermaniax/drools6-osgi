package pl.linuxpolska.drools.test;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pl.linuxpolska.drools.simple.model.Customer;
import pl.linuxpolska.drools.simple.model.CustomerType;
import static pl.linuxpolska.drools.simple.osgi.Utils.customerLow;
import static pl.linuxpolska.drools.simple.osgi.Utils.customerNormal;
import static pl.linuxpolska.drools.simple.osgi.Utils.customerVip;

;
/**
 * 
 * @author ghalajko
 *
 */
public class SimpleTest {
	/**
	 * KieSession
	 */
	private KieSession ksession;

	/**
	 * 
	 */
	@BeforeClass
	public void beforeClass() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kcont = ks.newKieClasspathContainer();
		KieBase kbase = kcont.getKieBase("SimpleRuleKBase");
		ksession = kbase.newKieSession();
		ksession.addEventListener(new DebugAgendaEventListener());
		ksession.addEventListener(new DebugRuleRuntimeEventListener());
	}

	/**
	 * afterClass
	 */
	@AfterClass
	public void afterClass() {
		if (null != ksession) {
			ksession.dispose();
		}
	}

	/**
	 * 
	 * @return
	 */
	@DataProvider(name = "test-rule")
	public static Object[][] rules() {
		return new Object[][] { { customerLow(), CustomerType.LOW },
				{ customerNormal(), CustomerType.NORMAL },
				{ customerVip(), CustomerType.VIP } };
	}

	/**
	 * 
	 */
	@Test(dataProvider = "test-rule")
	public void t1(Customer customer, CustomerType type) {
		FactHandle fh = ksession.insert(customer);

		ksession.fireAllRules();

		ksession.delete(fh);

		assert customer.getType() == type : "Is Not " + type;
	}

}

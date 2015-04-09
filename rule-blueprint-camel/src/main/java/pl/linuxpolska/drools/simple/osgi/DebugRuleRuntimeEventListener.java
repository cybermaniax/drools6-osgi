package pl.linuxpolska.drools.simple.osgi;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author ghalajko
 *
 */
public class DebugRuleRuntimeEventListener implements RuleRuntimeEventListener {
	/**
	 * LOG
	 */
	private static final Logger log = LoggerFactory
			.getLogger(DebugRuleRuntimeEventListener.class);

	/**
	 * 
	 */
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		log.info("objectInserted {}", event);
	}

	/**
 * 
 */
	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		log.info("objectUpdated {}", event);

	}

	/**
	 * 
	 */
	@Override
	public void objectDeleted(ObjectDeletedEvent event) {
		log.info("objectDeleted {}", event);
	}

}

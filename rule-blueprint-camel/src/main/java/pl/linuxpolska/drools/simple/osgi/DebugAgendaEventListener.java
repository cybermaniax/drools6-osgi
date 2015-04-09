package pl.linuxpolska.drools.simple.osgi;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author ghalajko
 *
 */
public class DebugAgendaEventListener implements AgendaEventListener {
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory
			.getLogger(DebugAgendaEventListener.class);

	@Override
	public void matchCreated(MatchCreatedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void matchCancelled(MatchCancelledEvent event) {
		log.info("{}", event);

	}

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		log.info("{}", event);

	}

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		log.info("{}", event);

	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		log.info("{}", event);

	}

	@Override
	public void afterRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		log.info("{}", event);

	}

}

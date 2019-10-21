package org.domaincomponents.axonframework.extensions.aws.eventbridgetest;

import org.axonframework.eventhandling.EventBus;
import org.domaincomponents.axonframework.extensions.aws.eventbridge.eventhandling.EventMessageWriter;
import org.domaincomponents.axonframework.extensions.aws.eventbridge.eventhandling.spring.EventBridgePublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;

@Configuration
public class EventBridgeConfig {

	@ConditionalOnMissingBean
	@Bean(initMethod = "start", destroyMethod = "shutDown")
	public EventBridgePublisher awsEventBridgePublisher(EventBus eventBus, EventMessageWriter eventMessageWriter) {
		EventBridgePublisher eb = new EventBridgePublisher(eventBus, eventMessageWriter);
		return eb;
	}

	@ConditionalOnMissingBean
	@Bean
	public EventMessageWriter awsEventMessageWriter(EventBridgeClient ebClient) {
		return new EventMessageWriter(ebClient);
	}

	@ConditionalOnMissingBean
	@Bean
	public EventBridgeClient awsEventBridgeClient() {
		return EventBridgeClient.builder().region(Region.US_EAST_2).build();
	}
}

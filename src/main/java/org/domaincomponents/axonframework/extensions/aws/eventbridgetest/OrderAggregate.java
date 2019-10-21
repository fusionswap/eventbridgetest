package org.domaincomponents.axonframework.extensions.aws.eventbridgetest;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.domaincomponents.axonframework.extensions.aws.eventbridgetest.command.CreateOrderCommand;
import org.domaincomponents.axonframework.extensions.aws.eventbridgetest.event.OrderCreatedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;


@Aggregate
public class OrderAggregate {
	@AggregateIdentifier
	private String id;

	private String orderName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand cmd){
		apply(new OrderCreatedEvent(cmd.getId(), cmd.getOrderName()));
	}
	
	@EventSourcingHandler
	public void on(OrderCreatedEvent oe) {
		this.id = oe.getOrderId();
		this.orderName = oe.getOrderName();
	}
	
}

package org.domaincomponents.axonframework.extensions.aws.eventbridgetest.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand {
	@TargetAggregateIdentifier
	private String id;
	private String orderName;

	public CreateOrderCommand(String id, String orderName) {
		super();
		this.id = id;
		this.orderName = orderName;
	}

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
}

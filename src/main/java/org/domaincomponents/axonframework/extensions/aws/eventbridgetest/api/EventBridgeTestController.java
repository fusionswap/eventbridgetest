package org.domaincomponents.axonframework.extensions.aws.eventbridgetest.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.domaincomponents.axonframework.extensions.aws.eventbridgetest.command.CreateOrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventBridgeTestController {

	private final CommandGateway commandGateway;
	
	@Autowired
	public EventBridgeTestController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	@RequestMapping(path="/order", method=RequestMethod.POST)
	public void pubishOrder(@RequestBody OrderRequest req) {
		commandGateway.sendAndWait(new CreateOrderCommand(req.getOrderId(), req.getOrderName()));
	}
}

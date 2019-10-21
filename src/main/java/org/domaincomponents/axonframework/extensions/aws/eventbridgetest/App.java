package org.domaincomponents.axonframework.extensions.aws.eventbridgetest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.domaincomponents.axonframework.extensions.aws.eventbridgetest.command.CreateOrderCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);
//		CreateOrderCommand c = new CreateOrderCommand(UUID.randomUUID().toString(), "order name");
//		ctx.getBean(CommandGateway.class).send(c);
	}
}

package com.redhat.training.jb421;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//add from() call to the route
		//from("file:orders/incoming?include=.*xml")
		
		from("file:orders/incoming")
		.choice()
			.when(header("CamelFileName").endsWith(".xml"))
				.log("XML ORDER TRANSMITTED: ${header.CamelFileName}")
				.to("file:orders?fileName=jounal.txt&fileExist=Append");
		//add to() call to the route
		
	}

}

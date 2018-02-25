package com.redhat.training.converters;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;

import com.redhat.training.model.Order;
//Annotate as a converter
@Converter
public class OrderConverter {
	public static String orderToString(Order order, Exchange exchange) {
		return order.toString();
	}
	
	public static InputStream orderToIStream(Order order, Exchange exchange) {
		ByteArrayInputStream bais = new ByteArrayInputStream(order.toString().getBytes());
		return bais;
	}
}

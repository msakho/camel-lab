package com.redhat.training.beans;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.redhat.training.model.Batch;
import com.redhat.training.model.Order;



public class BatchOrderAggregationStrategy implements AggregationStrategy {
	
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		if(oldExchange == null)
		{
			Batch batch = new Batch((int)newExchange.getIn().getHeader("batchNumber"));
			
			batch.addOrder(newExchange.getIn().getBody(Order.class));
		    newExchange.getIn().setBody(batch);
		    return newExchange;
			
		}
		Batch batch = oldExchange.getIn().getBody(Batch.class);
		Order order = newExchange.getIn().getBody(Order.class);
		batch.addOrder(order);
		oldExchange.getIn().setBody(batch);
		return oldExchange;
	}


}

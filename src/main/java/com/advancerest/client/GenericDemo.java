package com.advancerest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.messenger.beans.Message;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		List<Message> messages=client.target("http://localhost:8080/advanceJaxrsRain/webapi/")
		.path("/messages/getAllMessages")
		.queryParam("year", 2018)
		.request(MediaType.APPLICATION_JSON)
		.get(new GenericType<List<Message>>() {});
		
		System.out.println(messages);
	}

}

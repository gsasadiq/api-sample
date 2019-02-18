package com.advancerest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.messenger.beans.Message;

public class RestApiClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget=client.target("http://localhost:8080/advanceJaxrsRain/webapi/");
		WebTarget messagesTarget =baseTarget.path("/messages");
		WebTarget oneMessage=messagesTarget.path("{messageId}");
		
		Message message1=oneMessage.resolveTemplate("messageId", "1")
		.request(MediaType.APPLICATION_JSON)
		.get(Message.class);
		
		Message message2=oneMessage.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message1);
		System.out.println(message2);
		
	}

}

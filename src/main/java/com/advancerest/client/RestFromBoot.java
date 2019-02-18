package com.advancerest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class RestFromBoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		
		//Response response=client.target("http://localhost:8081/topics").request().get();
		//System.out.println(response.readEntity(String.class).toString());
		
		String response=client.target("http://localhost:8081/topics").request().get(String.class);
		System.out.println(response);
	}

}

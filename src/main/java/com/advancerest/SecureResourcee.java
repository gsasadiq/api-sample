package com.advancerest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secured")
public class SecureResourcee {
	
	@GET
	@Path("/message")
	@Produces(MediaType.TEXT_PLAIN)
	public String secureMethod() {
		return "This API is secured..";
	}
}

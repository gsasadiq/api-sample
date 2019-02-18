package com.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResourse {
	
	@GET
	public String test() {
		return "new sub resourse Test.";
	}
	
	@GET
	@Path("/{commentId}")
	public String gsa(@PathParam("messageId")long messageId,@PathParam("commentId")long commentId) {
		return "gsa ready.." + commentId +"message id "+messageId;
	}
}

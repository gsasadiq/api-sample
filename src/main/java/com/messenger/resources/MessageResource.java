package com.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.messenger.beans.Message;
import com.messenger.service.MessageService;

@Path("/messages")
@Consumes(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class MessageResource {
	
	MessageService messageService=new MessageService();
	
	@GET
	@Path("/getAllMessages")
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message= messageService.getMessage(id);
		
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message),"profile");
		//message.addLink(getUriForComments(uriInfo,message), "comments");
		return message;
	}

	/*private String getUriForComments(UriInfo uriInfo, Message message) {
		URI uri=uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResourse.class)
				.resolveTemplate("messageId", message.getId())
				.build();
				return uri.toString();
	}*/

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri=uriInfo.getBaseUriBuilder()
		.path(ProfileResource.class)
		.path(message.getAuthor())
		.build();
		return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri =uriInfo.getBaseUriBuilder()
		.path(MessageResource.class)
		.path(Long.toString(message.getId()))
		.build()
		.toString();
		return uri;
	}
	
	@POST
	@Path("/addMessage")
	public Response addMessage(Message message) {
		 Message createdMessage=messageService.addMessage(message);
		 
		  Response builder=Response.status(Status.CREATED)
				 .entity(createdMessage).build();
		  
		  return builder;
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		 messageService.removeMessage(id);
	}
	
	
	
	@Path("/{messageId}/comments")
	public CommentResourse hello() {
		return new CommentResourse();
	}
}

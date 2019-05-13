//$Id$
package com.tm.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import com.tm.messenger.model.Message;
import com.tm.messenger.resources.bean.MessageFilterBean;
import com.tm.messenger.service.MessageService;

@Path("/messages")
public class MessageResources {

	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getALlMessageForYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		/**
		 * the crux part, if dont understand watch the 26th video of Jax-RS
		 * from java brain
		 */
		Message newMessage = messageService.addMessage(message);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId()));
		URI uri = uriBuilder.build();
		return Response.created(uri) 
				.status(Status.CREATED)
		        .entity(newMessage).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(Message message, @PathParam("messageId") long id) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id) {
		return messageService.removeMessage(id);
	}

}

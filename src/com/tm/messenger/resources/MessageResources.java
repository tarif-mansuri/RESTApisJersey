//$Id$
package com.tm.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")
public class MyResources {

	@GET
	public String getMessages(){
		return "child package";
	}
}

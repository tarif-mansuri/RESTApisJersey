//$Id$
package com.tm.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")     
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
										   @HeaderParam("customeHeaderValue") String header,
										   @CookieParam("coockieName") String cockie){
		return "matrixParam: "+matrixParam+" Header Value: "+header;
	}
	
	@GET
	@Path("contexturl")
	public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Absolute Path: "+path+" Cookies: "+cookies ;
	}
}

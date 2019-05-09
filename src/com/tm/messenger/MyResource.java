//$Id$
package com.tm.messenger;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * 
 * @author tarif-5329
 *
 */

@Path("/myresources")
public class MyResource {

	@GET
	@Produces(MediaType.TEXT_HTML)
	//@Path("name")
	public String getMessage(){
		return "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Insert title here</title>"
				+ "<p>Boo Yeah ! Getting Thanks for putting me inside WebContent</p>"
				+ "</head>"
				+ "<body>"
				+ "</body>"
				+ "</html>";
	}
}
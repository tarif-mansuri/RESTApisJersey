//$Id$
package com.tm.myresources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 * 
 * @author tarif-5329
 *
 */
@Path("MyResources")
public class MyResource {

	@GET
	public String getMessage(){
		return null;
	}
}

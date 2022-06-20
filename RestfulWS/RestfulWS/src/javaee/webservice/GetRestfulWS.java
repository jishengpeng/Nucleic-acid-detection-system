package javaee.webservice;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/getrestfulws")
public class GetRestfulWS {
	
	@GET
	@Path("/sayHi")
	@Produces("text/plain") 
	public String sayHi(@QueryParam("name") String n) { 
		return "Hi " + n;
	}
}

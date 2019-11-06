/**
 * 
 */
package org.acme.pv.custom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author dtorresf
 *
 */
@Api(value = "Greeting simple endpoint")
@Path("greeting")
public class GreetingEndpointService {
	@GET
	@Path("hello")
	@ApiOperation(value = "just say Hello", response = String.class, code = 200)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Hello to you") })
	public Response sayHello() {
		Response.ResponseBuilder rb = Response.ok("Hello");
		return rb.build();
	}
}

/**
 * 
 */
package org.acme.pv.custom;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jbpm.services.api.ProcessService;
import org.kie.server.services.api.KieServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author dtorresf
 *
 */
@Api(value = "Connected Example simple endpoint")
@Path("pv")
public class ProcessResourceEndpointService {
	private static final Logger logger = LoggerFactory.getLogger(ProcessResourceEndpointService.class);

	@Autowired
	private ProcessService processService;

	@Autowired
	private KieServer kieServer;

	public ProcessResourceEndpointService() {
	}

	@GET
	@Path("psid")
	@ApiOperation(value = "just print the ProcessService object id", response = String.class, code = 200)
	@ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Hello to you") })
	public Response getProcessServiceInstanceId() {
		logger.info("Lets print its value: " + this.processService);
		logger.info("I ALSO HAVE THIS VALUE:" + this.kieServer);
		Response.ResponseBuilder rb = Response.ok(this.processService.toString());
		return rb.build();
	}
}

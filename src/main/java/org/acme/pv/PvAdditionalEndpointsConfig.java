/**
 * 
 */
package org.acme.pv;

import org.acme.pv.custom.GreetingEndpointService;
import org.acme.pv.custom.ProcessResourceEndpointService;
import org.jbpm.kie.services.impl.ProcessServiceImpl;
import org.jbpm.springboot.autoconfigure.JBPMAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dtorresf
 *
 */
@Configuration
@AutoConfigureAfter({ JBPMAutoConfiguration.class })
public class PvAdditionalEndpointsConfig {
	private static final Logger logger = LoggerFactory.getLogger(PvAdditionalEndpointsConfig.class);
	
	public PvAdditionalEndpointsConfig() {
		logger.info("CONFIGURATION EMPTY Constructor");
	}

	@Bean
	public GreetingEndpointService ges() {
		return new GreetingEndpointService();
	}

	@Bean
	@ConditionalOnClass({ ProcessServiceImpl.class})
	public ProcessResourceEndpointService pres() {
		logger.info("WILL START NOW A BEAN FOR PRES");
		return new ProcessResourceEndpointService();
	}
	// TODO: List Beans for additional endpoints
}

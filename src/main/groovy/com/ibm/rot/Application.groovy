package com.ibm.rot

import org.glassfish.jersey.server.*
import io.swagger.jaxrs.config.*
import io.swagger.jaxrs.listing.*

/**
 * Rot application.
 * 
 * @author thorntonrose
 */
class Application extends ResourceConfig {
	Application() {
		packages Application.class.package.name

		// Swagger
		BeanConfig beanConfig = new BeanConfig()
      beanConfig.setResourcePackage Application.class.package.name
      beanConfig.setScan true
		beanConfig.setPrettyPrint true
		register ApiListingResource
		register SwaggerSerializers
	}
}
package com.ibm.rot

import io.undertow.*
import io.undertow.servlet.*
import io.undertow.server.*
import io.undertow.util.*
import javax.ws.rs.core.*
import org.glassfish.jersey.servlet.*

class Main {
	static final rot13 = new Rot13()
	static server

	static void main(String[] args) {
		start()
	}

	static void start() {
		def deployment = Servlets
			.deployment()
			.setClassLoader(Application.class.classLoader)
			.setDeploymentName(".")
			.setContextPath("")
			.addServlets(
				Servlets.servlet("jersey", ServletContainer.class)
					.setLoadOnStartup(1)
					.addMapping("/*")
					.addInitParam(ServletProperties.JAXRS_APPLICATION_CLASS, Application.class.name)
			)

		def deploymentManager = Servlets.defaultContainer().addDeployment(deployment)
		deploymentManager.deploy()

		server = Undertow
			.builder()
			.addHttpListener(8080, "0.0.0.0")
			.setHandler(deploymentManager.start())
			.build()
		server.start()
	}

	static void stop() {
		server?.stop()
	}
}
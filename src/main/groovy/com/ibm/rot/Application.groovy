package com.ibm.rot

import org.glassfish.jersey.server.*

/**
 * Rot application.
 * 
 * @author thorntonrose
 */
class Application extends ResourceConfig {
	Application() {
		packages Application.class.package.name
	}
}
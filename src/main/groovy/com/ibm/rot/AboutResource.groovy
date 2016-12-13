package com.ibm.rot

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("about")
class AboutResource {
	@GET
	Response get() {
		return Response.status(200).entity(new File("about.json").text).build()
	}
}
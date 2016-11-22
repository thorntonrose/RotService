package com.ibm.rot

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

/**
 * ROT13 resource.
 * 
 * @author thorntonrose
 */
@Path("")
class RotResource {
	Rot13 rot13 = new Rot13()

	@GET
	@Path("rot13")
	Response rot13(@QueryParam("text") String text) {
		String rottedText = rot13.rot(text)
		return Response.status(200).entity(rottedText).build()
	}

	@POST
	@Path("rot13")
	Response rot13Post(String text) {
		String rottedText = rot13.rot(text)
		return Response.status(200).entity(rottedText).build()		
	}
}
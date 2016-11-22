package com.ibm.rot

import org.junit.*
import static groovy.test.GroovyAssert.*

/**
 * RotResource tests.
 * 
 * @author thorntonrose
 */
class RotResourceTest {
	@Test
	void testRot13() {
		def response = new RotResource().rot13("abc")
		assertEquals "status:", 200, response.status
		assertEquals "entity:", "nop", response.entity 
	}

	@Test
	void testRot13Post() {
		def response = new RotResource().rot13Post("abc")
		assertEquals "status:", 200, response.status
		assertEquals "entity:", "nop", response.entity 
	}
}
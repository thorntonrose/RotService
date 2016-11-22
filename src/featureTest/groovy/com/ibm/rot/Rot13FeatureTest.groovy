package com.ibm.rot

import org.junit.*
import static groovy.test.GroovyAssert.*

/**
 * Rot13 feature tests.
 * 
 * @author thorntonrose
 */
class Rot13FeatureTest {
	@Test
	void testRot13() {
		def result = new URL("http://localhost:8080/rot13?text=nop").text
		assertEquals "result:", "abc", result		
	}

	//@Test
	void testRot13Post() {
		fail "not yet implemented"
	}
}
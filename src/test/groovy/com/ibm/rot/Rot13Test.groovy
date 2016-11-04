package com.ibm.rot

import org.junit.*
import static groovy.test.GroovyAssert.*

/**
 * Rot13 tests.
 * 
 * @author thorntonrose
 */
class Rot13Test {
	@Test
	void testRot() {
		assertEquals "rot:", "nop", new Rot13().rot("abc")
	}
	
	@Test
	void testMain_Usage() {
		def currOut = System.out

		try {
			def out = new ByteArrayOutputStream()
			System.out = new PrintStream(out)
			Rot13.main(new String[0])
			assertEquals "out:", "usage: rot13 <text>\n", out.toString()
		} finally {
			System.out = currOut
		}
	}

	@Test
	void testSomething() {
		println "testSomething"
	}
}
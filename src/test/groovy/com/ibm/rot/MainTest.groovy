package com.ibm.rot

import org.junit.*
import static groovy.test.GroovyAssert.*

class MainTest {
	@After
	void tearDown() {
		Main.stop()
	}

	@Test
	void testStart() {
		Main.start()
		Thread.sleep 100
		def result = new URL("http://localhost:8080?nop").text
		assertEquals "result:", "abc", result
	}
}
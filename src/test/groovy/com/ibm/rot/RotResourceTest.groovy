package com.ibm.rot

import com.github.tomakehurst.wiremock.client.*
import com.github.tomakehurst.wiremock.junit.*
import org.junit.*
import static groovy.test.GroovyAssert.*
import static com.github.tomakehurst.wiremock.client.WireMock.*

/**
 * RotResource tests.
 *
 * @author thorntonrose
 */
class RotResourceTest {
	//@ClassRule
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(9090)

	@Before
	void setUp() {
		//configureFor "http://dev.clearleap.com", 9090
		//WireMock.reset()
	}

	@Test
	void testRot13() {
		stubFor get(urlEqualTo("/rot13")).willReturn(aResponse().withStatus(200))

		def response = new RotResource().rot13("abc")
		assertEquals "status:", 200, response.status
		assertEquals "entity:", "nop", response.entity

		verify getRequestedFor(urlEqualTo("/rot13"))
	}

	@Test
	void testRot13Post() {
		def response = new RotResource().rot13Post("abc")
		assertEquals "status:", 200, response.status
		assertEquals "entity:", "nop", response.entity
	}
}
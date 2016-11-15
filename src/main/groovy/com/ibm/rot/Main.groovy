package com.ibm.rot

import io.undertow.*
import io.undertow.server.*
import io.undertow.util.*

class Main {
	static final rot13 = new Rot13()
	static server

	static void main(String[] args) {
		start()
	}	

	static void start() {
		def requestHandler = new HttpHandler() {
			@Override
			public void handleRequest(final HttpServerExchange exchange) throws Exception {
				exchange.responseHeaders.put Headers.CONTENT_TYPE, "text/plain"
				exchange.responseSender.send rot13.rot(exchange.queryString)
			}
		}

		server = Undertow.builder().setHandler(requestHandler).addHttpListener(8080, "0.0.0.0").build()
		server.start()
	}

	static void stop() {
		server?.stop()
	}
}
node {
	stage("checkout") {
		checkout scm
	}

	stage("build") {
		sh "./gradlew assemble"
	}

	stage("test") {
		sh "./gradlew test"
	}
}
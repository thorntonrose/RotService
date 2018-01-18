node {
	def props

	stage("checkout") {
		checkout scm
	}

	stage("build") {
		props = readProperties(text: sh(script: "./gradlew properties", returnStdout: true))
		sh "./gradlew assemble"
	}

	stage("test") {
		sh "./gradlew test"
		junit "build/test-results/test/TEST-*.xml"
	}

	stage("publish") {
		def branch = sh(script: "git branch | cut -f2 -d' '", returnStdout: true).trim()
		def commitId = bash("git rev-parse HEAD", true).trim()[0..9]
		def timestamp = new Date().format('yyyyMMddHHmmss')
		def tag = "${props.version}-$timestamp-$commitId"
		writeFile file: "build/$tag", text: tag

		sh "git tag -am \"publish ${props.version}\" ${tag}"
		sshagent([ 'roseth' ]) { sh "git push origin ${branch} --tags" }

		archiveArtifacts "build/${props.version}-*"
	}
}
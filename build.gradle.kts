plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "me.dio"
version = "0.0.3-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.0"

// Spring Initializer: https://start.spring.io/#!type=gradle-project-kotlin&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=me.dio&artifactId=santander-dev-week-2024&name=santander-dev-week-2024&description=API%20REST%20Sobre%20Campe%C3%B5es%20do%20LoL&packageName=me.dio.sdw24&dependencies=web,data-jdbc,h2,cloud-feign

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	// OpenAPI (Swagger): https://springdoc.org/#getting-started
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")

	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

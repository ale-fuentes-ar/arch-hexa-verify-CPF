plugins {
	java
	id("org.springframework.boot") version "3.2.6" 
	id("io.spring.dependency-management") version "1.1.7"
}

val mapstructVersion = "1.5.5.Final"
group = "io.gitlab.alefuentes"
version = "0.0.1-SNAPSHOT"
description = "Hexagonal proyect, where your goal is verify CPF of user"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.2")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.kafka:spring-kafka")
    
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign") 

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")

	// Embedded MongoDB for tests (Flapdoodle)
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.9.2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	testImplementation("com.tngtech.archunit:archunit-junit5:1.2.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
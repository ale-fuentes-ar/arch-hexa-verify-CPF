plugins {
	java
    // --- CORRECCIÓN --- He cambiado la versión a una estable y existente
	id("org.springframework.boot") version "3.2.6" 
	id("io.spring.dependency-management") version "1.1.7"
}

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

// --- INICIO DE LA SOLUCIÓN ---
// Este bloque gestiona las versiones de las dependencias para que no tengas que especificarlas tú.
dependencyManagement {
	imports {
		// Esta línea le dice a Gradle que use las versiones de Spring Cloud 2023.0.2 (compatibles con Spring Boot 3.2.x)
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.2")
	}
}
// --- FIN DE LA SOLUCIÓN ---


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.kafka:spring-kafka")
    
    // Ahora esta línea funcionará porque el BOM de arriba le proporciona la versión correcta
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign") 

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
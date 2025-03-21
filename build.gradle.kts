plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("at.favre.lib:bcrypt:0.10.2")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.7.2")

}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

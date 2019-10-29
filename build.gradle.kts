plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.41"

    `java-library`
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("com.beust:klaxon:5.0.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.asynchttpclient:async-http-client:2.10.4")

    testImplementation("org.jetbrains.kotlin:kotlin-test")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

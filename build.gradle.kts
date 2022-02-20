import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//import org.jetbrains.kotlinx:kotlinx-serialization-json

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.6.10"
    application
}

group = "me.al199"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "15"
}

application {
    mainClass.set("MainKt")
}
plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "aoc.year2024.day12.MainKt"
}

tasks.run.configure {
    standardInput = System.`in`
}

dependencies {
    val assertJVersion = "3.26.3"

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

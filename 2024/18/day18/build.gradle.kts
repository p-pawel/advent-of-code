plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "aoc.year2024"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass = "aoc.year2024.day18.Day18Kt"
}

tasks.run.configure {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
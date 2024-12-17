plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "aoc.year2024"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val jupiterVersion = "5.10.0"

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:$jupiterVersion")
}

application {
    mainClass = "aoc.year2024.day17.MainGAKt"
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
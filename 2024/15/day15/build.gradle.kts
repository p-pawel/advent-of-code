plugins {
    kotlin("jvm") version "2.0.21"
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

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
plugins {
    kotlin("jvm") version "2.0.21"
    application
}

group = "aoc.year2024"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

val skirmishHaversackVersion = "2024.12"

dependencies {
    implementation("com.github.p-pawel:dev.skirmish-haversack:$skirmishHaversackVersion")
    testImplementation(kotlin("test"))
}

application {
    mainClass = "aoc.year2024.day20.MainKt"
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
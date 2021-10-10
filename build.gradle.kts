import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
    maven("https://jitpack.io/")
}

dependencies {
    implementation(kotlin("stdlib", "1.5.31"))
    implementation("net.dv8tion:JDA:4.3.0_334")
    implementation("com.github.minndevelopment:jda-ktx:d90709a")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("org.slf4j:slf4j-log4j12:1.7.32")
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
}

tasks.withType(KotlinCompile::class).all {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
}

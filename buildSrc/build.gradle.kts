plugins {
    `kotlin-dsl`
    kotlin("plugin.serialization") version embeddedKotlinVersion
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.fabricmc.net/")
    maven("https://server.bbkr.space/artifactory/libs-release/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://maven.quiltmc.org/repository/release/")
}

dependencies {
    fun pluginDep(id: String, version: String) = "${id}:${id}.gradle.plugin:${version}"
    val kotlinVersion = "1.9.21"

    compileOnly(kotlin("gradle-plugin", kotlinVersion))
    runtimeOnly(kotlin("gradle-plugin", kotlinVersion))
    compileOnly(pluginDep("org.jetbrains.kotlin.plugin.serialization", kotlinVersion))
    runtimeOnly(pluginDep("org.jetbrains.kotlin.plugin.serialization", kotlinVersion))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    // Fabric implementation
    implementation("net.fabricmc:fabric-loom:1.4-SNAPSHOT")

    // Paper implementation
    implementation("io.papermc.paperweight.userdev:io.papermc.paperweight.userdev.gradle.plugin:1.+")
    implementation(pluginDep("xyz.jpenilla.run-paper", "2.+"))

    implementation("gradle.plugin.com.github.johnrengelman:shadow:8.+")
    implementation(pluginDep("com.modrinth.minotaur", "2.+"))
}

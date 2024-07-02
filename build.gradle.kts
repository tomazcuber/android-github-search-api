// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.5.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
        classpath("io.github.gradle-nexus:publish-plugin:2.0.0")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0" apply true
    id("org.jetbrains.dokka") version "1.9.20"
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            if(project.hasProperty("ossrhUsername") && project.hasProperty("ossrhPassword")) {
                username.set(project.property("ossrhUsername") as String)
                password.set(project.property("ossrhPassword") as String)
            }
        }
    }
}
group = "br.com.tomazcuber"
version = "1.0.0"
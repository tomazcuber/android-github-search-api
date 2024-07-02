plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("signing")
    id("org.jetbrains.dokka")
//    id("io.github.gradle-nexus.publish-plugin")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "br.com.tomazcuber.githubapi"
    compileSdk = 34


    defaultConfig {
        minSdk = 24

        aarMetadata {
            minCompileSdk = 24
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kotlin {
        jvmToolchain(17)
    }

    testFixtures {
        enable = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0")

    val okhttp3Version = "4.10.0"
    implementation("com.squareup.okhttp3:okhttp:${okhttp3Version}")
    implementation("com.squareup.okhttp3:logging-interceptor:${okhttp3Version}")

    implementation("com.google.code.gson:gson:2.11.0")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Retrofit with Scalar Converter
    implementation("com.squareup.retrofit2:converter-scalars:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:2.11.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    implementation("com.google.dagger:dagger:2.44")
    kapt("com.google.dagger:dagger-compiler:2.44")

    dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:1.9.20")
    testImplementation("junit:junit:4.13.2")

    testImplementation("io.strikt:strikt-core:0.34.1")
    testImplementation(platform("io.strikt:strikt-bom:0.34.1"))
    testImplementation("io.strikt:strikt-jvm")

    testImplementation("io.mockk:mockk:1.13.11")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

tasks.register<Jar>("androidSourcesJar") {
    archiveClassifier.set("sources")
    if (project.plugins.findPlugin("com.android.library") != null) {
        from("android.sourceSets.main.kotlin.srcDirs")
        from("android.sourceSets.main.kotlin.srcDirs")
    } else {
        from("sourceSets.main.java.srcDirs")
        from("sourceSets.main.kotlin.srcDirs ")
    }
}


tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("html-docs")
}

tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

artifacts {
    add("archives", tasks.named("androidSourcesJar"))
    add("archives", tasks.named("dokkaHtmlJar"))
    add("archives", tasks.named("dokkaJavadocJar"))
}

project.ext.set("isReleaseVersion", !version.toString().endsWith("SNAPSHOT"))

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = properties["POM_GROUP_ID"] as String
                artifactId = properties["POM_ARTIFACT_ID"] as String
                version = properties["POM_VERSION"] as String

                afterEvaluate {
                    from(components["release"])
                }

                artifact(tasks["androidSourcesJar"])
                artifact(tasks["dokkaHtmlJar"])
                artifact(tasks["dokkaJavadocJar"])

                pom {
                    name.set("Android Github API")
                    description.set("A simple wrapper for the Github API as an Android library")
                    url.set("https://github.com/tomazcuber/GithubSearch")
                    licenses {
                        license {
                            name.set("BSD 2-Clause License")
                            url.set("http://www.opensource.org/licenses/bsd-license.php")
                        }
                    }
                    developers {
                        developer {
                            id.set("tomazcuber")
                            name.set("Tomaz Cuber")
                            email.set("tomazcuber@outlook.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/tomazcuber/GithubSearch.git")
                        developerConnection.set("scm:git:ssh://github.com/tomazcuber/GithubSearch.git")
                        url.set("https://github.com/tomazcuber/GithubSearch.git")
                    }
                }
                signing {
                    sign(publishing.publications["release"])
                }
            }
        }
    }
}
import org.gradle.internal.classpath.ClassPath

plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
}


dependencies {
    implementation("com.android.tools.build:gradle:8.5.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("io.github.didi:drouter-plugin:1.4.0")
}
val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}
//configurations.all {
//    resolutionStrategy.force("androidx.transition:transition:1.4.1")
//}
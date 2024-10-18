// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven("https://maven.aliyun.com/nexus/content/repositories/google")
        maven("https://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        maven("https://jitpack.io")
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("io.github.didi:drouter-plugin:1.4.0")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}



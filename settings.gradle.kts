pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven("https://maven.aliyun.com/nexus/content/repositories/google")
        maven("https://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        maven("https://jitpack.io")
        google()
        mavenCentral()
    }
}

rootProject.name = "CatalogBuild"
include(":app")

//功能库（右键根项目CatalogBuild->new->module，选创建Android Library
// 创建coreLib文件夹，再把module拖动到文件夹内，修改setting.gradle）
include(":coreLib:lib-media")
include(":coreLib:lib-basic")
include(":coreLib:lib-bridge")

//业务组件库
include(":module-login") //登录
include(":module-tools") //工具

//apkBuild下独立打包（右键根项目CatalogBuild->New->module,选创建phone/Tablet库
// 然后创建apkBuild文件夹，再把module拖动move到文件夹refactor,修改setting.gradle）
include(":apkBuild:apk-login")
include(":apkBuild:apk-tools")

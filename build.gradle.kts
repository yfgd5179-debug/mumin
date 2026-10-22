// Üst seviye Gradle yapılandırması.
// Eklenti SÜRÜMLERİ burada tanımlanır, uygulama modülü bunları kullanır.
plugins {
    id("com.android.application") version "8.13.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false
}

allprojects {
    val buildBaseDir = System.getenv("LOCALAPPDATA") ?: System.getProperty("java.io.tmpdir")
    layout.buildDirectory.set(file("$buildBaseDir/GradleBuilds/${rootProject.name}/${project.name}"))
}


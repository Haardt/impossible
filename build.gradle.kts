plugins {
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.add("--enable-preview")
    compilerArgs.add("-Xlint:preview")
}

tasks.withType<JavaExec> {
    jvmArgs?.add("--enable-preview")
}

application {
    mainClass.set("com.conpinion.Main")
}

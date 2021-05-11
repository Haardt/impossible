plugins {
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec> {
    jvmArgs?.add("--enable-preview")
}

application {
    mainClass.set("com.conpinion.Main")
}

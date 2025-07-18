pipeline {
    agent any

    tools {
        jdk 'jdk-11'            // Asegúrate de tener JDK 11 instalado y con ese nombre
        gradle 'Gradle-7.6'     // Mismo caso para Gradle
    }

    environment {
        LANG = "en_US.UTF-8"
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-pat',            // Usa el ID de tus credenciales
                    branch: 'main',
                    url: 'https://github.com/RodCastDev/EncoraTestAutoUI.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Usa el comando según tu sistema operativo:
                // Si Jenkins corre en Linux/macOS:
                sh './gradlew clean test'

                // Si Jenkins corre en Windows:
                // bat 'gradlew.bat clean test'
            }
        }

        stage('Generate Report') {
            steps {
                publishHTML([
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Report'
                ])
            }
        }
    }

    post {
        always {
            // Cambia a 'build/test-results/test/*.xml' si usas Gradle por defecto
            junit 'build/test-results/test/*.xml'
        }

        failure {
            mail to: 'qa@empresa.com',
                 subject: "Tests Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Revisar el reporte en: ${env.BUILD_URL}"
        }
    }
}

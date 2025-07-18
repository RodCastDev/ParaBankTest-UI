pipeline {
    agent any

    tools {
        jdk 'jdk-11'           // Asegúrate de tener JDK 11 configurado en Jenkins
        gradle 'Gradle-7.6'    // Igual con Gradle (según tu versión en wrapper)
    }

    environment {
        LANG = "en_US.UTF-8"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tu-usuario/tu-repo.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh './gradlew clean test'     // En Windows usa: bat 'gradlew.bat clean test'
            }
        }

        stage('Generate Report') {
            steps {
                // Opcional: copiar o publicar reportes si usas Serenity
                publishHTML([reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Serenity Report'])
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'  // Ajusta si tus reports están en otro lado
        }

        failure {
            mail to: 'qa@empresa.com',
                 subject: "Tests Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Revisar el reporte en ${env.BUILD_URL}"
        }
    }
}

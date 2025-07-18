pipeline {
    agent any

    tools {
        jdk 'jdk-11'
        gradle 'Gradle-7.6'
    }

    environment {
        LANG = "en_US.UTF-8"
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-pat', branch: 'main', url: 'https://github.com/RodCastDev/EncoraTestAutoUI.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'gradlew.bat clean test'   // Usa `sh` si estás en Linux
            }
        }

        stage('Generate Report') {
            steps {
                publishHTML([reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Serenity Report'])
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'
        }

        failure {
            mail to: 'rodrigocastp05@gmail.com',
                 subject: "Tests Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Revisar el reporte en ${env.BUILD_URL}"
        }
    }
}

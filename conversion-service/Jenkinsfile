pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sameerkatta-sys/Measurement-App-BL.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t quantity-measurement-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh '''
                    docker stop quantity-measurement-app || true
                    docker rm quantity-measurement-app || true
                    docker run -d \
                        --name quantity-measurement-app \
                        -p 8080:8080 \
                        quantity-measurement-app
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build and Deploy Successful!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}

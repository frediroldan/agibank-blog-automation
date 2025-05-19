pipeline {
    agent any
    parameters {
        string(name: 'TAGS', defaultValue: '@Regressivo', description: 'Tags a serem executadas')
    }
    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.5'
    }
    environment {
        IS_WINDOWS = "${isUnix() ? 'false' : 'true'}"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://seurepositorio.com/blogdoagi-tests.git', branch: 'main'
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    if (env.IS_WINDOWS == 'true') {
                        bat "mvn clean test verify -Dcucumber.filter.tags=${params.TAGS}"
                    } else {
                        sh "mvn clean test verify -Dcucumber.filter.tags=${params.TAGS}"
                    }
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, results: [[path: 'allure-results']]
            }
        }
        stage('Archive HTML Reports') {
            steps {
                script {
                    def path = env.IS_WINDOWS == 'true' ? 'target\\cucumber-html-reports\\**\\*.*' : 'target/cucumber-html-reports/**/*.*'
                    archiveArtifacts artifacts: path, allowEmptyArchive: true
                }
            }
        }
    }
    post {
        always {
            script {
                def junitPath = env.IS_WINDOWS == 'true' ? '**\\target\\surefire-reports\\*.xml' : '**/target/surefire-reports/*.xml'
                junit junitPath
            }
        }
        success {
            echo '✅ Pipeline finalizada com sucesso!'
        }
        failure {
            echo '❌ Falha na execução da pipeline.'
        }
    }
}

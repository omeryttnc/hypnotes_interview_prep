#pipeline {
#    agent any
#
#    stages {
#        stage('Maven Test') {
#            steps {
#                sh """ cd /applications/hypnotes_qa_test  && git pull && mvn clean test "-Dcucumber.filter.tags=@db" """
#            }
#        }
#    }
#    post {
#        always {
#            emailext attachmentsPattern: '/applications/hypnotes_qa_test/target/reports/html/*.html', body: '', subject: 'smoke report', from: 'yusufbayram19891989@gmail.com', to: 'omeryttnc@gmail.com'
#
#        }
#    }
#}

#docker build -t smoke .
#
#docker run --network host <image-name> <cmd>
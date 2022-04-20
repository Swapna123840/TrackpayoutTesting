pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
               bat "rmdir  /s /q TrackpayoutTesting"
                bat "git clone https://github.com/kishancs2020/TicketBookingServiceJunitTesting.git"
                bat "mvn clean -f TrackpayoutTesting"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f TrackpayoutTesting"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f TrackpayoutTesting"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f TrackpayoutTesting"
            }
        }
    }
}
pipeline {
     tools {
        maven 'LocalMaven' 
        jdk 'LocalJDK8'
    }
    agent any
    stages {
	    stage('J1') {
    	    steps {
    	        git credentialsId: '2bc41755-fb48-4496-b5fa-0c01a99eaa84', url: 'https://github.com/trizbp/Spring3MVC.git'
    	        bat "MiMaven.bat"
    	        archiveArtifacts '**/*.*'
                echo 'J1'
            }
        }
        stage('J2') {
    	    steps {
    	        bat "Quality.bat"
                echo 'J2'
            }
        }
    }
    post { 
        always { 
            echo 'J3'
	    echo "%JOB_NUMBER% %BUILD_NUMBER%"
        }
        success{
            echo 'J4'
    	    deploy adapters: [tomcat8(credentialsId: '2bc41755-fb48-4496-b5fa-0c01a99eaa84', path: '', url: 'http://localhost:8081/webapp')], contextPath: null, war: '**/*.war'
    	    echo 'J5'
    	    deploy adapters: [tomcat8(credentialsId: '2bc41755-fb48-4496-b5fa-0c01a99eaa84', path: '', url: 'http://localhost:8082/webapp')], contextPath: null, war: '**/*.war'
        }
        unstable{
            echo 'J4'
    	    deploy adapters: [tomcat8(credentialsId: '2bc41755-fb48-4496-b5fa-0c01a99eaa84', path: '', url: 'http://localhost:8081/webapp')], contextPath: null, war: '**/*.war'
        }
    }
}

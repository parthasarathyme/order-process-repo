pipeline {
  agent any
  stages {
	stage('Unit Test') {
	   steps {	       
	       echo 'Hello Testing done'
       }
   	}
 	stage('SonarQube'){
       steps{
           bat label: '', script: '''mvn sonar:sonar \
		 -Dsonar.host.url=http://localhost:9000 \
 		-Dsonar.login=e8d0f2641dc2ae321384a89bdd2b4bb01a3df851'''
       }
   }
	stage('Maven Build'){
		steps{
				bat label:'Maven Build of war file', script:'''
					mvn clean install -DskipTests=true
					mvn package
				'''
		}
	}  

    
    
  }
}
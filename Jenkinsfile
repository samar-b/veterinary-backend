pipeline{
    agent any
	
    environment {
    	DOCKERHUB_CREDENTIALS = credentials('dockerhub')
      }

    stages{
	   
	stage('Build easy-ms') {
            steps {
                echo "Getting into easy-ms";
		dir('easy-ms-sdk') {
                     sh 'ls'
		     withEnv(['PATH+MAVEN=/opt/maven/bin']) {
			sh 'mvn clean install -X'
      			  }
                   
                }
              
            }
        }
	    
	    
	stage('Build veterinary-domain') {
            steps {
                echo "Getting into veterinary-domain";
		dir('veterinary-domain') {
                     sh 'ls'
		     withEnv(['PATH+MAVEN=/opt/maven/bin']) {
			sh 'mvn clean install -X'
      			  }
                   
                }
              
            }
        }
	    
	stage('Build config-server') {
            steps {
                echo "Getting into config-server";
		dir('config-server') {
                     sh 'ls'
		     withEnv(['PATH+MAVEN=/opt/maven/bin']) {
			sh 'mvn clean install -X'
      			  }
                   
                }
              
            }
        }
	
	stage('Build veterinary-ms') {
            steps {
                echo "Getting into my-veterinary-ms";
		dir('my-veterinary-ms') {
                     sh 'ls'
		     withEnv(['PATH+MAVEN=/opt/maven/bin']) {
			sh 'mvn clean install -X'
      			  }
                   
                }
              
            }
        }

	  stage('Build Docker Image') {
            steps {
		 dir('my-veterinary-ms') {
			 sh 'docker build -t samarbelhadj/vetpipe:1.0 .'
			 sh ''
                }
            }
        }   
	    
	   stage('Push docker image') {
    	  steps {
      		  sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
		  sh 'docker push samarbelhadj/vetpipe:1.0'
     		 }
  	  }
	   

    }
  
	    
	    
 	 post {
 	   always {
  	    sh 'docker logout'
 	   }
	  }
	    
	    
	    
        
    

     
	        /*    stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-soonar',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.projectKey=org.springframework.boot \
                        -D sonar.host.url=http://192.168.1.20:9000  \
                        -D sonar.login=admin \
                        -D sonar.password=sonar \
                    """
                }
                    
            }
                
        }

        stage('Build'){
            steps {
                sh 'mvn clean package -DskipTests '
            }
        }   

       
        
  
        stage('Docker image'){
            steps {
                 sh 'docker build -t khoukha/devopsinternship .'
            }
        }

        stage('Docker Hub'){
            steps {
                withCredentials([string(credentialsId: 'dockerhubId', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u khoukha -p ${dockerhubpwd}'
                    sh 'docker push khoukha/devopsinternship'
                }
            }
        }   */
      
   



	    
    }
	    
  
	    
	    

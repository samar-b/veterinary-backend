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
			 sh 'sudo chmod 666 /var/run/docker.sock'
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
	    
	    
	    
        
    

    



	    
    }

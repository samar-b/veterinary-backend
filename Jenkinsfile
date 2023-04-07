pipeline{
    agent any
	
    environment {
    	DOCKERHUB_CREDENTIALS = credentials('dockerhub')
      }

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo "Getting Project from GitHub";
                git branch: 'samar', url: 'https://github.com/samar-b/veterinary-backend.git'
            }
        }
	   
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
			 sh 'docker version'
			 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                     
                   
                }
              
              
            }
        }       
	   
	    
	    
	    
	    
        
    
	  /*  stage('Build') {
      steps {
        withEnv(['PATH+MAVEN=/path/to/maven/bin']) {
          sh 'mvn --version'
        }
      }
    }
	    
	    
	      stage('version'){
            steps {
		echo "maven version";
		echo "$MAVEN_HOME" ;
	        sh 'mvn -version'
		 
                
            }
        }*/
     
       /* stage('Build'){
            steps {
		echo "building easy-ms";
		dir('easy-ms-sdk') {
                    sh 'ls'
		     sh 'echo $MAVEN_HOME'
	            sh 'mvn -version'
		    sh 'echo $MAVEN_HOME'
		    sh 'mvn clean install -DskipTests'
                   
                }
                
            }
        }*/
        

     
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




	    
    }
	    
  
	    
	    

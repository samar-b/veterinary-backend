pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo "Getting Project from GitHub";
                git branch: 'master', credentialsId: 'GitFlowCredential', url: 'https://github.com/khaoulaBouslimi/DevOps-Internship-Git-Floww.git'
            }
        }
    
     
        stage('Clean'){
            steps {
                sh 'mvn clean -DskipTests'
            }
        }
         stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests '  
            }
        }

     /*
	            stage('SonarQube Analysis'){
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
                
        }*/

        stage('Build'){
            steps {
                sh 'mvn clean package -DskipTests '
            }
        }   

       /*
        
  
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
	    
  
	    
	    

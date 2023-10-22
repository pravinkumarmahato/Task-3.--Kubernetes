# Task-3.-Kubernetes
In this we have used Docker Desktop, minikube, and kubectl

## Task Description
Use the application that you created in task #1 or task #2. Create dockerfiles and build docker images. Create kubernetes yaml manifests for the application (at least a deployment and a service). It’s ok to expose the application with a LoadBalancer or NodePort service or with an ingress. Spin up a single-node local Kubernetes cluster (Docker Desktop, Kind or Minikube) or use a managed cluster like EKS, AKS, GKE etc. Deploy MongoDB to the cluster (it’s ok to use a community helm chart for this, any other approach is fine as well). Then deploy the application to the cluster by applying your manifests. The following requirements should be fulfilled:

● you can bring your application up by applying your yaml manifests

● mongodb is running in a separate pod

● the application should take mongo connection details from the environment variables

● the app endpoints should be available from your host machine

● a persistent volume should be used to store the MongoDB data. I.e., when you delete the MongoDB pod the records in the db should not disappear.

## Steps involve in the task
### Step-1:
  Install Docker Desktop
  
  Install minikube
  
  Install kubectl
  
  Create a Spring Boot Application
  
### Step-2:
  Build a .jar package file of the application
  
### Step-3:
  Create a Dockerfile and include following in that
    
    FROM openjdk:17
    EXPOSE 8080
    ADD target/springboot-api-images.jar springboot-api-images.jar
    ENTRYPOINT ["java", "-jar", "/springboot-api-images.jar"]
    
### Step-4:
  run Docker
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/1193823e-c753-42d9-9a9c-2408eee13439)

  run minikube in the docker
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/10e901c8-5b38-4f18-b277-2e6653a43a35)
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/b18edcd0-2a8e-411c-b94b-a942f88b31b0)

### Step-5:
  Pull Docker Image of mongodb from dockerhub
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/9ef31806-35fb-4499-892f-66ec28b6b85b)

  Create Docker Image of the Spring boot application
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/d4667ca6-d730-4499-83a8-3e5b88789240)
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/e1799d91-5971-42d9-9e07-cf4a0a17dbc2)

### Step-6:
  Create mongodb-secret.yaml, and mongodb-configMap.yaml which have mongo db credentials and deploy it on minikube

  
  Create mongodb-deployment.yaml, mongodb-services.yaml, mongodb-pvc.yaml and deploy it to configure mongodb
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/400deb11-b9bc-444a-a5e0-d2e8c6274f4f)

  Create springboot-deployment.yaml and springboot-services.yaml to deploy the springboot application
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/f980105e-b583-4799-a5a6-e5c80176f57c)

### Step-7:
  Now the pods are deployed and up we can make it up and down using commands or by using minikube dashbord
  And if we delete any pod it will automatically create another pod
  ![image](https://github.com/pravinkumarmahato/Task-3.--Kubernetes/assets/68019573/740f668b-e694-425b-b405-5005ef1f4d89)



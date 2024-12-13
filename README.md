# ingest-into-Neo4j

## Fetch Data from AWS IAM User and Ingest into Neo4j
### 1. Download and Configure AWS CLI: Use the command prompt on Windows to configure the IAM user with AWS CLI.
#### " Command: aws configure --profile rupesh12 "
#### After configuration, verify if it has been set up correctly.

![image](https://github.com/user-attachments/assets/d3444564-8bda-4a99-97dc-1d89a782aab5)
### 2. Download Docker, Pull the Neo4j Image, and Create a Container
#### Start the Container: Use the command "docker start 7a4998804043".
#### Access the Container: Use the command "docker exec -it 7a4998804043 bash" to interact with the Neo4j container.
![1](https://github.com/user-attachments/assets/2bea9a1a-9a41-47ef-8608-eb1882988f3a)
![2](https://github.com/user-attachments/assets/e7bba9af-7d7c-447f-afa1-2dbd2f23f0b7)
### 3. create IAM user on AWS 
![image](https://github.com/user-attachments/assets/01240c09-854a-432f-b274-791795b291b1)
### 4. Run the main.java File in IntelliJ IDEA
#### Execute the main.java file in IntelliJ IDEA, and observe the output as shown below:
![5](https://github.com/user-attachments/assets/c564f697-51e2-4b2e-82fb-04331875d8b0)
### Reflect Changes in the Neo4j Database
#### After running the program, the unique users will be displayed in the Neo4j database.
![new](https://github.com/user-attachments/assets/d0b39d53-fbbf-4596-a367-00e93941e7db)





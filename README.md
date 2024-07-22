# HEALTHQ

## Project Snapshots

<p>
  <img src="https://github.com/user-attachments/assets/b9a6edd8-dc62-4f42-82b1-6c1249e6a82b" width="45%" />
  <img src="https://github.com/user-attachments/assets/eb42f9c2-9c67-41fb-953e-1f954ad44ff4" width="45%" />
  <img src="https://github.com/user-attachments/assets/d4db8534-7fed-437c-afa8-9b1e15294959" width="45%" />
  <img src="https://github.com/user-attachments/assets/4e5bdbb3-6788-484a-9d9e-86d8990b7827" width="45%" />
</p>

## Project Description
HealthQ is an advanced patient appointment booking system designed to streamline healthcare services. Patients can effortlessly book appointments at any hospital, ensuring convenience and accessibility. The application also empowers administrators with robust management capabilities, enabling them to create, update, and delete hospitals, plans, tests, and other related entities. HealthQ aims to enhance the efficiency of healthcare operations, providing a seamless experience for both patients and healthcare providers.

## Getting Started

### Step 1: Clone the Repository
First, clone the repository to your local machine using the following command:
```bash
git clone https://github.com/Debarshi-Gupta/healthq.git
cd HealthQ
```

### Step 2: Install Maven
Ensure you have Maven installed. You can download Maven from the official website and follow the installation instructions for your operating system.
To verify Maven installation, run:
```bash
mvn -version
```

### Step 3: Build the Project
Navigate to the root directory of the project and run the following command to build the project:
```bash
mvn clean install
```

### Step 4: Set Up the MYSQL Database
Open your MySQL client and create a new database named testdb:
```bash
CREATE DATABASE testdb;
```

### Step 5: Update Database Credentials
Open the src/main/resources/application.properties file and update the database credentials to match your MySQL configuration:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Step 6: Run the Application
Start all the Spring Boot Microservices with the below command. Start the Discovery Service first before starting the other services.
```bash
mvn spring-boot:run
```

### Step 7: Install Node Modules
Navigate to the webapp folder, open Command Prompt/Powershell and run the below command:
```bash
npm install
```

### Step 8: Run the Web Application
Navigate to the webapp folder, open Command Prompt/Powershell and run the below command:
```bash
ng serve
```

### Step 9: Access the Application
Open your web browser and navigate to:
```bash
http://localhost:4200
```

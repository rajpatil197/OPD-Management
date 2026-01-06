OPD Management System

The OPD Management System is a lightweight and efficient application designed to streamline outpatient department operations in hospitals, clinics, and healthcare centers. It digitizes patient records, automates appointment scheduling, and simplifies doctor–patient interaction—reducing manual workload and improving overall service quality.

**Features**

Patient Registration & Profile Management
Store and manage patient demographics, medical history, and visit records.

Appointment Scheduling
Create, reschedule, or cancel appointments with real-time availability tracking.

Doctor Management
Add doctors, assign departments, set availability, and manage consultation records.

OPD Case & Prescription Handling
Record patient diagnoses, prescriptions, treatment notes, and follow-up instructions.

Billing & Payment Tracking (optional)
Generate invoices, track payments, and maintain financial logs.

Dashboard & Reports
View patient statistics, appointment summaries, and daily/weekly activity reports.

Search & Filtering
Quickly find patient records, doctors, visits, or prescriptions.

User Roles & Authentication , Authorization of Roles
 Doctor, receptionist, and other role-based access controls.

 **Tech Stack**
Frontend (Angular 16)

Angular CLI

TypeScript

Bootstrap / Angular Material

RxJS & Angular Services

Backend (Spring Boot)

Java 21+

Spring Boot

Spring Security (JWT Authentication)

Hibernate / JPA

MySQL Database

##Purpose##

This system aims to modernize OPD workflows by eliminating paperwork, improving record accuracy, and enabling healthcare professionals to deliver faster, more reliable patient care.

** Getting Started
** Backend Setup (Spring Boot)

Navigate to the backend folder:

cd opd-management-system/backend


Update your database configuration inside application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/opd_db // add user database name
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Run the backend:

1)mvn spring-boot:run
2)Import project in Eclipse or Intellji then Update Maven and Run .

Backend runs at: http://localhost:8080
## Frontend Setup (Angular 16)

Navigate to the frontend folder:

cd opd-management-system/frontend


Install dependencies:

npm install


Run Angular:

ng serve


Frontend runs at: http://localhost:4200

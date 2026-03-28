# 📌 Digital Notes Organizer REST API

🚀 A backend project built using **Spring Boot** to manage and organize notes efficiently using folders and tags.

---

## 📖 Project Overview

The **Digital Notes Organizer REST API** allows users to:
- Create and manage notes
- Organize notes into folders
- Categorize notes using tags
- Search and filter notes
- Securely register and login users

All operations are performed via **REST APIs** and tested using **Postman**.

---

## 🎯 Features

- 👤 User Registration & Login (BCrypt secured)
- 📝 Create, Read, Update, Delete Notes
- 📂 Folder-based organization
- 🏷️ Tag-based categorization (Many-to-Many)
- ⭐ Mark notes as important
- 🔍 Search notes (title & content)
- 📌 Filter important notes
- 👥 Get notes by user

---

## 🏗️ Architecture

This project follows **Layered Architecture**:


Controller → Service → Repository → Database


- **Controller** → Handles API requests
- **Service** → Business logic
- **Repository** → Database operations
- **Entity** → Database structure

---

## 🧠 Entity Relationships

- One User → Many Notes  
- One Folder → Many Notes  
- Many Notes ↔ Many Tags  

✔ Implemented using:
- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany` (with `note_tags` table)

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot  
- **Language**: Java  
- **Database**: MySQL  
- **ORM**: Hibernate (JPA)  
- **Security**: BCrypt Password Encoding  
- **Build Tool**: Maven  
- **Testing Tool**: Postman  
- **IDE**: IntelliJ IDEA  

---

## ⚙️ Setup Instructions

### 🔹 1. Clone Repository
```bash
git clone https://github.com/Hardik-Bhochiya/digital-notes-api.git
cd digital-notes-api
🔹 2. Open in IntelliJ
Open IntelliJ IDEA
Click Open Project
Select project folder
🔹 3. Setup MySQL Database
CREATE DATABASE notes_db;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/notes_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔹 4. Run Application

Run:

NotesapiApplication.java

Server starts at:

http://localhost:8080
📮 API Endpoints
👤 User APIs
POST /users → Register
POST /users/login → Login
📝 Notes APIs
POST /notes → Create Note
GET /notes → Get All Notes
GET /notes/search?keyword=... → Search Notes
GET /notes/important → Important Notes
GET /notes/user/{id} → Notes by User
📂 Folder APIs
POST /folders → Create Folder
GET /folders → Get All Folders
🏷️ Tag APIs
POST /tags → Create Tag
GET /tags → Get All Tags
🔐 Security
Passwords are encrypted using BCryptPasswordEncoder
Password is hidden in response using:
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
🧪 Testing
All APIs tested using Postman
JSON-based request/response
📊 Database Tables
users
notes
folders
tags
note_tags
🔥 Key Concepts Used
REST API Development
Layered Architecture
Hibernate & JPA
Entity Relationships
Many-to-Many Mapping
Password Encryption
JSON Serialization
🚀 Future Improvements
JWT Authentication
Pagination & Sorting
File/Image Upload
Note Sharing

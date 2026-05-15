# 🎓 Student CRUD Console Application

A simple console-based Student Management System built using Java, JDBC, and SQLite.

The application allows users to perform CRUD operations (Create, Read, Update, Delete) on student records through a console menu interface.

---

# 🚀 Features

- ➕ Insert new student
- 🔍 Search student by ID
- 📋 Show all students
- ✏️ Update student GPA
- ❌ Delete student
- 🗄️ SQLite database integration
- 📚 JavaDoc documentation included
- 💻 Console-based user interface

---

# 🛠️ Technologies Used

- Java
- JDBC
- SQLite
- IntelliJ IDEA

---

# 🏗️ Project Structure

```text
src/
│
├── application/
│   └── Main.java
│
├── ui/
│   └── MainConsoleUi.java
│
├── model/
│   └── Student.java
│
├── databaseAccess/
│   ├── DBConnection.java
│   └── StudentDAO.java
│
└── doc/
    └── JavaDoc files
```

---

# 🗄️ Database Schema

## students table

| Column | Type    |
|--------|---------|
| id     | INTEGER |
| name   | TEXT    |
| gpa    | REAL    |

---

# ▶️ How to Run

## Run using IntelliJ IDEA

Run:

```text
Main.java
```

---

## Run using JAR file

```bash
java -jar students_CRUD.jar
```

---

# 📸 Screenshots

## Main Menu
<img src="https://github.com/mostafahh1/simple-students_CRUD/blob/master/screenshot/Menu.png" alt="img" width="400"/>&nbsp;

---

## Insert Student

<img src="https://github.com/mostafahh1/simple-students_CRUD/blob/master/screenshot/Insert.png" alt="img" width="400"/>&nbsp;

---

## Show All Students

<img src="https://github.com/mostafahh1/simple-students_CRUD/blob/master/screenshot/Show.png" alt="img" width="400"/>&nbsp;

---

# 📚 JavaDoc

JavaDoc documentation is included inside the `doc/` folder.

Open:

```text
doc/index.html
```

in your browser.

---

# 🧠 Concepts Used

- Object-Oriented Programming (OOP)
- DAO Pattern
- CRUD Operations
- JDBC
- SQLite Database
- JavaDoc Documentation

---

# 👨‍💻 Author

Created by M H

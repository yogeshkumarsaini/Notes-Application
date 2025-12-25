# 📝 Notes Application in Java

A simple console-based **Notes Application** built using Java that supports **CRUD operations**, **file storage**, **timestamps**, and **keyword search**. This project is perfect for beginners who want to learn core Java concepts including OOP, ArrayList, File Handling, and LocalDateTime.

---

## 🚀 Features

| Feature | Description |
|--------|-------------|
| Add Note | Create a new note with timestamp |
| View Notes | Display all saved notes |
| Update Note | Modify the content of an existing note |
| Delete Note | Remove a note by ID |
| Search Notes | Find notes by keyword |
| Persistent Storage | Notes auto-save in a file (`notes.txt`) |

---

## 📁 Project Structure

```
src/
├── Note.java
└── NotesApp.java
notes.txt (auto-generated)
```

---

## 🧠 Concepts Used
- Classes & Objects
- Constructors
- ArrayList
- File Handling (read/write)
- LocalDateTime & Formatting
- Loops & Conditionals

---

## ▶️ How to Run

### Compile:
```sh
javac Note.java NotesApp.java
```
### Run:
```sh
java NotesApp
```
A notes.txt file will be automatically created to store notes.

---

## 🔍 Sample File Storage Format
```ruby
1::Buy groceries::25-12-2025 19:20:45
2::Finish Java project::25-12-2025 19:25:10
```

## 🏗 Future Improvements 

1. Encrypt file for security 🔐

2. Add categories/labels for notes 🏷

3. Mark notes as completed ☑️

4. GUI using JavaFX/Swing 🎨

5. REST API using Spring Boot 🌐

6. Store notes in a database instead of text file 🗄️

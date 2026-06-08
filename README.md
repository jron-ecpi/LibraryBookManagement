# LibraryBookManagement
Advanced Java Scripting Project
### Project Overview

The Library Book Management System is a Java-based console application designed to help users manage a small library collection. The application allows users to add books, remove books, search for books, update book availability, and display all books stored in the system. Data is saved to a text file so that information persists between program executions. The project was developed using object-oriented programming principles and demonstrates many of the advanced Java concepts covered throughout the course. The application provides a menu-driven interface that allows users to interact with the system through the terminal.

**Project Components**
Book Class

The Book class represents an individual book in the library. Each book contains the following information:
- Title
- Author
- Genre
- Book ID
- Availability Status

The class uses private instance variables and public getter and setter methods to support encapsulation. The toString() method formats book information for display within the application.

Library Class

The Library class manages all Book objects stored in the system. It contains an ArrayList collection and provides methods to:
- Add books
- Remove books
- Search for books
- Display all books
- Display available books
- Update availability status

This class serves as the primary business logic component of the application: FileManager Class

The FileManager class handles all file input and output operations. It is responsible for:
- Saving book data to a text file
- Loading book data when the application starts
- Preserving information between program executions

Separating file operations into a dedicated class supports abstraction and improves maintainability.

**Main/App Class**
The Main (App) class provides the user interface and controls program execution. It displays menus, collects user input, and communicates with the Library and FileManager classes.

### What Went Well

Several aspects of the project were successful:
- The object-oriented design worked well and made the application easy to organize.
- Separating responsibilities among classes improved readability and maintainability.
- The use of ArrayLists allowed flexible management of book records.
- File handling successfully preserved data between sessions.
- The menu-driven interface provided a simple and user-friendly experience.
- Encapsulation helped protect object data and maintain consistency throughout the application.

### Challenges Encountered

Several challenges were encountered during development:
- Designing the file storage format required careful planning to ensure records could be saved and loaded correctly.
- Exception handling was necessary to prevent application crashes caused by invalid user input.
- Searching and updating records required additional validation logic.
- Maintaining data consistency between memory and the text file required careful testing.
- Testing multiple user scenarios took additional time to ensure all features worked properly.
- How the Project Satisfies the Requirements

The project successfully satisfies all requirements outlined in the project description.

Menu-Driven Application
The application provides a terminal-based menu system that allows users to select various library management operations.
Object-Oriented Programming
The application uses classes and objects to represent books, library operations, file management, and user interaction.
Data Persistence
Book information is stored in a text file named libraryData.txt and is automatically loaded when the application starts.

**User Functions**

Users can:

- Add books
- Remove books
- Search for books
- Display all books
- Display available books
- Update availability status

Error Handling

The application uses exception handling to prevent crashes and improve reliability.

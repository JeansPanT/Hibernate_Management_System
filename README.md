# Student Management System using Hibernate

This is a Java-based application for managing student data, utilizing Hibernate ORM for database interactions. It is structured as a Maven project, allowing for efficient dependency management and build processes. The project provides functionality to store, retrieve, and manage student information.

## Features

- **Add New Students**: Store student details in a relational database.
- **Update Student Information**: Modify existing student data as needed.
- **Delete Student Records**: Remove student entries from the system.
- **Retrieve Student Details**: View stored student information.

## Project Structure

```
Student_Management_System/
├── .classpath
├── .project
├── pom.xml                       # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/siddharth/
│   │   │   │   ├── App.java       # Main application logic
│   │   │   │   └── Student.java   # Student entity/model
│   │   └── resources/
│   │       └── hibernate.cfg.xml  # Hibernate configuration file
│   └── test/
│       └── java/
│           └── com/siddharth/
│               └── AppTest.java   # Unit tests for application
└── target/
    └── classes/                   # Compiled classes
```

## Prerequisites

To run this project, you need:

- **Java 8** or higher
- **Maven 3.6** or higher
- A **relational database** (MySQL, PostgreSQL, etc.)
- **Hibernate** configured via `hibernate.cfg.xml`

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd Student_Management_System
   ```

2. **Configure Database**:
   - Update `hibernate.cfg.xml` with your database credentials and URL.

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.siddharth.App"
   ```

## Running Tests

Execute the following command to run the unit tests:

```bash
mvn test
```

## Dependencies

- **Hibernate ORM**: For managing database interactions.
- **JUnit**: For unit testing.

## Contributing

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a description of your changes.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please contact the project maintainer at [siddhukar39@gmail.com].

---

Let me know if you'd like any additional details or customization for specific sections!

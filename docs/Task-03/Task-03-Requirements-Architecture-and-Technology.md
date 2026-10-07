# Task 3: Requirements, Architecture and Technology Setup

## 1. System Requirements Specification — Summary

### 1.1 System Name

**Recipe Management System**

### 1.2 Purpose

The Recipe Management System is a web-based application designed to provide a centralized platform for managing recipes. The system allows users to create, view, update and search recipes while administrators can manage recipe status and monitor recipe statistics.

The system will also serve as the application used to demonstrate the complete DevOps lifecycle, including source control, continuous integration, automated testing, containerization, deployment, configuration management and recovery.

---

# 2. Functional Requirements

## FR-01 — User Authentication

The system shall allow users to authenticate using their credentials.

## FR-02 — Role Management

The system shall support at least two roles:

- USER
- ADMIN

## FR-03 — Create Recipe

An authorized user shall be able to create a recipe containing:

- Recipe name
- Description
- Ingredients
- Instructions
- Category

A newly created recipe shall have the status:

**DRAFT**

## FR-04 — View Recipe

Users shall be able to view:

- Recipe name
- Description
- Ingredients
- Instructions
- Category
- Status
- Creator

## FR-05 — Update Recipe

Authorized users shall be able to update recipe information.

## FR-06 — Search Recipe

Users shall be able to search recipes by:

- Name
- Category

## FR-07 — Recipe Status Workflow

The system shall implement:

```text
DRAFT → SUBMITTED → APPROVED → PUBLISHED
```

Only authorized users shall be allowed to perform administrative status changes.

## FR-08 — Dashboard

The system shall provide a dashboard showing:

- Total recipes
- Draft recipes
- Submitted recipes
- Approved recipes
- Published recipes

## FR-09 — Validation

The system shall validate required fields and reject invalid input.

## FR-10 — Health Check

The application shall expose a health endpoint that can be used by deployment automation to verify that the application is running.

---

# 3. Non-Functional Requirements

## NFR-01 — Performance

Normal user requests should receive a response within a reasonable time in the local deployment environment.

## NFR-02 — Reliability

The application should start successfully after deployment and provide a working health check.

## NFR-03 — Maintainability

The application shall follow a layered architecture to make the code easier to maintain.

## NFR-04 — Testability

Core user journeys shall be testable using Selenium WebDriver.

## NFR-05 — Portability

The application shall be containerized using Docker so that it can run consistently across supported environments.

## NFR-06 — Automation

Build, testing and deployment activities should be automated using Jenkins.

## NFR-07 — Configuration Management

Deployment prerequisites and configuration shall be automated using Ansible.

---

# 4. Use Cases

## Actors

The system has two primary actors:

### USER

Can:

- Login
- Create recipe
- View recipe
- Update recipe
- Search recipes
- Submit recipe

### ADMIN

Can:

- Login
- View recipes
- Search recipes
- Update recipes
- Approve recipes
- Publish recipes
- View dashboard

---

## 4.1 Use-Case Diagram

```text
                         RECIPE MANAGEMENT SYSTEM
                    ┌─────────────────────────────────┐
                    │                                 │
                    │     Login                       │
                    │       │                         │
                    │       ▼                         │
                    │   ┌─────────┐                   │
                    │   │Dashboard│                   │
                    │   └─────────┘                   │
                    │                                 │
                    │  Create Recipe                   │
                    │       │                         │
                    │       ▼                         │
                    │   View Recipe                    │
                    │                                 │
                    │  Update Recipe                   │
                    │                                 │
                    │  Search Recipe                   │
                    │                                 │
                    │  Submit Recipe                   │
                    │                                 │
                    │  Manage Status                  │
                    │                                 │
                    └─────────────────────────────────┘
                         ▲                    ▲
                         │                    │
                       USER                 ADMIN
```

### Use-Case Mapping

| Use Case | USER | ADMIN |
|---|---:|---:|
| Login | ✓ | ✓ |
| Create Recipe | ✓ | ✓ |
| View Recipe | ✓ | ✓ |
| Update Recipe | ✓ | ✓ |
| Search Recipe | ✓ | ✓ |
| Submit Recipe | ✓ | ✓ |
| Approve Recipe | — | ✓ |
| Publish Recipe | — | ✓ |
| View Dashboard | — | ✓ |
| Manage Status | — | ✓ |

---

# 5. Application Architecture

The application will use a layered Spring Boot architecture.

```text
┌─────────────────────────────────────┐
│             Browser                 │
│       HTML / CSS / Thymeleaf        │
└──────────────────┬──────────────────┘
                   │ HTTP
                   ▼
┌─────────────────────────────────────┐
│        Controller Layer              │
│  RecipeController                   │
│  DashboardController                │
│  AuthController                     │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│          Service Layer              │
│  RecipeService                      │
│  DashboardService                   │
│  AuthenticationService              │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│        Repository Layer             │
│       RecipeRepository              │
│       UserRepository                │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│            H2 Database              │
│                                     │
│ Users                               │
│ Recipes                             │
└─────────────────────────────────────┘
```

---

# 6. DevOps Architecture

The application will be integrated with the following DevOps infrastructure:

```text
                   ┌──────────────┐
                   │   Developer  │
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │    Git       │
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │   GitHub     │
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │   Jenkins    │
                   └──────┬───────┘
                          │
               ┌──────────┴──────────┐
               ▼                     ▼
        ┌─────────────┐       ┌─────────────┐
        │ Maven Build │       │   Selenium  │
        └──────┬──────┘       └──────┬──────┘
               │                     │
               └──────────┬──────────┘
                          │
                          ▼
                   ┌──────────────┐
                   │ Docker Image │
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │ Docker       │
                   │ Container    │
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │   Ansible    │
                   │ Configuration│
                   └──────┬───────┘
                          │
                          ▼
                   ┌──────────────┐
                   │ Target       │
                   │ Environment  │
                   └──────────────┘
```

---

# 7. Technology Stack

| Component | Technology | Purpose |
|---|---|---|
| Programming Language | Java | Application development |
| Framework | Spring Boot | Web application framework |
| Build Tool | Maven | Build and dependency management |
| Frontend | Thymeleaf + HTML/CSS | User interface |
| Database | H2 | Lightweight MVP database |
| ORM | Spring Data JPA / Hibernate | Database access |
| Testing | JUnit | Application-level testing |
| UI Testing | Selenium WebDriver | Automated browser testing |
| Version Control | Git | Source-code management |
| Repository | GitHub | Remote source-code hosting |
| CI/CD | Jenkins | Automated build and deployment |
| Containerization | Docker | Application packaging |
| Configuration Management | Ansible | Environment automation |
| Operating System | Ubuntu/Linux | Target deployment environment |
| IDE | Visual Studio Code / IntelliJ IDEA | Development |
| Browser | Google Chrome | Selenium execution |

---

# 8. Database Design

The MVP will use an H2 relational database.

## 8.1 User Table

| Field | Type | Description |
|---|---|---|
| id | Long | Primary key |
| username | String | Unique username |
| password | String | User password |
| role | String | USER or ADMIN |

## 8.2 Recipe Table

| Field | Type | Description |
|---|---|---|
| id | Long | Primary key |
| name | String | Recipe name |
| description | String | Recipe description |
| ingredients | Text | Ingredients |
| instructions | Text | Preparation instructions |
| category | String | Recipe category |
| status | String | Current recipe status |
| createdBy | Long | User who created recipe |
| createdAt | DateTime | Creation timestamp |
| updatedAt | DateTime | Last update timestamp |

---

# 9. Entity Relationship Model

```text
┌──────────────────────┐
│        USER          │
├──────────────────────┤
│ id (PK)              │
│ username             │
│ password             │
│ role                 │
└──────────┬───────────┘
           │
           │ 1
           │
           │ creates
           │
           │ *
┌──────────▼───────────┐
│       RECIPE         │
├──────────────────────┤
│ id (PK)              │
│ name                 │
│ description          │
│ ingredients          │
│ instructions         │
│ category             │
│ status               │
│ createdBy (FK)       │
│ createdAt            │
│ updatedAt            │
└──────────────────────┘
```

---

# 10. API / Endpoint List

The application will expose the following logical endpoints.

## Authentication

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/login` | Display login page |
| POST | `/login` | Authenticate user |
| GET | `/logout` | Logout |

## Recipes

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/recipes` | Display all recipes |
| GET | `/recipes/new` | Display recipe creation form |
| POST | `/recipes` | Create recipe |
| GET | `/recipes/{id}` | View recipe |
| GET | `/recipes/{id}/edit` | Display edit form |
| POST | `/recipes/{id}/update` | Update recipe |
| GET | `/recipes/search` | Search recipes |

## Workflow

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/recipes/{id}/submit` | Submit recipe |
| POST | `/recipes/{id}/approve` | Approve recipe |
| POST | `/recipes/{id}/publish` | Publish recipe |

## Dashboard

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/dashboard` | Display dashboard |

## Health

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/actuator/health` | Application health check |

---

# 11. Project Folder Structure

The planned project structure is:

```text
recipe-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/recipe/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       ├── config/
│   │   │       └── RecipeApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   │
│   └── test/
│
├── selenium/
│
├── ansible/
│
├── docs/
│   ├── task-01/
│   ├── task-02/
│   └── task-03/
│
├── screenshots/
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── README.md
└── .gitignore
```

---

# 12. Local Development Setup

## Required Software

The development machine should have:

- JDK 17 or later
- Maven 3.9+
- Git
- Docker
- Visual Studio Code or IntelliJ IDEA
- Google Chrome
- ChromeDriver/Selenium Manager
- Jenkins
- Ansible
- Ubuntu/Linux environment for infrastructure tasks

For the initial application development, only Java, Maven and Git are required.

Docker, Jenkins and Ansible will be configured in later tasks.

---

# 13. Initial Application Configuration

The application will initially run on:

```text
http://localhost:8080
```

The H2 database will be used during development.

The application will use:

```text
server.port=8080
```

The H2 console may be enabled during development for database inspection.

The application will later be packaged as a JAR and executed inside a Docker container.

---

# 14. Deployment Strategy

The application will follow this deployment model:

```text
Developer
    ↓
GitHub
    ↓
Jenkins
    ↓
Maven Build
    ↓
Automated Tests
    ↓
Docker Image
    ↓
Docker Registry
    ↓
Target Server
    ↓
Docker Container
    ↓
Health Check
```

Ansible will configure the target environment and ensure required packages, directories, services and configuration are present.

---

# 15. Environment Configuration

At least one deployment environment setting will be parameterized.

Example:

```text
APPLICATION_PORT=8080
```

The application will avoid hard-coding deployment-specific configuration wherever practical.

The same application image should be capable of running in different environments with appropriate environment variables.

---

# 16. Security Considerations

For the academic MVP:

- User authentication will be implemented.
- Role-based access will restrict administrative operations.
- Passwords should not be stored as plain text in the final implementation.
- Administrative endpoints will require appropriate authorization.
- Sensitive configuration should be provided through environment variables where practical.

Advanced enterprise security mechanisms are outside the initial MVP scope.

---

# 17. Technology Selection Rationale

### Java + Spring Boot

Spring Boot provides a well-structured framework for developing web applications and integrates naturally with Maven, Jenkins and Docker.

### Maven

Maven provides standardized dependency management, compilation, testing and packaging and integrates directly with Jenkins.

### H2

H2 is lightweight and requires minimal configuration, making it suitable for the academic MVP.

### Thymeleaf

Thymeleaf allows the application to provide a server-rendered web interface without introducing the additional complexity of a separate frontend application.

### Selenium

Selenium WebDriver provides browser-based automated testing for critical user journeys.

### Jenkins

Jenkins provides continuous integration and continuous delivery capabilities.

### Docker

Docker packages the application and its runtime requirements into a consistent deployment unit.

### Ansible

Ansible provides repeatable, automated and idempotent configuration management.

---

# 18. Architecture Decision

The project will use a **monolithic layered architecture** rather than microservices.

This decision is intentional because the project is an academic MVP and the primary objective is to demonstrate DevOps practices rather than distributed-system complexity.

The architecture can be extended in the future if the system needs to support larger scale or multiple independent services.

---

# 19. Task 3 Completion Criteria

Task 3 is complete when:

- SRS summary is documented.
- Functional requirements are defined.
- Non-functional requirements are defined.
- Use cases are identified.
- Architecture is documented.
- Database model is defined.
- API/endpoint list is defined.
- Technology stack is selected.
- Project structure is defined.
- Local development requirements are documented.

The next task will establish the GitHub repository and source-control workflow.
# Recipe Management System

A web-based Recipe Management System developed as an academic DevOps project.

The project demonstrates the complete software development and DevOps lifecycle, including Agile planning, Git/GitHub, Jenkins CI/CD, Selenium automated testing, Docker containerization, Ansible configuration management, automated provisioning, health checks and rollback/recovery.

## Features

- User authentication
- Role-based access
- Create recipes
- View recipes
- Update recipes
- Search recipes
- Recipe status workflow
- Administrative dashboard
- Automated Selenium testing
- Jenkins CI/CD
- Docker containerization
- Ansible configuration management
- Health checks and recovery

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Application development |
| Spring Boot | Backend/web framework |
| Maven | Build and dependency management |
| Thymeleaf | Web interface |
| H2 | Database |
| Git | Version control |
| GitHub | Source-code repository |
| Jenkins | CI/CD |
| Selenium | Automated UI testing |
| Docker | Containerization |
| Ansible | Configuration management |

## Recipe Status Workflow

```text
DRAFT → SUBMITTED → APPROVED → PUBLISHED
```

## Project Architecture

The application follows a layered monolithic architecture:

```text
Browser
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
H2 Database
```

## DevOps Workflow

```text
Git
 ↓
GitHub
 ↓
Jenkins
 ↓
Maven Build
 ↓
Automated Tests
 ↓
Docker
 ↓
Deployment
 ↓
Ansible
 ↓
Health Check
```

## Project Documentation

| Task | Documentation |
|---|---|
| Task 1 | Problem Definition and Scope |
| Task 2 | Agile Planning and DevOps Workflow |
| Task 3 | Requirements, Architecture and Technology |
| Task 4 | Git and GitHub Repository Initialization |

## Project Status

Currently establishing the Git/GitHub repository and development workflow.

The application will be implemented incrementally through feature branches and pull requests.
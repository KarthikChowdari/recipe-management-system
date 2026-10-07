# Task 1: Problem Definition and Scope

## 1. Project Title

**Selenium Testing for a Recipe Management System**

## 2. Problem Statement

Managing recipes manually through notebooks, documents, spreadsheets, or unstructured web pages makes it difficult to organize, search, update, and track recipes efficiently. Users need a centralized system where recipes can be stored and accessed easily, while authorized users can update their status through a controlled workflow.

The proposed Recipe Management System is a web-based application that provides a centralized platform for creating, viewing, updating, searching, and managing recipes. The system will also provide role-based access and a dashboard showing an overview of recipe statuses.

From a DevOps perspective, the project will demonstrate the complete software delivery lifecycle, including source-code management, continuous integration, automated Selenium testing, containerization, continuous deployment, configuration management, provisioning, health checking, and rollback/recovery.

The system will initially target a small-scale MVP suitable for demonstration and academic evaluation rather than a production-scale recipe platform.

---

## 3. Target Users

### 3.1 Recipe User

A normal user can:

- View available recipes
- Search for recipes
- View recipe details
- Create recipes
- Update recipes created by them
- Track the status of their recipes

### 3.2 Administrator

An administrator can:

- View all recipes
- Search recipes
- Update recipe information
- Manage recipe status
- Monitor recipe statistics through the dashboard

---

## 4. Stakeholders

| Stakeholder | Role / Interest |
|---|---|
| Recipe Users | Create, view, search and update recipes |
| Administrator | Manage recipes and workflow |
| Development Team | Design, develop and maintain the application |
| QA/Test Team | Validate functionality using automated Selenium tests |
| DevOps Team | Automate build, testing, deployment and infrastructure configuration |
| Project Guide/Faculty | Evaluate project implementation and DevOps practices |
| System Administrator | Maintain deployment environment and services |

---

## 5. Existing Pain Points

The proposed system addresses the following problems:

1. Recipes may be stored in multiple disconnected locations.
2. Searching for a particular recipe can be time-consuming.
3. Updating recipes manually can lead to outdated information.
4. There is no centralized status workflow for managing recipes.
5. Manual deployment and testing can be slow and error-prone.
6. Lack of automated testing makes regression testing difficult.
7. Manual server configuration can result in inconsistent environments.
8. Without monitoring and health checks, deployment failures may not be detected quickly.

---

## 6. Project Objectives

The primary objectives of the project are:

### Functional Objectives

- Develop a web-based Recipe Management System.
- Allow users to create recipes.
- Allow users to view recipe details.
- Allow authorized users to update recipes.
- Provide recipe search functionality.
- Implement role-based access.
- Implement a recipe status workflow.
- Provide a summary dashboard.

### DevOps Objectives

- Maintain the project using Git and GitHub.
- Implement a Jenkins continuous integration pipeline.
- Automate application builds using Maven.
- Automate functional testing using Selenium WebDriver.
- Prevent deployment when critical automated tests fail.
- Containerize the application using Docker.
- Automate deployment using Jenkins.
- Use Ansible for configuration management and provisioning.
- Demonstrate idempotent infrastructure automation.
- Perform application health checks.
- Demonstrate rollback/recovery to a previous stable release.

---

## 7. Success Criteria

The MVP will be considered successful when:

1. Users can create and view recipes successfully.
2. Existing recipes can be updated by authorized users.
3. Users can search recipes by relevant fields such as name or category.
4. Recipe status can be managed through the defined workflow.
5. The dashboard displays meaningful recipe statistics.
6. The application source code is maintained in GitHub.
7. Jenkins can automatically build the application.
8. Selenium tests execute successfully and generate test results.
9. Failed critical tests prevent deployment.
10. The application can be packaged and deployed as a Docker container.
11. Ansible can configure the required deployment environment.
12. Re-running Ansible produces no unnecessary configuration changes.
13. The deployed application provides a working health check.
14. A previous stable application version can be restored if required.

---

## 8. Constraints

The project will operate under the following constraints:

### Technical Constraints

- The application will use Java with Spring Boot.
- Maven will be used as the build and dependency-management tool.
- Selenium WebDriver will be used for automated UI testing.
- Jenkins will be used for CI/CD automation.
- Docker will be used for application containerization.
- Ansible will be used for configuration management and provisioning.
- Git and GitHub will be used for version control.
- A lightweight database such as H2 will be used for the MVP.

### Scope Constraints

- The project is designed as an academic MVP.
- Advanced social features are outside the initial scope.
- No native Android/iOS application will be developed.
- The system will not initially include advanced recommendation or AI features.
- The system will support a limited number of roles.
- The application will use a simple authentication and authorization model suitable for demonstration.

### Resource Constraints

- Development will primarily be performed on a local development machine.
- Infrastructure will use local or easily accessible environments where possible.
- The project should remain small enough to be developed, tested and demonstrated within the allocated project period.

---

## 9. MVP Scope

The Minimum Viable Product will contain the following functionality.

### Included in MVP

#### Recipe Management

- Create recipe
- View recipe
- Update recipe
- Search recipe
- View recipe list
- Recipe categories

#### Status Workflow

Recipes will follow a simple status lifecycle:

**DRAFT → SUBMITTED → APPROVED → PUBLISHED**

#### Role-Based Access

Two basic roles will be supported:

- USER
- ADMIN

#### Dashboard

The dashboard will display:

- Total number of recipes
- Number of draft recipes
- Number of submitted recipes
- Number of approved recipes
- Number of published recipes

#### DevOps

The MVP delivery pipeline will include:

**GitHub → Jenkins → Maven Build → Automated Tests → Docker → Deployment**

Ansible will be used for environment configuration and provisioning.

---

## 10. Out of Scope

The following features are intentionally excluded from the MVP:

- Mobile application
- Social media integration
- Recipe recommendations using AI
- Nutrition analysis
- Online grocery integration
- Payment functionality
- Advanced analytics
- Multi-language support
- Real-time collaboration
- Large-scale cloud infrastructure
- Complex microservice architecture

These features may be considered as future enhancements.

---

## 11. 15-Week MVP Scope

| Week | Planned Focus | Expected Outcome |
|---|---|---|
| 1 | Problem definition and scope | Approved project scope |
| 2 | Agile planning and DevOps workflow | Backlog, sprint plan and workflow |
| 3 | Requirements and architecture | SRS, architecture and local setup |
| 4 | Git and GitHub | Repository and branching strategy |
| 5 | First feature development | First working recipe feature |
| 6 | MVP completion | Complete core application |
| 7 | Jenkins CI | Automated build pipeline |
| 8 | Pipeline as Code and deployment | Jenkinsfile and deployment |
| 9 | Selenium test design | Automated UI test suite |
| 10 | Continuous testing | Selenium integrated with Jenkins |
| 11 | Docker | Containerized application |
| 12 | Jenkins-Docker deployment | Automated container deployment |
| 13 | Configuration management | Ansible configuration |
| 14 | Provisioning and reliability | Idempotency, health check and recovery |
| 15 | Final release and documentation | Complete DevOps lifecycle demonstration |

---

## 12. Final MVP Definition

The approved MVP is a small web-based Recipe Management System that allows users to create, view, update and search recipes, while administrators manage recipe status and monitor summary statistics.

The application will be developed using an Agile approach and delivered through a DevOps pipeline incorporating GitHub, Jenkins, Maven, Selenium, Docker and Ansible.

The project will demonstrate the complete lifecycle from source-code commit through automated testing, containerized deployment, infrastructure configuration, health validation and recovery.

**MVP principle:** Keep the application functionality simple and focus the majority of the project effort on demonstrating a reliable DevOps lifecycle.
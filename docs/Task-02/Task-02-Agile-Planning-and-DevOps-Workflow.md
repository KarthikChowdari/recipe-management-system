# Task 2: Agile Planning and DevOps Workflow

## 1. Agile Development Approach

The Recipe Management System will follow an Agile development approach using a combination of Scrum planning and a Kanban-style task board.

The complete project is divided into 15 weekly milestones. Each milestone has a defined objective, tasks, expected outcome and deliverables. Work will progress through the following states:

**Backlog → To Do → In Progress → Code Review → Testing → Done**

GitHub Issues and a project board will be used to track development tasks.

---

# 2. Product Backlog

| ID | User Story / Task | Priority | Planned Week |
|---|---|---|---|
| US-01 | As a user, I want to create a recipe so that I can store my recipes in the system. | High | 5 |
| US-02 | As a user, I want to view a recipe so that I can see its ingredients and instructions. | High | 5 |
| US-03 | As a user, I want to update a recipe so that I can correct or modify recipe information. | High | 6 |
| US-04 | As a user, I want to search recipes so that I can quickly find a required recipe. | High | 6 |
| US-05 | As an administrator, I want to manage recipe status so that recipes follow an approval workflow. | High | 6 |
| US-06 | As an administrator, I want to view recipe statistics so that I can monitor the overall system. | Medium | 6 |
| US-07 | As a user, I want to log in according to my role so that unauthorized functionality is restricted. | High | 5–6 |
| US-08 | As a developer, I want the project stored in Git so that changes can be tracked. | High | 4 |
| US-09 | As a developer, I want Jenkins to build the application automatically so that integration problems are detected early. | High | 7 |
| US-10 | As a tester, I want automated Selenium tests so that critical user journeys can be tested repeatedly. | High | 9 |
| US-11 | As a DevOps engineer, I want failed tests to stop deployment so that defective builds are not released. | High | 10 |
| US-12 | As a DevOps engineer, I want the application containerized with Docker so that it can run consistently across environments. | High | 11 |
| US-13 | As a DevOps engineer, I want Jenkins to deploy a Docker image automatically after successful testing. | High | 12 |
| US-14 | As a DevOps engineer, I want Ansible to configure the deployment environment automatically. | High | 13 |
| US-15 | As a DevOps engineer, I want automated health checks and rollback so that failed releases can be recovered. | High | 14 |
| US-16 | As a project team, we want complete technical documentation so that the system can be demonstrated and maintained. | Medium | 15 |

---

# 3. User Stories and Acceptance Criteria

## US-01 — Create Recipe

**User Story:**  
As a user, I want to create a recipe so that I can store my recipes in the system.

**Acceptance Criteria:**

- User can open the recipe creation page.
- User can enter recipe name.
- User can enter description.
- User can enter ingredients.
- User can enter instructions.
- User can select a category.
- Required fields are validated.
- Valid recipe data is saved successfully.
- The newly created recipe appears in the recipe list.

---

## US-02 — View Recipe

**User Story:**  
As a user, I want to view a recipe so that I can see its ingredients and instructions.

**Acceptance Criteria:**

- User can see the recipe list.
- User can select a recipe.
- Recipe details are displayed.
- Ingredients are displayed.
- Instructions are displayed.
- Category and status are displayed.

---

## US-03 — Update Recipe

**User Story:**  
As a user, I want to update a recipe so that I can correct or modify recipe information.

**Acceptance Criteria:**

- Authorized users can open the edit page.
- Existing recipe data is displayed.
- User can modify editable fields.
- Invalid input is rejected.
- Valid changes are saved.
- Updated information is displayed when the recipe is viewed again.

---

## US-04 — Search Recipe

**User Story:**  
As a user, I want to search recipes so that I can quickly find a required recipe.

**Acceptance Criteria:**

- A search field is available.
- User can search using recipe name.
- User can search using category.
- Matching recipes are displayed.
- No-result searches display an appropriate message.

---

## US-05 — Recipe Status Workflow

**User Story:**  
As an administrator, I want to manage recipe status so that recipes follow an approval workflow.

**Acceptance Criteria:**

- New recipes initially have `DRAFT` status.
- A recipe can be submitted for approval.
- An administrator can approve a submitted recipe.
- Approved recipes can be published.
- Invalid status transitions are prevented.
- The current status is visible to authorized users.

**Workflow:**

```text
DRAFT
  ↓
SUBMITTED
  ↓
APPROVED
  ↓
PUBLISHED
```

---

## US-06 — Dashboard

**User Story:**  
As an administrator, I want to view recipe statistics so that I can monitor the overall system.

**Acceptance Criteria:**

- Dashboard displays total recipes.
- Dashboard displays draft recipes.
- Dashboard displays submitted recipes.
- Dashboard displays approved recipes.
- Dashboard displays published recipes.
- Counts reflect the current database state.

---

## US-07 — Role-Based Access

**User Story:**  
As a user, I want to log in according to my role so that unauthorized functionality is restricted.

**Acceptance Criteria:**

- The system recognizes USER and ADMIN roles.
- Users can access permitted functionality.
- Administrative functions are restricted to administrators.
- Unauthorized access is rejected.

---

## US-08 — Version Control

**User Story:**  
As a developer, I want the project stored in Git so that changes can be tracked.

**Acceptance Criteria:**

- Source code is stored in Git.
- Repository is hosted on GitHub.
- Meaningful commit messages are used.
- Feature branches are used for development.
- Changes are merged through the development workflow.

---

## US-09 — Continuous Integration

**User Story:**  
As a developer, I want Jenkins to build the application automatically so that integration problems are detected early.

**Acceptance Criteria:**

- Jenkins is connected to the GitHub repository.
- A project can be checked out automatically.
- Maven build executes successfully.
- Build failures are reported.
- Build artifacts are archived.

---

## US-10 — Automated Selenium Testing

**User Story:**  
As a tester, I want automated Selenium tests so that critical user journeys can be tested repeatedly.

**Acceptance Criteria:**

- Selenium WebDriver is configured.
- At least 3 critical user journeys are automated.
- Tests contain assertions.
- Test data is defined.
- Test results are generated.
- Failure screenshots can be captured.

---

## US-11 — Continuous Testing Quality Gate

**User Story:**  
As a DevOps engineer, I want failed tests to stop deployment so that defective builds are not released.

**Acceptance Criteria:**

- Selenium tests execute through Jenkins.
- Test results are published.
- A failed critical test causes the pipeline to fail.
- Deployment does not occur after a failed quality gate.
- After fixing the defect, the pipeline can complete successfully.

---

## US-12 — Docker Containerization

**User Story:**  
As a DevOps engineer, I want the application containerized with Docker so that it can run consistently across environments.

**Acceptance Criteria:**

- A Dockerfile exists.
- Docker image can be built successfully.
- Image is tagged with a version.
- Container can be started.
- Application is accessible through a mapped port.
- Container logs can be inspected.

---

## US-13 — Automated Docker Deployment

**User Story:**  
As a DevOps engineer, I want Jenkins to deploy a Docker image automatically after successful testing.

**Acceptance Criteria:**

- Jenkins builds the Docker image.
- Image receives a version tag.
- Image can be pushed to a registry.
- Previous container can be stopped/replaced.
- New container starts automatically.
- Deployment occurs only after successful tests.

---

## US-14 — Configuration Management

**User Story:**  
As a DevOps engineer, I want Ansible to configure the deployment environment automatically.

**Acceptance Criteria:**

- Ansible inventory is defined.
- Required packages are specified.
- Required directories are created.
- Required services/configuration are managed.
- Playbook executes successfully.
- Repeated execution produces no unnecessary changes.

---

## US-15 — Reliability and Recovery

**User Story:**  
As a DevOps engineer, I want automated health checks and rollback so that failed releases can be recovered.

**Acceptance Criteria:**

- Application exposes a health endpoint.
- Health endpoint can be tested automatically.
- Deployment health is validated after release.
- Previous stable version is identifiable.
- Failed deployment can be rolled back.
- Previous version becomes accessible again.

---

# 4. Definition of Done

A task will be considered **Done** only when all applicable conditions below are satisfied:

### Development

- Required functionality has been implemented.
- Code follows the project's coding conventions.
- Code has been committed to Git.
- Meaningful commit message has been used.

### Testing

- Relevant tests have been executed.
- Tests pass successfully.
- Critical defects have been corrected.
- Regression testing has been performed where required.

### DevOps

- Required CI/CD configuration has been updated.
- Build completes successfully.
- Deployment configuration has been validated.
- Docker/Ansible configuration works where applicable.

### Documentation

- Required documentation has been updated.
- Relevant screenshots/evidence have been captured.
- Task deliverables have been stored in the project documentation.

### Review

- Changes have been reviewed.
- Pull request requirements have been satisfied where applicable.
- Changes have been merged into the appropriate branch.

Therefore:

**Implemented + Tested + Reviewed + Documented + Verified = DONE**

---

# 5. 15-Week Sprint Plan

## Sprint 1 — Weeks 1–3: Planning and Design

### Week 1
- Problem definition
- Stakeholder identification
- Objectives
- Constraints
- MVP scope

### Week 2
- User stories
- Acceptance criteria
- Product backlog
- Definition of Done
- DevOps lifecycle

### Week 3
- Requirements specification
- Use-case design
- Architecture
- Database design
- Technology setup

---

## Sprint 2 — Weeks 4–6: Application Development

### Week 4
- GitHub repository
- README
- `.gitignore`
- Branching strategy
- Issue templates

### Week 5
- Authentication/roles
- Recipe creation
- Recipe viewing
- Feature branch and pull request

### Week 6
- Recipe update
- Recipe search
- Status workflow
- Dashboard
- Merge conflict demonstration
- Release tag

---

## Sprint 3 — Weeks 7–10: CI and Automated Testing

### Week 7
- Jenkins installation
- GitHub integration
- Maven build
- Artifact archiving

### Week 8
- Jenkinsfile
- Build pipeline
- Packaging
- Deployment

### Week 9
- Selenium setup
- Test cases
- Critical user journeys
- Local execution

### Week 10
- Jenkins/Selenium integration
- Test reporting
- Quality gate
- Deliberate defect
- Defect correction and successful rerun

---

## Sprint 4 — Weeks 11–14: Containerization and Infrastructure

### Week 11
- Dockerfile
- Image creation
- Container execution
- Container lifecycle

### Week 12
- Jenkins Docker integration
- Image versioning
- Registry
- Automated container deployment

### Week 13
- Ansible inventory
- Ansible playbook
- Server prerequisites
- Configuration automation

### Week 14
- Clean environment provisioning
- Idempotency test
- Health check
- Rollback/recovery

---

## Sprint 5 — Week 15: Release

### Week 15

- Complete end-to-end pipeline
- Final integration
- Documentation
- Architecture diagrams
- Troubleshooting guide
- Limitations
- Future enhancements
- Screenshots/video
- Presentation
- Viva preparation

---

# 6. Task Board

The project board will use the following columns:

```text
┌─────────────┐
│   BACKLOG   │
└──────┬──────┘
       ↓
┌─────────────┐
│    TO DO    │
└──────┬──────┘
       ↓
┌─────────────┐
│ IN PROGRESS │
└──────┬──────┘
       ↓
┌─────────────┐
│ CODE REVIEW │
└──────┬──────┘
       ↓
┌─────────────┐
│   TESTING   │
└──────┬──────┘
       ↓
┌─────────────┐
│    DONE     │
└─────────────┘
```

Tasks move from left to right as development progresses.

---

# 7. DevOps Lifecycle

The Recipe Management System will follow this DevOps lifecycle:

```text
       PLAN
        ↓
      CODE
        ↓
      BUILD
        ↓
      TEST
        ↓
     RELEASE
        ↓
    DEPLOY
        ↓
     OPERATE
        ↓
     MONITOR
        ↓
     FEEDBACK
        │
        └──────────→ PLAN
```

### Detailed Project Workflow

```text
Developer
    │
    ▼
Git Feature Branch
    │
    ▼
Pull Request
    │
    ▼
GitHub
    │
    ▼
Jenkins
    │
    ▼
Maven Build
    │
    ▼
Automated Tests
    │
    ├──── FAIL ────→ Fix → Commit → Jenkins
    │
    ▼ PASS
Docker Image
    │
    ▼
Container Deployment
    │
    ▼
Ansible Configuration
    │
    ▼
Health Check
    │
    ├──── FAIL ────→ Rollback
    │
    ▼ PASS
Production/Target Environment
    │
    ▼
Monitoring & Feedback
```

---

# 8. Release Quality Gates

The following quality gates will be used:

### Gate 1 — Source Code

- Code committed to Git
- Pull request reviewed
- No unresolved merge conflicts

### Gate 2 — Build

- Maven build succeeds
- Application package is generated

### Gate 3 — Automated Testing

- Selenium tests execute
- Critical tests pass
- Test report is generated

### Gate 4 — Container

- Docker image builds successfully
- Container starts successfully

### Gate 5 — Deployment

- Application is accessible
- Health check succeeds

Only when all required gates pass will the release be considered successful.

---

# 9. Expected Outcome

At the end of the Agile/DevOps process, the team will have a working Recipe Management System supported by an automated delivery pipeline.

The workflow will demonstrate:

**Planning → Development → Version Control → Continuous Integration → Automated Testing → Containerization → Deployment → Configuration Management → Monitoring → Recovery**

This workflow provides the foundation for all subsequent tasks in the project.
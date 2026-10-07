# AGENTS.md

Academic DevOps project: a Spring Boot recipe app plus CI/CD, Selenium, Docker, and Ansible artifacts, delivered incrementally as numbered "Tasks".

## Repo state (as of Task 4)

- **No application code exists yet.** There is no `pom.xml`, `src/`, `Jenkinsfile`, `Dockerfile`, or CI workflow. Do not invent build/test/lint commands — none are configured. Only `docs/`, `screenshots/`, and empty `ansible/` + `selenium/` dirs (with `.gitkeep`) are present.
- The planned structure, endpoints, and local setup are specified in `docs/Task-03/Task-03-Requirements-Architecture-and-Technology.md` (§11 Project Folder Structure, §12 Local Development Setup). Follow that spec when creating the app; trust it over guesswork, but trust newly added config (e.g. a real `pom.xml`) over the doc.
- Add new task docs as `docs/Task-NN/Task-NN-<Title>.md` and evidence screenshots under `screenshots/task-nn/`, matching the existing pattern.

## Git workflow

- Branch model: `main` ← `develop` ← `feature/*`. Base feature work on `develop`, not `main`.
- Commit messages use conventional prefixes (`docs:`, `chore:`, …) with lowercase descriptions.
- Work is delivered through feature branches and pull requests (see `docs/Task-02`).

## Planned stack / conventions (from docs, not yet in code)

- Java 17+, Maven 3.9+, Spring Boot, Thymeleaf, H2. Layering: Controller → Service → Repository → H2.
- Package root `com.example.recipe`; app class `RecipeApplication.java`; dev server on `http://localhost:8080`; health via `/actuator/health`.
- Recipe status flow is fixed: `DRAFT → SUBMITTED → APPROVED → PUBLISHED`.
- Key endpoints: `/recipes` CRUD, `/recipes/{id}/submit|approve|publish`, `/recipes/search`, `/dashboard` (full list in Task-03 §10).

## Gotchas

- `.gitignore` intentionally keeps `screenshots/failures/` (Selenium failure shots), `*.mv.db` (H2), and `docker-data/` out of git — don't "fix" it by committing these.
- `ansible/` and `selenium/` are placeholder dirs; real content is expected in later tasks.
- Requirements and acceptance criteria for features live in `docs/Task-02` (user stories US-01…) and `docs/Task-03` (FR/NFR tables) — check them before implementing rather than inventing requirements.

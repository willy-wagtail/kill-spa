# Kill SPAs

A Spring Boot application demonstrating hypermedia-driven web development with Thymeleaf and htmx.

## Tech Stack

- **Spring Boot** — Backend framework
- **Thymeleaf** — Server-side HTML templating
- **htmx** — Dynamic HTML partials without JavaScript frameworks
- **Tailwind CSS v4** — Utility-first CSS framework

## Tailwind CSS Workflow

This project uses the **Tailwind CSS standalone CLI** (no Node.js required).

### Regenerate CSS

After changing any HTML template or adding new Tailwind utility classes, run:

```bash
./tailwindcss -i src/main/resources/tailwind/input.css \
  -o src/main/resources/static/css/style.css \
  --content "src/main/resources/templates/**/*.html"
```

This scans all Thymeleaf templates and generates a production-ready CSS file at `src/main/resources/static/css/style.css`.

### File Structure

```
src/main/resources/
├── tailwind/
│   └── input.css          ← Tailwind source (not served)
├── static/
│   └── css/
│       └── style.css      ← Generated output (served by Spring Boot)
└── templates/
    └── *.html             ← Thymeleaf templates
```

Only `style.css` is served to browsers. The `input.css` and `tailwindcss` binary are build artifacts and should not be committed (the binary is already in `.gitignore`).

## Upgrading Tailwind CSS

1. Check the [latest release](https://github.com/tailwindlabs/tailwindcss/releases/latest) on GitHub
2. Download the new macOS ARM64 binary:
   ```bash
   curl -L -o tailwindcss https://github.com/tailwindlabs/tailwindcss/releases/download/vX.Y.Z/tailwindcss-macos-arm64
   chmod +x tailwindcss
   ```
3. Regenerate `style.css` using the command above
4. Commit the updated `style.css`

> **Note:** The `tailwindcss` binary is excluded from Git via `.gitignore` because it's a platform-specific build tool. Only the generated `style.css` is committed.

## Running the Application

```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`.

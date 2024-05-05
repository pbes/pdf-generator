# Generic PDF generator

## Description

This is a generic PDF generator that can be used to generate PDFs from HTML templates. It uses the Thymeleaf template engine to render the HTML templates.

## Usage

### Build
```bash
mvn -B -DskipTests spring-boot:build-image
```

### Run
```bash
docker run --rm -p 8080:8080 docker.io/library/pdf-generator:0.0.1-SNAPSHOT
```

```bash
curl -X POST -H "Content-Type: application/json" -d @data.json http://localhost:8080/generate -o output.pdf
```

The `data.json` file should contain the following fields:

```json
{
  "template": "<html xmlns:th=\"http://www.thymeleaf.org\"><body><h3 style=\"text-align: center; color: blue\"><span th:text=\"'Welcome to ' + ${to} + '!'\"></span></h3></body></html>",
  "data": {
    "to": "Gárdony"
  }
}
```
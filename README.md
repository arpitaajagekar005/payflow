# PayFlow

A payment gateway backend built with Java and Spring Boot to handle merchant onboarding, API keys, order creation, payment status tracking, and card tokenization.

## Tools & Tech Stack
- **Language & Framework:** Java, Spring Boot, Spring Web MVC, Spring Data JPA (Hibernate)
- **Database & Client:** PostgreSQL 16, DBeaver, HikariCP
- **Build & Developer Tools:** Maven, IntelliJ IDEA, Postman, Git/GitHub, Lombok

## What It Does
- **Merchants & API Keys:** Register merchants and generate/revoke API keys for authenticating requests.
- **Orders & Payments:** Create orders and process payments through clear status states (`CREATED`, `CAPTURED`, `FAILED`).
- **Card Vault:** Store tokenized card details (`VaultCard`, `CardToken`) with expiry validation instead of raw card data[cite: 5].
- **Data Integrity:** Uses idempotency checks and JPA auditing (`AuditorAwareImpl`) to keep payment records consistent[cite: 6].

## Running Locally
1. Create a PostgreSQL database named `payflow` running on `localhost:5432`[cite: 5].
2. Set your database password as an environment variable (`DB_PASS`) in your terminal or IntelliJ Run Configuration[cite: 5]:
   ```bash
   export DB_PASS=your_password

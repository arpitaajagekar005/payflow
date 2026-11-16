# PayFlow — Payment Gateway Backend

## Overview

This project is a modular monolith payment processing backend built in **Java** and **Spring Boot** with **PostgreSQL**. The system models core payment gateway infrastructure, handling merchant onboarding, API key lifecycle management, order creation, deterministic payment state transitions, and tokenized card storage.

The goal of this project is to demonstrate clean backend architecture and transactional reliability by:
- separating business domains into self-contained modules (`merchant`, `order`, `payment`, `vault`, `common`),
- enforcing strict payment lifecycle state transitions (`CREATED`, `CAPTURED`, `FAILED`),
- and isolating sensitive card credentials using a tokenization vault and idempotency safeguards.

## Architecture & Domain Information

- **Architecture Pattern:** Modular Monolith (Layered Controller–Service–Repository)
- **Database:** PostgreSQL 16 (Normalized Relational Schema)
- **Connection Pooling:** HikariCP
- **API Style:** RESTful JSON APIs
- **Domain:** Fintech / Payment Processing Infrastructure

## Core Modules & Entities

- **Merchant Module:** Merchant registration, profile management, and status tracking
- **API Key Management:** Programmatic API key generation, prefix lookup, and revocation
- **Order Module:** Order creation, currency/amount validation, and merchant association
- **Payment Module:** Payment initiation, capture/failure transitions, and idempotency tracking
- **Card Vault Module:** Tokenized card storage (`VaultCard`, `CardToken`) and expiry validation (`ExpiryYearValidator`)
- **Common & Audit Module:** Entity auditing (`AuditorAwareImpl`), global configuration, and shared utilities

## Core Features

### Merchant & API Key Lifecycle
- Merchant onboarding and account management
- Programmatic generation and revocation of merchant API keys
- Request authentication scoping per merchant

### Order & Payment Processing
- End-to-end order creation linked to payment execution
- Deterministic payment status transitions (`CREATED` $\rightarrow$ `CAPTURED` / `FAILED`)
- Idempotency checks to prevent duplicate payment processing on retries

### Card Tokenization Vault
- Decouples raw card data from transaction processing by issuing non-sensitive card tokens
- Custom bean validation for card expiry dates (`@ExpiryYear`)
- Normalized storage separating vault cards from issued tokens

### Additional Backend Capabilities
- Automatic entity creation/modification auditing via Spring Data JPA
- Environment-based externalized configuration (`${DB_PASS:}`) for zero hardcoded secrets
- Structured DTO mapping separating persistence entities from external API contracts

## Key Engineering Safeguards

- **ACID Transactional Integrity:** Ensures payment state updates and ledger records commit atomically.
- **Idempotent Request Handling:** Protects against accidental double-charges caused by network retries.
- **Credential Isolation:** Sensitive card details are tokenized in the vault module rather than passed across order/payment tables.
- **Clean Separation of Concerns:** Controllers handle HTTP routing and validation, services enforce business rules, and JPA repositories manage PostgreSQL persistence.

## Tools & Tech Stack

### Backend & Frameworks
- Java
- Spring Boot
- Spring Web MVC
- Spring Data JPA (Hibernate)
- Jakarta Bean Validation
- Lombok

### Database & Clients
- PostgreSQL 16
- HikariCP
- DBeaver

### Build, Testing & Developer Tools
- Maven (`mvnw`)
- IntelliJ IDEA
- Postman
- Git & GitHub

## API Endpoints Overview

| Method | Endpoint | Module | Description |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/v1/merchants` | Merchant | Register a new merchant account |
| `POST` | `/api/v1/merchants/{id}/keys` | Merchant | Generate a new API key for a merchant |
| `DELETE` | `/api/v1/merchants/{id}/keys/{keyId}` | Merchant | Revoke an active merchant API key |
| `POST` | `/api/v1/vault/cards` | Vault | Tokenize and store card details securely |
| `POST` | `/api/v1/orders` | Order | Create a new payment order |
| `POST` | `/api/v1/payments` | Payment | Initiate and process a payment transaction |

## Project Structure

```text
payflow/
│
├── src/
│   ├── main/
│   │   ├── java/com/arpitaajagekar/payflow/
│   │   │   ├── common/          # Auditing & shared configuration
│   │   │   ├── merchant/        # Merchant onboarding & API key management
│   │   │   ├── order/           # Order entities, DTOs, services & controllers
│   │   │   ├── payment/         # Payment lifecycle & state transitions
│   │   │   └── vault/           # Card tokenization & custom expiry validation
│   │   └── resources/
│   │       └── application.yaml # Externalized DB & server configuration
│   └── test/                    # Application context & integration tests
├── pom.xml                      # Maven dependencies & build configuration
└── README.md

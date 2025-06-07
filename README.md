# Spring Boot Payment System 💳

A simple payment processing system using **Spring Boot**, **JPA**, and the **Strategy Design Pattern**.

## Features

- REST APIs for Credit Card, UPI, and Net Banking payments
- JPA Inheritance for polymorphic entities
- Strategy Pattern to decouple payment logic
- Refund and Status Check APIs

## API Endpoints

- `POST /api/payments/credit-card`
- `POST /api/payments/upi`
- `POST /api/payments/net-banking`
- `POST /api/payments/refund/{id}`
- `GET /api/payments/status/{id}`

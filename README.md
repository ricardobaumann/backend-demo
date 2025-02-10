# Bookstore Management API

## Requirements

* JDK 23+ (I recommend installing it via https://sdkman.io/)
* [IntelliJ CE](https://www.jetbrains.com/idea/download)
* [Docker](https://www.docker.com/products/docker-desktop/)
* [Docker compose](https://docs.docker.com/compose/install/)

## Entities: Book, Author, Publisher, Category, Customer, Order

## Requirements:

* A book can have one or more authors (many-to-many).
* A book belongs to one publisher (many-to-1).
* A customer can place multiple orders (1-to-many).
* An order can contain multiple books (many-to-many).
* REST Principles:
    * GET /books: Retrieve all books with filters (e.g., by category or author).
    * POST /books: Add a new book to the catalog.
    * PUT /books/{bookId}: Update book details.
    * DELETE /books/{bookId}: Remove a book from the catalog.
    * GET /orders/{orderId}/books: Retrieve books associated with a specific order.
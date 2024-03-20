# Contact Management System

This is a simple Spring Boot application for managing contacts. It provides CRUD (Create, Read, Update, Delete) operations for contacts.

## Features

- Add a new contact with name, phone number, and email.
- View all contacts in the database.
- View a contact based upon id.
- Edit existing contacts.
- Delete contacts from the database.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Endpoints

Method: POST //Saves a contact
- http://localhost:8080/contacts

Method: GET //Retreives all stored contacts
- http://localhost:8080/contacts

Method: GET //Retreives contact based upon id
- http://localhost:8080/contacts/{id}

Method: PUT //updates a contact
- http://localhost:8080/contacts/{id}

Method: DELETE //deletes a contac
- http://localhost:8080/contacts/{id}





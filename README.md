# 🤖 James - AI Help Desk Chatbot

James is an AI-powered Help Desk Chatbot built using **Spring Boot, Spring AI, React, and MySQL**. The application provides a modern chat interface where users can interact with James for support-related queries, while the Spring Boot backend handles chatbot logic, ticket management, database operations, and AI integration.

## ✨ Features

- 🤖 AI-powered chatbot named **James**
- 💬 Interactive chat interface
- 🧠 AI-generated responses using Spring AI
- 🎫 Help Desk ticket management
- 📋 Ticket information handling
- 🔎 Ticket lookup using user information
- ⚡ REST API based communication
- 🌐 React frontend
- ☕ Spring Boot backend
- 🗄️ MySQL database integration
- 🧩 Layered backend architecture
- 📱 Modern and responsive chat UI
- 🧪 Backend test support

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend development |
| Spring Boot | Backend framework |
| Spring AI | AI integration |
| Spring Web | REST API development |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| Maven | Dependency management |
| Google GenAI | Generative AI |
| React.js | Frontend framework |
| JavaScript | Frontend programming |
| JSX | UI development |
| Tailwind CSS | Styling |
| Vite | Frontend development |
| Lucide React | Icons |
| MySQL | Database |
| Git & GitHub | Version control |

## 📂 Project Structure

```text
ChatBotProjectSpring/
│
├── .mvn/
├── public/
│
├── src/
│   ├── assets/
│   ├── components/
│   ├── lib/
│   │
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── kodnest/
│   │   │           └── chatbotproject/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── repository/
│   │   │               ├── entity/
│   │   │               └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   ├── pages/
│   ├── services/
│   │
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── kodnest/
│   │               └── chatbotproject/
│   │
│   ├── App.css
│   ├── App.jsx
│   ├── index.css
│   └── main.jsx
│
├── .gitattributes
├── .gitignore
├── components.json
├── pom.xml
└── README.md
```

## 🏗️ Application Architecture

```text
                         ┌─────────────────┐
                         │      USER       │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │ React Frontend  │
                         │                 │
                         │    Chat UI      │
                         └────────┬────────┘
                                  │
                                  │ REST API
                                  ▼
                         ┌─────────────────┐
                         │  Spring Boot    │
                         │    Backend      │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │ James Service   │
                         │ Chatbot Logic   │
                         └───────┬─────────┘
                                 │
                    ┌────────────┴────────────┐
                    │                         │
                    ▼                         ▼
             ┌──────────────┐          ┌──────────────┐
             │  Spring AI   │          │    MySQL     │
             │   AI Model   │          │   Database   │
             └──────┬───────┘          └──────────────┘
                    │
                    ▼
             ┌──────────────┐
             │ AI Response  │
             └──────┬───────┘
                    │
                    ▼
             ┌─────────────────┐
             │ React Frontend  │
             └────────┬────────┘
                      │
                      ▼
                     USER
```

## ☕ Backend

The Spring Boot backend is located inside:

```text
src/main
```

The main Java package is:

```text
src/main/java/com/kodnest/chatbotproject
```

The backend is responsible for:

- Handling REST API requests
- Processing chatbot requests
- Communicating with the AI model
- Managing support tickets
- Performing database operations
- Returning responses to the React frontend

The backend follows a layered architecture using controllers, services, repositories, entities, and configuration.

## ⚛️ Frontend

The React frontend is located inside the `src` directory.

```text
src/
├── assets/
├── components/
├── lib/
├── pages/
├── services/
├── App.jsx
├── App.css
├── index.css
└── main.jsx
```

The frontend provides the interface through which users communicate with James.

It includes:

- Chat interface
- Chat sidebar
- Search functionality
- New chat functionality
- Message display
- Message input
- Send functionality
- Loading indicators
- Reusable UI components

## 🤖 About James

James acts as a virtual Help Desk Assistant.

When a user sends a message, James processes the request through the Spring Boot backend and uses Spring AI to generate an appropriate response.

The general interaction is:

```text
User
  ↓
React Chat Interface
  ↓
Spring Boot REST API
  ↓
James Chatbot Service
  ↓
Spring AI
  ↓
AI Model
  ↓
James Response
  ↓
React Chat Interface
  ↓
User
```

## 🎫 Help Desk Ticket System

James is designed to assist with Help Desk support and ticket-related requests.

A ticket can contain information such as:

```text
Ticket
│
├── ID
├── Email
├── Summary
├── Description
├── Priority
├── Category
├── Status
├── Created On
└── Updated On
```

Supported ticket priority levels include:

```text
LOW
MEDIUM
HIGH
URGENT
```

## 💬 Chatbot Workflow

```text
User
 │
 ▼
Enter Support Query
 │
 ▼
React Chat UI
 │
 ▼
REST API Request
 │
 ▼
Spring Boot Controller
 │
 ▼
James Service
 │
 ▼
Process Query
 │
 ├── Check Ticket Information
 │
 └── Communicate with Spring AI
             │
             ▼
          AI Model
             │
             ▼
       AI Generated Response
             │
             ▼
       Spring Boot API
             │
             ▼
        React Chat UI
             │
             ▼
            User
```

## 🌐 API

The main chatbot endpoint is:

```text
POST /api/v1/response
```

The frontend sends the user's chatbot request to this endpoint. The Spring Boot backend processes the request and returns James's response.

```text
React
  │
  │ POST /api/v1/response
  ▼
Spring Boot
  │
  ▼
James
  │
  ▼
Spring AI
  │
  ▼
AI Model
  │
  ▼
Response
  │
  ▼
React
```

## 🗄️ Database

The application uses **MySQL** for persistent data storage.

Spring Data JPA and Hibernate are used for database communication.

The database can store Help Desk information such as:

- Ticket ID
- User email
- Ticket summary
- Ticket description
- Priority
- Category
- Status
- Created date
- Updated date

## ⚙️ Configuration

Backend configuration is located at:

```text
src/main/resources/application.properties
```

Example database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chatbot
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

Configure these values according to your local environment.

## 🔐 Environment Variables

Never commit sensitive credentials to GitHub.

Keep the following outside the repository:

```text
API Keys
Database Passwords
Secret Keys
Access Tokens
Private Credentials
```

Example:

```text
GOOGLE_API_KEY=your_api_key
DB_USERNAME=root
DB_PASSWORD=your_password
```

## 🚀 Getting Started

### Prerequisites

Make sure the following are installed:

- Java 21 or later
- Maven
- Node.js
- npm
- MySQL
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/Jaswanth778012/ChatBotProjectSpring.git
cd ChatBotProjectSpring
```

### 2. Configure MySQL

Create the database:

```sql
CREATE DATABASE chatbot;
```

Update:

```text
src/main/resources/application.properties
```

with your MySQL credentials.

### 3. Configure AI Credentials

Configure the required AI API credentials using environment variables or local configuration.

Do not commit API keys to GitHub.

### 4. Start the Spring Boot Backend

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

### 5. Install Frontend Dependencies

```bash
npm install
```

### 6. Start the React Frontend

```bash
npm run dev
```

Vite will display the local frontend URL in the terminal.

## 🧪 Testing

Backend tests are located inside:

```text
src/test
```

Run the tests with:

```bash
mvnw.cmd test
```

or:

```bash
mvn test
```

## 📦 Build the Backend

```bash
mvnw.cmd clean package
```

or:

```bash
mvn clean package
```

The generated JAR file will be available inside:

```text
target/
```

## 🔧 Useful Commands

### Run Backend

```bash
mvnw.cmd spring-boot:run
```

### Run Tests

```bash
mvnw.cmd test
```

### Clean Project

```bash
mvnw.cmd clean
```

### Build Project

```bash
mvnw.cmd clean package
```

### Install Frontend Dependencies

```bash
npm install
```

### Start Frontend

```bash
npm run dev
```

## 📚 What This Project Demonstrates

This project demonstrates practical experience with:

- Java
- Spring Boot
- REST API development
- Spring Data JPA
- Hibernate
- MySQL
- Spring AI
- Generative AI
- AI chatbot development
- React.js
- JavaScript
- JSX
- Tailwind CSS
- Vite
- API integration
- Full-stack application development
- Git and GitHub

## 🔮 Future Enhancements

Possible future improvements include:

- 🔐 User authentication
- 👤 User profile management
- 💬 Persistent chat history
- 🧠 Conversation memory
- 📚 RAG-based knowledge base
- 📄 Document upload
- 🔎 Semantic document search
- 🎫 Advanced ticket management
- 📊 Admin dashboard
- 🔔 Ticket notifications
- ⚡ Streaming AI responses
- 🎙️ Voice interaction
- 📱 Improved mobile support
- ☁️ Cloud deployment

## 🛡️ Security

Never upload sensitive credentials to GitHub.

Do not commit:

```text
API Keys
Passwords
Access Tokens
Secret Keys
Database Credentials
```

Use environment variables for sensitive configuration and make sure sensitive local files are included in `.gitignore`.

## 🐛 Troubleshooting

### Backend does not start

Check:

```text
Java version
Maven installation
Database connection
application.properties
AI API credentials
Port availability
```

### Database connection error

Check that:

```text
MySQL is running
Database URL is correct
Username is correct
Password is correct
Database exists
```

### AI response is not generated

Check:

```text
AI API key
AI provider configuration
Internet connection
Spring AI dependencies
Backend logs
```

### Frontend cannot communicate with backend

Check:

```text
Backend is running
API URL is correct
API endpoint is correct
CORS configuration
Network requests in browser
```

## 👨‍💻 Author

**Jaswanth**

GitHub:

https://github.com/Jaswanth778012

Repository:

https://github.com/Jaswanth778012/ChatBotProjectSpring

## ⭐ James - AI Help Desk Chatbot

**Built with Java, Spring Boot, Spring AI, React, and MySQL.**

James combines a modern React chat interface with a Spring Boot backend and AI-powered assistance to provide an interactive Help Desk experience.

```text
        💬 User
           │
           ▼
      ⚛️ React
           │
           ▼
    ☕ Spring Boot
           │
       ┌───┴───┐
       ▼       ▼
   🧠 Spring   🗄️ MySQL
       AI
       │
       ▼
    🤖 James
       │
       ▼
 Helpful Response
```

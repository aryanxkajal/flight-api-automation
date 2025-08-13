# ✈️ FlightApiAutomation

**API Automation Framework using Java, Rest Assured, and TestNG**

---

## 📌 Overview

**FlightApiAutomation** is a structured, Maven-based automation framework designed to test Flight Booking APIs.  
Built using **Java 11**, **Rest Assured**, and **TestNG**, this framework ensures maintainability, reusability, and scalability for automated API testing.

---

## 📂 Project Structure

```

flight-api-automation/
│
├── pom.xml                          # Maven build configuration and dependencies
├── testng.xml                       # TestNG suite configuration
├── README.md                        # Project documentation
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/flightbooking/
│   │   │       ├── config/         # Configuration and environment setup
│   │   │       └── utils/          # Utility/helper classes
│   └── resources/
│       └── config.properties        # Application environment configuration
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── com/flightbooking/
│   │   │       ├── base/           # Base test setup classes
│   │   │       ├── models/         # POJO classes (Request/Response)
│   │   │       └── tests/          # API test classes
│   └── resources/
│       └── testdata/               # External JSON payloads and test data
│
├── target/                          # Compiled code and test outputs
└── test-output/                     # TestNG default output directory

````

---

## ⚙️ Setup & Installation

### 1️⃣ Prerequisites

- Java 11 or higher  
- Maven 3.6+  
- Internet access for API connectivity  

### 2️⃣ Configure the Environment

Update the `config.properties` file with your API environment details:

```properties
# src/main/resources/config.properties

baseUrl=https://api.example.com/flights
authUrl=https://auth.example.com/token
client_id=your-client-id
client_secret=your-client-secret
````

---

## ▶️ Running Tests

To run **all tests** using Maven:

```bash
mvn clean test
```

To run a **specific test suite**:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## ✅ Features

* ✅ Token-based authentication (Client Credentials Flow)
* ✅ Externalized test data using JSON
* ✅ Modular test structure
* ✅ Positive and negative scenario coverage
* ✅ Reusable utility and config components
* ✅ Test execution managed via TestNG

---

## 🔄 Extending the Framework

### ➕ Add New API Tests

1. Create a new test class under:

   ```
   src/test/java/com/flightbooking/tests
   ```

2. Extend the `TestBase` class for setup and teardown.

3. Use `TokenManager.getAccessToken()` to fetch the auth token if needed.

---

### ➕ Add New Payloads

1. Add your JSON file under:

   ```
   src/test/resources/testdata
   ```

2. Load it using:

   ```java
   PayloadBuilder.loadJsonAsMap("testdata/yourfile.json");
   ```

---



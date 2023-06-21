# Test Automation

This repository contains a test automation project for a web application. The project uses Selenium WebDriver and
Cucumber for automated testing. It includes test scenarios for user registration and creating a bakery order.

## Prerequisites

- Java Development Kit (JDK) 8 or above
- Maven
- WebDriver for Edge browser

## Getting Started

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/TestAutomation.git

2. Install the required dependencies by navigating to the project directory and running the following command:
   ```bash
   mvn install

3. Download the appropriate WebDriver for the Edge browser and place it in the project's drivers directory.

## Test Scenarios

### User Registration

This test scenario verifies the user registration flow.

1. Open the Jumia homepage.
2. Click on the "Account" button.
3. Click on the "Sign In" button.
4. Fill in the required personal data.
5. Verify the successful registration message.

To run this test scenario, execute the following command:

   ```bash
   mvn test -Dtest=UserRegistrationTest
```

### Create Bakery Order

This test scenario verifies the process of creating a bakery order.

1. Open the Jumia homepage.
2. Sign in using the provided credentials.
3. Navigate to the bakery section.
4. Add an item to the cart and increase the quantity.
5. Go to the cart page.
6. Verify the number of items and the subtotal.

To run this test scenario, execute the following command:

```bash
   mvn test -Dtest=JumiaTest
```

## Test Execution

The test scenarios can be executed using the provided test runners.

To run all the test scenarios, execute the following command:

   ```bash
   mvn test
```

To run a specific test scenario, provide the corresponding test class name as shown in the previous sections.

## Reporting

After executing the test scenarios, the test results will be available in the target directory. The HTML report can be
found in the target/cucumber-html-report directory, and the JSON report can be found in the target/cucumber.json file.
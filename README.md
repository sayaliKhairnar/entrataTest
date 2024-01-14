# Entrata Test Automation Project

This project contains automated tests for exploring and validating the functionality of [entrata.com](https://www.entrata.com/).

## Prerequisites

Make sure you have the following installed:

- Java
- Maven
- TestNG
- WebDriver (e.g., ChromeDriver)

## Project Structure

- `src/main/java`: Contains main Java code and configurations.
- `src/test/java/entrataTest`: Contains test classes.
- `pom.xml`: Maven project configuration file.

## Test Classes

### `demoTestClass`

- **Setup:**
  - Initializes the WebDriver and navigates to the Entrata website.
  - Accepts cookies if the banner is displayed.

- **Test Cases:**
  1. **verifyPageTitle:**
     - Verifies the title of the Entrata website.
     - Assertion: "Property Management Software | Entrata"

  2. **verifyPageLogo:**
     - Verifies the presence of the Entrata logo.

  3. **watchDemo:**
     - Interacts with the "Watch Demo" button and fills the demo form.
     - Verifies the filled form fields.

  4. **watchProductResidentPayDemo:**
     - Navigates to the ResidentPay demo page from the Products menu.
     - Interacts with the demo form.
     - Verifies the filled form fields.

  5. **solutionsMultiFamilyWatchWhyEntrataVideo:**
     - Navigates to the Multi-Family solutions page.
     - Watches the "Why Entrata?" video and closes it.

- **Teardown:**
  - Navigates back to the main page and quits the WebDriver.

## How to Run Tests

1. Clone the repository:

   ```bash
   git clone https://github.com/sayaliKhairnar/entrataTest.git

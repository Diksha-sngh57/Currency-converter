Currency Converter
A simple Java-based currency converter application with a graphical user interface (GUI) built using Swing. This application allows users to convert amounts between various currencies using predefined exchange rates.
Features

Select the base currency from a dropdown list.
Select the target currency from a dropdown list.
Input the amount to convert.
Displays the converted amount with the target currency symbol.
Error handling for invalid inputs and unavailable exchange rates.

Supported Currencies

USD (United States Dollar)
EUR (Euro)
GBP (British Pound)
JPY (Japanese Yen)
AUD (Australian Dollar)
CAD (Canadian Dollar)
CHF (Swiss Franc)
CNY (Chinese Yuan)
INR (Indian Rupee)
BRL (Brazilian Real)

Prerequisites

Java Development Kit (JDK) 8 or higher.
An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or VS Code) to run the code.

Installation

Clone the repository:git clone https://github.com/Diksha-sngh57/currency-converter.git


Navigate to the project directory:cd currency-converter


Compile and run the Java file:javac CurrencyConverter.java
java CurrencyConverter



Usage

Launch the application.
Select the "From Currency" and "To Currency" from the dropdown menus.
Enter the amount you wish to convert in the "Amount" field.
Click the "Convert" button to see the result.
The converted amount will be displayed below the button.

Notes

The application uses static exchange rates for demonstration purposes. In a real-world scenario, you would integrate with a live API (e.g., ExchangeRate-API) to fetch real-time rates.
The result label is styled to occupy half the screen width for better visibility.

Contributing
Feel free to fork this repository and submit pull requests. You can:

Add support for more currencies.
Integrate a live exchange rate API.
Enhance the UI/UX.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Acknowledgments

Inspired by the Intern Orbit Level 2 Task-2 challenge.
Built with Java Swing for a simple GUI experience.

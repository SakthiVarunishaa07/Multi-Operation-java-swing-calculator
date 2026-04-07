# Calculator Swing (Java Desktop Application)

## Overview

Calculator Swing is a desktop-based application developed using Java Swing that enables users to perform arithmetic and statistical operations on multiple numerical inputs. The application is designed with a focus on usability, input validation, and clear result presentation through an intuitive graphical user interface.


## Key Features

* Supports batch input of numbers
* Provides multiple operations:

  * Addition
  * Subtraction
  * Multiplication
  * Division (with zero handling)
  * Modulus
  * Percentage calculation
  * Average computation
  * Minimum and Maximum identification
* Real-time result display with detailed breakdown
* Robust input validation and error handling
* Reset functionality for efficient reuse


## Technology Stack

* **Programming Language:** Java
* **GUI Framework:** Swing
* **Libraries Used:** AWT (Abstract Window Toolkit)


## Project Structure


CalculatorSwing.java   // Main source file containing UI and logic


## Installation and Setup

### Prerequisites

* Java Development Kit (JDK 8 or higher)

### Steps to Run

1. Clone the repository:

   git clone https://github.com/your-username/java-swing-calculator.git
  

2. Navigate to the project directory:

   
   cd java-swing-calculator
   

3. Compile the source code:

   
   javac CalculatorSwing.java
   

4. Run the application:

   
   java CalculatorSwing
   

---

## Usage Instructions

1. Enter the total number of values to process
2. Input the numbers (one per line)
3. Select the desired operation from the dropdown menu
4. Click **CALCULATE** to view the result
5. Use **CLEAR** to reset all inputs

---

## Error Handling

* Ensures the number of inputs matches the specified count
* Prevents division and modulus operations with zero
* Handles invalid or non-numeric input gracefully

---

## Future Enhancements

* Implementation of layout managers for responsive UI design
* Addition of calculation history tracking
* Keyboard shortcuts for improved accessibility
* Enhanced UI themes including dark mode


## Author

This project was developed as part of learning and practicing Java GUI development, focusing on event-driven programming and user interface design.


## License

This project is open-source and available for educational and personal use.

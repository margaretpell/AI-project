#### This program is a sorting algorithms demonstration with a graphical user interface (GUI). It allows users to enter an array of integers and apply various sorting algorithms to sort the array. The sorting algorithm is selected based on a dice roll, providing an element of randomness to the sorting process.

### Version of Java: Java 11

### Testing Framework: JUnit 5.

### Use Cases:

As a user, I want to enter an array of integers.
As a user, I want to click a button to roll the dice and sort the array.
As a user, I want to see the selected sorting algorithm and the sorted array displayed in the output area.
As a user, I want to receive an error message if the input array is invalid or the sorting method is unknown.

### User Story:

The user launches the program and sees a GUI with an input field, a button, and an output area.
The user enters an array of integers in the input field.
The user clicks the "Roll the Dice & Sort" button.
The program rolls the dice to select a sorting algorithm.
The program sorts the input array using the selected algorithm.
The program displays the selected sorting algorithm and the sorted array in the output area.

### Design Patterns:

Observer Pattern: The Dice class implements the Observer pattern, where the SortingAlgorithmsGUI class acts as the observer. The Dice notifies the observer (GUI) whenever the dice is rolled, triggering the sorting process.

Strategy Pattern: The SortingController class utilizes the Strategy pattern to encapsulate different sorting algorithms (strategies) into separate classes. This allows for easy interchangeability of sorting strategies without modifying the core sorting logic.
### Code Smells and Violations of SOLID or CA:
The provided code does not contain significant code smells or violations of SOLID or Clean Architecture (CA) principles. However, some improvements could be made:

Dependency Injection: The SortingController class could benefit from dependency injection to decouple it from the SortingAlgorithmsGUI class, making it more testable and following the Dependency Inversion Principle.

Improved Exception Handling: The code could provide more specific exception handling and error messages to assist users in identifying issues with input arrays or sorting methods.


#### Overall, the code demonstrates good adherence to SOLID principles, clean code practices, and the use of appropriate design patterns.
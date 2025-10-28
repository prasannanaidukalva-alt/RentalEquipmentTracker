🧰 System Rental Tracker

A Java-based console application designed to manage equipment rentals efficiently.
The system allows users to track available equipment, rent items to customers, and manage returns with real-time stock updates.

📋 Features

Display all available equipment with details.

Add new equipment with ID, name, rent per day, and quantity.

Rent equipment to customers and automatically update stock and usage count.

Return rented equipment and restore stock.

Menu-driven console interface for easy interaction.

🧠 Concepts Used

Object-Oriented Programming (OOP)

Classes and Objects

Encapsulation

Composition

Collections Framework (ArrayList)

User Input Handling (Scanner class)

Conditional Statements & Loops

🧩 Class Overview
Class Name	Description
Equipment	Stores details of equipment such as ID, name, rent per day, quantity, and usage count.
Customer	Stores customer details like name and contact number.
RentalRecord	Maintains details of each rental transaction (customer and equipment info).
RentalSystem	Handles all operations such as adding, renting, returning, and displaying equipment.
SystemRentalTracker	Contains the main() method and provides the menu-driven interface.
🖥️ How It Works

When the program starts, it displays a default list of equipment.

The user can select options from the menu to add, rent, or return equipment.

When equipment is rented, quantity decreases and usage count increases.

When returned, the quantity is restored.

The system keeps running until the user chooses to exit.

⚙️ How to Run

Copy the code into a file named SystemRentalTracker.java.

Compile using:

javac SystemRentalTracker.java


Run the program using:

java SystemRentalTracker


Follow the on-screen menu instructions.

🧾 Example Output
=== Welcome to System Rental Tracker ===

=== Equipment List ===
ID: 1 | Name: Camera | Rent/Day: Rs.500.0 | Quantity: 3 | Usage Count: 0
ID: 2 | Name: Projector | Rent/Day: Rs.1000.0 | Quantity: 2 | Usage Count: 0
ID: 3 | Name: Laptop | Rent/Day: Rs.800.0 | Quantity: 5 | Usage Count: 0

--- MENU ---
1. Display All Equipment
2. Add New Equipment
3. Rent Equipment
4. Return Equipment
5. Exit
Enter your choice:

🎯 Objective

To automate the rental management process by providing a simple, reliable, and efficient system for tracking equipment usage, rentals, and returns.

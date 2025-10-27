package tracker;
import java.util.*;

// Class to represent Equipment
class Equipment {
    private int id;
    private String name;
    private double rentPerDay;
    private int quantity;
    private String status;
    private int usageCount;

    // Constructor
    public Equipment(int id, String name, double rentPerDay, int quantity) {
        this.id = id;
        this.name = name;
        this.rentPerDay = rentPerDay;
        this.quantity = quantity;
        this.status = "Available";
        this.usageCount = 0;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getRentPerDay() { return rentPerDay; }

    // Rent an equipment item
    public boolean rentOne() {
        if (quantity > 0) {
            quantity--;
            usageCount++;
            if (quantity == 0) status = "Out of Stock";
            return true;
        } else {
            return false;
        }
    }

    // Return an equipment item
    public void returnOne() {
        quantity++;
        status = "Available";
    }

    // Display equipment details
    public void displayDetails() {
        System.out.println("ID: " + id + " | Name: " + name +
                           " | Rent/Day: Rs." + rentPerDay +
                           " | Quantity: " + quantity +
                           " | Status: " + status +
                           " | Usage Count: " + usageCount);
    }
}

// Class to represent a Customer
class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void displayCustomer() {
        System.out.println("Customer Name: " + name + ", Contact: " + contact);
    }
}

// Class to represent a Rental Record
class RentalRecord {
    private Customer customer;
    private Equipment equipment;
    private String startDate;
    private String endDate;
    private int days;
    private double totalCost;

    public RentalRecord(Customer customer, Equipment equipment, String startDate, String endDate, int days) {
        this.customer = customer;
        this.equipment = equipment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.totalCost = days * equipment.getRentPerDay();
    }

    public void displayRecord() {
        customer.displayCustomer();
        System.out.println("Equipment: " + equipment.getName());
        System.out.println("From: " + startDate + " To: " + endDate +
                           " | Days: " + days +
                           " | Total Cost: Rs." + totalCost);
    }
}

// Class to manage the rental system
class RentalSystem {
    private ArrayList<Equipment> equipmentList = new ArrayList<>();
    private ArrayList<RentalRecord> rentalRecords = new ArrayList<>();

    // Initialize default equipment
    public void initializeEquipment() {
        equipmentList.add(new Equipment(1, "Camera", 500, 3));
        equipmentList.add(new Equipment(2, "Projector", 1000, 2));
        equipmentList.add(new Equipment(3, "Laptop", 800, 4));
    }

    // Display all equipment
    public void displayAll() {
        System.out.println("\n=== Equipment List ===");
        for (Equipment e : equipmentList) {
            e.displayDetails();
        }
    }

    // Add new equipment
    public void addEquipmentInput(Scanner sc) {
        System.out.print("Enter Equipment ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Equipment Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Rent Per Day: ");
        double rent = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        equipmentList.add(new Equipment(id, name, rent, qty));
        System.out.println("Equipment added successfully!");
    }

    // Rent equipment
    public void rentEquipment(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Equipment ID to rent: ");
        int id = sc.nextInt();

        Equipment selected = null;
        for (Equipment e : equipmentList) {
            if (e.getId() == id) {
                selected = e;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Equipment not found!");
            return;
        }

        if (selected.rentOne()) {
            sc.nextLine();
            System.out.print("Enter Start Date: ");
            String start = sc.nextLine();
            System.out.print("Enter End Date: ");
            String end = sc.nextLine();
            System.out.print("Enter Total Days: ");
            int days = sc.nextInt();

            Customer c = new Customer(cname, contact);
            RentalRecord record = new RentalRecord(c, selected, start, end, days);
            rentalRecords.add(record);
            System.out.println("Equipment rented successfully!");
            record.displayRecord();
        } else {
            System.out.println("Sorry, equipment out of stock!");
        }
    }

    // Return equipment
    public void returnEquipment(Scanner sc) {
        System.out.print("Enter Equipment ID to return: ");
        int id = sc.nextInt();
        for (Equipment e : equipmentList) {
            if (e.getId() == id) {
                e.returnOne();
                System.out.println("Equipment returned successfully!");
                return;
            }
        }
        System.out.println("Invalid Equipment ID!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalSystem system = new RentalSystem();
        system.initializeEquipment();

        int choice;
        do {
            System.out.println("\n=== Welcome to System Rental Tracker ===");
            system.displayAll();
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display All Equipment");
            System.out.println("2. Add New Equipment");
            System.out.println("3. Rent Equipment");
            System.out.println("4. Return Equipment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: system.displayAll(); break;
                case 2: system.addEquipmentInput(sc); break;
                case 3: system.rentEquipment(sc); break;
                case 4: system.returnEquipment(sc); break;
                case 5: System.out.println("Exiting System..."); break;
                default: System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }
}

package jp2;
import java.util.HashMap;
import java.util.Scanner;
public class CustomerFunciton {
    private HashMap<String, Customer> customers;
    private Scanner sc;

    public CustomerFunciton() {
        customers = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void add() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);
        System.out.println("Customer added successfully.");
    }

    public void displayAll() {
        if (customers.isEmpty()) {
            System.out.println("No customers in the database.");
        } else {
            System.out.println("Customers in the database:");
            for (String name : customers.keySet()) {
                Customer customer = customers.get(name);
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
                System.out.println("------------------------");
            }
        }
    }

    public void findByName() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (customers.containsKey(name)) {
            Customer customer = customers.get(name);
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Customer not found.");
        }
    }
}


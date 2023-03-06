package jp2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CustomerFunciton crm = new CustomerFunciton();
        Scanner input = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    crm.add();
                    break;
                case 2:
                    crm.findByName();
                    break;
                case 3:
                    crm.displayAll();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (menu != 4);
        input.close();
    }
}

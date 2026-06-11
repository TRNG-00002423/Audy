import java.util.Scanner;

/**
 * Week 2 Exercise — menu-driven console (implement the menu loop).
 *
 * Compile: javac TicketMenu.java
 * Run:     java TicketMenu
 */
public class TicketMenu {

    public static void main(String[] args) {
        String[] tickets = {"BUG-101 Login timeout", "BUG-102 CSV import", "BUG-103 flaky assertion"};
        int[] priorities = {2, 2, 2}; // stretch: update in menu option 2

        try (Scanner in = new Scanner(System.in)) {
            // TODO: loop until quit
            int choice;

            // print menu: 1=list 2=set priority 3=summary 4=quit
            do {
                System.out.println("\n--- Ticket Menu ---");
                System.out.println("1 - List tickets");
                System.out.println("2 - Set priority");
                System.out.println("3 - Summary");
                System.out.println("4 - Quit");
                System.out.print("Choose your option: ");

                while (!in.hasNextInt()) {
                    System.out.print("Invalid choice. Please choose an option from above: ");
                    in.next();
                }

                choice = in.nextInt();
                in.nextLine();

                switch(choice){

                    // List tickets with its priority
                    case 1:
                        System.out.println("\n=== Current Tickets ===");
                        for (int i = 0; i < tickets.length; i++) {
                            System.out.println(
                                "[" + i + "] " +
                                tickets[i] +
                                " | Priority: " +
                                priorities[i]
                            );
                        }
                        break;

                    // Sets priority and adds priority to a ticket
                    // tickets.length - 1 last valid index from array.
                    case 2:
                        System.out.print(
                            "\nSelect a ticket to update (0-" +
                            (tickets.length - 1) + "): "
                        );
                        // When user inputs invalid choice loops till valid choice is made
                        while (!in.hasNextInt()) {
                            System.out.print("Enter a valid ticket index: ");
                            in.next();
                        }
                        
                        //  Reads the ticket index value
                        int index = in.nextInt();

                        if (index < 0 || index >= tickets.length) {
                            System.out.println(
                                "Error: Ticket index must be between 0 and "
                                + (tickets.length - 1) + "."
                            );
                            break;
                        }

                        System.out.print("Enter a new priority level (1 = High, 2 = Medium, 3 = Low): ");

                        while (!in.hasNextInt()) {
                            System.out.print(
                                "Invalid input. Please enter a priority value between 1 and 3: "
                            );
                            in.next();
                        }
                        
                        // Reads the priority value
                        int priority = in.nextInt();
                        in.nextLine(); // consume newline

                        if (priority < 1 || priority > 3) {
                            System.out.println("Priority must be between 1 and 3.");
                            break;
                        }
                        // Updates the priority for the selected ticket
                        priorities[index] = priority;
                        System.out.println(
                            "Priority for \"" +
                            tickets[index] +
                            "\" has been updated to " +
                            priority + "."
                        );
                        break;

                    // Summary
                    case 3:
                        break;

                    // Closes the program
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    
                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 4);
        } // TRY BLOCK
    } // MAIN METHOD  
} // CLASS
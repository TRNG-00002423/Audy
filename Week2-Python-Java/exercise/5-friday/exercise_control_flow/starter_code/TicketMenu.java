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
            int choice = 0;

            

            // print menu: 1=list 2=set priority 3=summary 4=quit
            System.out.println("Implement TicketMenu loop");
            do {
                System.out.println("\n--- Ticket Menu ---");
                System.out.println("1 - List tickets");
                System.out.println("2 - Set priority");
                System.out.println("3 - Summary");
                System.out.println("4 - Quit");
                System.out.print("Choice: ");
            }

        }
    }
}

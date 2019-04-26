/* ContactDemo.java
 * Author:  William Craycroft
 * Module:  10
 * Project: Homework 10
 * Problem Statement: This class demonstrates the functionality of the ContactArrayList class, which allows the user
 *      to create, edit and delete from a list of Contacts.
 *
 * Algorithm / Plan:
 *      1. Instantiate and populate a ContactArrayList with 5 pre-generated Contacts
 *      2. Print user menu and prompt for action
 *      3. If add contact is selected
 *          Call the ContactArrayList user prompt method
 *      4. If display contact is selected
 *          Prompt user for a search key ("ALL" to show all contacts)
 *          Call ContactArrayList printSearchResults method
 *          If empty, display error message
 *      5. If remove contact is selected
 *          Prompt user for a search key ("ALL" to show all contacts)
 *          Call ContactArrayList printSearchResults method
 *          Prompt user to confirm they would like to delete the previous Contacts
 *          If confirmed, loop through indices array and remove Contact at each index (starting from largest)
 *      6. If sort list is selected
 *          Call ContactArrayList sort method
 *          Display all contacts
 *      7. Repeat steps 2-6 until "Quit" choice is selected
 *      8. Exit program
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ContactDemo {

    public static void main (String[] args)
    {
        // Instantiate ContactArrayList
        ContactArrayList contactList = new ContactArrayList();

        // Add pre-generated contacts
        contactList.add(new Contact("Will", "Craycroft", "(858) 361-8728", "wcraycroft@gmail.com"));
        contactList.add(new Contact("Hulk", "Hogan", "(221) 555-2415", "hhogan@gmail.com"));
        contactList.add(new Contact("Keanu", "Reeves", "(521) 361-6133", "motoguy@gmail.com"));
        contactList.add(new Contact("Ben", "Bates", "(878) 126-8832", "bates@gmail.com"));
        contactList.add(new Contact("Alfred", "May", "(800) 462-2799", "amay@gmail.com"));

        // Declarations
        int choice = 0;
        String key;
        ArrayList<Integer> searchIndices;
        Scanner keyboard = new Scanner(System.in);

        // User input loop
        while (true) {
            // Print Menu
            System.out.println("**********************************************");
            System.out.println("** Please select from the following options:");
            System.out.println("** 1)  Add a new contact                    ");
            System.out.println("** 2)  Display contacts                     ");
            System.out.println("** 3)  Remove contact(s)                    ");
            System.out.println("** 4)  Sort the list by name                ");
            System.out.println("** 5)  Quit                                 ");
            System.out.println("**********************************************");
            System.out.print("** > ");

            choice = keyboard.nextInt();
            // Clear newline
            keyboard.nextLine();

            System.out.println();

            switch (choice) {
                // Add new contact
                case 1:
                    contactList.add(Contact.promptUser());
                    System.out.println("\nContact added to list.\n");
                    break;

                // Display contacts
                case 2:
                    // Prompt user for search key
                    System.out.print("Enter a search key to be displayed (or \"ALL\" for full list): ");
                    key = keyboard.nextLine();
                    System.out.println();
                    // Display all case
                    if (key.equalsIgnoreCase("ALL"))
                        key = null;
                    // Display search results, or message if empty
                    if (contactList.printSearchResults(key).size() == 0)
                    {
                        System.out.println("Contact list empty, please add a new contact.");
                    }
                    System.out.println();
                    break;

                // Remove contact(s)
                case 3:
                    System.out.print("Enter a search key to be removed (or \"ALL\" to clear all contacts): ");
                    key = keyboard.nextLine();
                    if (key.equalsIgnoreCase("ALL"))
                        key = null;
                    searchIndices = contactList.printSearchResults(key);
                    System.out.print("\nAre you sure you would like to delete these " + searchIndices.size() + " contacts? (Y / N) ");
                    // If user confirms...
                    if (keyboard.nextLine().equalsIgnoreCase("Y"))
                    {
                        // Loop through indices, starting from highest
                        for (int i = searchIndices.size() - 1; i >= 0; i--) {
                            // Remove value at index
                            contactList.remove(searchIndices.get(i));
                        }
                        System.out.println("\nSuccessfully removed " + searchIndices.size() + " contacts.\n");
                    }
                    // If user declines...
                    else
                    {
                        System.out.println("\nCancelling request.\n");
                    }
                    break;

                // Sort the list by name
                case 4:
                    contactList.sort();
                    System.out.println("Contacts have been sorted alphabetically.\n");
                    contactList.printSearchResults(null);
                    System.out.println();
                    break;

                // Quit
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                // Invalid selection
                default:
                    System.out.println("Error. Please select a valid option.");
                    break;
            }
        }
    }
}

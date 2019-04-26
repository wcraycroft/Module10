/* ContactArrayList.java
 * Author:  William Craycroft
 * Module:  10
 * Project: Homework 10
 * Description: This wrapper class provides specified methods that manipulate an ArrayList of Contact objects.
 *
 *      Instance variables:
 *          contactList (ArrayList<Contact>) - the ArrayList of Contacts
 *
 *      Methods:
 *          set - Returns the Contact at the passed index, and replaces that Contact with the passed Contact
 *          add (+1) - Adds a Contact at the passed index. Appends if no index is given.
 *          remove (+1) - Removes a Contact, either at the given index or at the first occurrence of the passed Contact
 *          size - Returns the size of the ArrayList
 *          clear - Clears all values in the ArrayList
 *          isEmpty - Returns true if no values are in the ArrayList
 *          sort - Uses the compareTo Contact method to sort all Contacts in alphabetical order by last, then first name.
 *          printSearchResults - Searches through all Contacts for the search key, prints the toString of any matching
 *              Contacts, then returns a list of the indices of all matching search results
 */

import java.util.ArrayList;
import java.util.Collections;

public class ContactArrayList {

    private ArrayList<Contact> contactList;

    public ContactArrayList() {
        contactList = new ArrayList<>();
    }

    public Contact set(int index, Contact element) {
        return contactList.set(index, element);
    }

    public boolean add(Contact element) {
        return contactList.add(element);
    }

    public void add(int index, Contact element) {
        contactList.add(index, element);
    }

    public Contact remove(int index) {
        return contactList.remove(index);
    }

    public boolean remove(Contact contact) {
        return contactList.remove(contact);
    }

    public int size() {
        return contactList.size();
    }

    public void clear() {
        contactList.clear();
    }

    public boolean isEmpty() {
        return contactList.isEmpty();
    }

    // Uses selection sort algorithm to sort all values of the ArrayList by last, then first name.
    public void sort() {

        for (int i = 0; i < size() - 1; i++)
        {
            // Find minimum element
            int min = i;
            for (int j = i + 1; j < size(); j++) {
                if (contactList.get(j).compareTo(contactList.get(min)) < 0) {
                    min = j;
                }
            }
            // Swap min with first;
            Collections.swap(contactList, min, i);
        }
    }

    /**
     * Searches through all Contacts for the search key, prints the toString of any matching Contacts, then returns
     * a list of the indices of all matching search results
     */
    public ArrayList<Integer> printSearchResults (String key)
    {
        // Instantiate list of indices
        ArrayList<Integer> indices = new ArrayList<>();

        // Loop through all Contacts
        for (int i = 0; i < size(); i++ )
            // use contains helper method to see if any member variable contains search key
            if (key == null || contactList.get(i).contains(key))
                indices.add(i);

        // Print each index's toString to console
        for (Integer index : indices)
            System.out.println(contactList.get(index).toString());

        return indices;
    }

}

/* Contact.java
 * Author:  William Craycroft
 * Module:  10
 * Project: Homework 10
 * Description: This class stores a person's contact information, include their first and last names, phone number,
 *      and email address, all stores as String values.
 *
 *      Instance variables:
 *          mFirstName (String) - the Contact's first name
 *          mLastName (String) - the Contact's last name
 *          mPhone (String) - the Contact's phone number
 *          mEmail (String) - the Contact's email address
 *
 *      Methods:
 *          Parameterized constructor taking all instance variables as Strings
 *          setters and getters for all instance variables
 *          toString() - Returns a string representation of the Contact
 *          equals(Object) - Returns true if same type and all instance variables are equal
 *          compareTo(Contact) - Returns an integer equals to the lexicographical difference between the last name of
 *              this Contact and the passed Contact. If last names are equals, returns the difference between the first
 *              names. If both are equal, returns 0.
 *          contains() - Returns True if any of the String instance variables contain the passed search key.
 *          promptUser() - Prompts the user via the console to enter a new Contact, then returns that Contact.
 */

import java.util.Objects;
import java.util.Scanner;

public class Contact {

    private String mFirstName;      // First name
    private String mLastName;       // Last name
    private String mPhone;          // Phone number
    private String mEmail;          // Email address

    // Creates a new Contact with all instance variables provided
    public Contact(String firstName, String lastName, String phone, String email) {
        mFirstName = firstName;
        mLastName = lastName;
        mPhone = phone;
        mEmail = email;
    }

    // Getters and Setters
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    // Returns a string representation of the Contact
    public String toString() {
        return "Contact{" +
                "First Name='" + mFirstName + '\'' +
                ", Last Name='" + mLastName + '\'' +
                ", Phone Number='" + mPhone + '\'' +
                ", Email Address='" + mEmail + '\'' +
                '}';
    }

    // Returns True if same type and all instance variables are equal
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(mFirstName, contact.mFirstName) &&
                Objects.equals(mLastName, contact.mLastName) &&
                Objects.equals(mPhone, contact.mPhone) &&
                Objects.equals(mEmail, contact.mEmail);
    }

    /**
     * Returns an integer equals to the lexicographical difference between the last name of
     * this Contact and the passed Contact. If last names are equals, returns the difference between the first
     * names. If both are equal, returns 0.
     */
    public int compareTo(Contact otherContact) {
        // Get compareTo value for last names
        int compareIndex = mLastName.compareTo(otherContact.mLastName);
        // If last names are the same...
        if (compareIndex == 0) {
            // Return first name compare value
            return mFirstName.compareTo(otherContact.mFirstName);
        }
        return compareIndex;
    }

    // Helper method that checks if any of the String instance variables contain the passed search key.
    public boolean contains(String key) {
        return mFirstName.contains(key)
                || mLastName.contains(key)
                || mPhone.contains(key)
                || mEmail.contains(key);
    }

    // Prompts the user via the console to enter a new Contact, then returns that Contact.
    public static Contact promptUser() {

        Scanner keyboard = new Scanner(System.in);
        String last, first, phone, email;

        System.out.print("Enter First Name: ");
        first = keyboard.nextLine();
        System.out.print("Enter Last Name: ");
        last = keyboard.nextLine();
        System.out.print("Enter Phone Number: ");
        phone = keyboard.nextLine();
        System.out.print("Enter Email Address: ");
        email = keyboard.nextLine();

        return new Contact(first, last, phone, email);
    }







}

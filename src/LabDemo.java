/* LabDemo.java
 * Author:  William Craycroft
 * Module:  10
 * Project: Homework 10
 * Problem Statement: This class demonstrates the functionality of ArrayLists when used to store Point objects.
 *
 * Algorithm / Plan:
 *      1. Instantiate and populate an ArrayList of 8 pre-generated Point objects
 *      2. Test the set method, which replaces a Point in the array with (0,0)
 *      3. Test the get method, which returns a Point at the passed index
 *      4. Test the remove method, which removes a Point at the passed index
 *      5. Test the trimToSize method, which reduces the length of the underlying array to match the list size
 *      6. Test the ensureCapacity method, which (if valid) increases the array size to the passed value
 *      7. Test the size method, which returns the number of elements in the list
 *      8. Test the addAll method, which adds (or appends) a sublist of Points to the list
 *      9. Test the contains method, which returns true if the array contains the passed Point (test with equals method)
 *      10. Test the lastIndexOf method, which return the index of the last occurrence of the passed Point
 *      11. Test the clear method, which removes all elements from the list
 */

import java.util.ArrayList;
import java.util.Arrays;

public class LabDemo {

    public static void main (String[] args)
    {
        // Instantiate ArrayList
        ArrayList<Point> pointList = new ArrayList<>();

        // Add 8 Point objects to ArrayList
        pointList.add(new Point());
        pointList.add(new Point(71,92));
        pointList.add(new Point(9,6));
        pointList.add(new Point(5,12));
        pointList.add(new Point(0,1));
        pointList.add(new Point(2,2));
        pointList.add(new Point(51, 66));
        pointList.add(new Point(-1, 1));

        // 1) set()
        System.out.println("1 - set(): Setting new Point (0, 0) at index 2. Replacing " +
                pointList.set(2, new Point()).toString());

        // 2) get()
        System.out.println("2 - get(): Getting Point at index 6: " + pointList.get(6));

        // 3) remove()
        if (pointList.remove(new Point (51, 66))) {
            System.out.println("3 - remove(): Successfully removed Point (51, 66)");
        }

        // 4) trimToSize()
        pointList.trimToSize();
        System.out.println("4 - trimToSize(): Trimmed capacity to size of list.");

        // 5) ensureCapacity()
        pointList.ensureCapacity(100);
        System.out.println("5 - ensureCapacity(): Increasing list capacity to 100.");

        // 6) size()
        System.out.println("6 - size(): The size of the current list is " + pointList.size());

        // 7) addAll()
        Point[] pointArray = {new Point(71,92), new Point(9,6), new Point(2,2)};
        pointList.addAll(Arrays.asList(pointArray));
        System.out.println("7 - addAll(): Added 3 Points from pointArray to List.");

        // 8) contains(), should return false
        System.out.println("8 - contains(): Does the list contain Point (51, 66)? "
                + pointList.contains(new Point(51, 66)));

        // 9) lastIndexOf(), should return 2
        System.out.println("9 - lastIndexOf(): Last index of Point(0, 0) is " +
                pointList.lastIndexOf(new Point()));

        // 10) clear()
        pointList.clear();
        System.out.println("10- clear(): List has been cleared.");
    }

}

/*
    Lab Question: Difference between arrays, Vectors and ArrayLists
    - adapter class with an array as the underlying data structure
    - you can place a value at any index in an array, array can have empty slots between values
    - automatically increases the capacity of the underlying array
    - arrays are fixed size
    - arrays can be more efficient when dealing with large primitive data sets.
    - ArrayLists cannot be multidimentional
    - Vectors use the same underlying data structure and have the same functionality as ArrayLists
        with the exception that they are thread-safe.
    - In single-thread applications, ArrayLists are more efficient.


*/
import java.util.ArrayList;
import java.util.Arrays;

public class LabDemo {

    public static void main (String[] args)
    {
        // Create array of 8 points
        Point[] pointArray = new Point[8];
        // Instantiate 8 Point objects
        pointArray[0] = new Point();
        pointArray[1] = new Point(71,92);
        pointArray[2] = new Point(9,6);
        pointArray[3] = new Point(5,12);
        pointArray[4] = new Point(0,1);
        pointArray[5] = new Point(2,2);
        pointArray[6] = new Point(51, 66);
        pointArray[7] = new Point(-1, 1);

        // Instantiate ArrayList
        ArrayList<Point> pointList = new ArrayList<>();
        // Loop through point array, add each point to list
        for (Point point : pointArray) {
            pointList.add(point);
        }

        // Use 10 ArrayList methods on the list

        // 1) set
        System.out.println("1) Setting new Point (0, 0) at index 2. Replacing " +
                pointList.set(2, new Point()).toString());

        // 2) get
        System.out.println("2) Getting  Point at index 6: " + pointList.get(6));

        // 3) remove
        if (pointList.remove(new Point (51, 66))) {
            System.out.println("3) Successfully removed Point (51, 66)");
        }

        // 4) trimToSize
        pointList.trimToSize();
        System.out.println("4) Trimmed capacity to size of list.");

        // 5) ensureCapacity
        pointList.ensureCapacity(100);
        System.out.println("5) Increasing list capacity to 100.");

        // 6) size
        System.out.println("6) The size of the current list is " + pointList.size());

        // 7) addAll
        pointList.addAll(Arrays.asList(pointArray));
        System.out.println("7) Added all Point in pointArray to List.");

        // 8) contains (should return false)
        System.out.println("8) Does the list contain Point (51, 66)? "
                + pointList.contains(new Point(51, 66)));

        // 9) lastIndexOf
        System.out.println("9) Last index of Point(0, 0) is " +
                pointList.lastIndexOf(new Point()));

        // 10) clear
        pointList.clear();
        System.out.println("10) List has been cleared.");
    }

}

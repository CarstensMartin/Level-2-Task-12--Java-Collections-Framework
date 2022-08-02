package priorityQueue;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PriorityQueue {

	public static void main(String[] args) {

		/*
		 * Objective: Recreate a priority queue object without actually using PriorityQueue. 
		 * Program should be able to act like a Priority Queue when given an ArrayList of strings. 
		 * Recreate the following Methods: offer, remove, sort and size
		 */

		// ArrayList declared
		ArrayList<String> students = new ArrayList<String>();

		// "Offer" 3 students to the ArrayList
		// Print on console the result after each student is "offered"
		offerMethod(students);
		System.out.println("New list of Students: " + students);

		offerMethod(students);
		System.out.println("New list of Students: " + students);

		offerMethod(students);
		System.out.println("New list of Students: " + students + "\n");

		// Display the "size" of the List Array
		int size = sizeMethod(students);
		System.out.println("Size of the current ListArray is: " + size + "\n");

		// "Sort" the student names
		students = sortMethod(students);
		System.out.println("Sorted Students: " + students + "\n");

		// "Remove" the first student at index 0
		students = removeMethod(students, 0);
		System.out.println("List of Students after 1st item (index 0) is removed: " + students);

		// Display the "Size" of the List Array after item is "Removed"
		size = sizeMethod(students);
		System.out.println("Size of the new ListArray after an item is removed: " + size + "\n");
	}

	// Method to "Offer" a new student without using the Offer function
	public static void offerMethod(ArrayList<String> students) {
		// Prompt user for a student name
		String name = JOptionPane.showInputDialog("Add a student name");
		// Use the add function instead of offer
		students.add(name);
	}

	// Method to Remove the item at given index without using the Remove function
	public static ArrayList<String> removeMethod(ArrayList<String> students, int index) {
		// Declare a new ArrayList
		ArrayList<String> removedStudents = new ArrayList<String>();

		// Use a FOR loop to add all the elements except the index item that gets removed
		// Use the sizeMethod that we have created in the For loop
		for (int x = 0; x < sizeMethod(students); x++) {
			if (x != index) {
				removedStudents.add(students.get(x));
			}
		}
		// Return new ArrayList with the Indexed student removed
		return removedStudents;
	}
	
	// Method to "Sort" the ArrayList without using Sort function
	public static ArrayList<String> sortMethod(ArrayList<String> students) {
		// Cast to a String Array
		String[] stringArray = students.toArray(new String[sizeMethod(students)]);

		// Use a FOR loop and the swapping method, if the 2nd value is bigger than the 1st then swap around
		// FOR loop for 1st value
		for (int x = 0; x < (stringArray.length) - 1; x++) {
			
			// FOR loop for 2nd value
			for (int y = x + 1; y < stringArray.length; y++) {
				
				// If the 2nd value compared to the first is positive(larger than 0)
				if (stringArray[x].compareTo(stringArray[y]) > 0) {
					
					// Create a temporary string to keep value of first List item
					String temporary = stringArray[x];
					
					// Make the 1st List item the same as the 2nd list item
					stringArray[x] = stringArray[y];
					// Use the temporary variable to place the 1st items value in the 2nd item.
					stringArray[y] = temporary;
				}
			}
		}

		// Clear the values of Students that is stored
		students.clear();
		
		// Use a FOR loop to convert the String array to an ArrayList of Strings
		for (int x = 0; x < stringArray.length; x++) {
			// Add the new values to students
			students.add(stringArray[x]);
		}

		// Return the sorted List
		return students;
	}
	
	// Method to determine the "Size" of the ArrayList without using Size function
	public static int sizeMethod(ArrayList<String> students) {
		// Declare integer size
		// Calculate the size by converting the ArrayList to an Array and getting the length
		int size = students.toArray().length;
		// Return the size of the ArrayList
		return size;
	}
}

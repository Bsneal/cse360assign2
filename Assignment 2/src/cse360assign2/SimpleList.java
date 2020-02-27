package cse360assign2;

import java.util.Arrays;

/**
 * @author Brendan Neal; class ID 123; Assignment 2
 */

/**
 * This class defines the functionality for a simple list. This list
 * has a maximum of 10 values which are justified so that the empty
 * section of the array is to the right.
 * 
 * @param	list	the array holding the elements of the list
 * @param	count	a parameter that keeps track of how many elements are in the array
 */
class SimpleList {
	private int[] list;
	private int count;
	
	/**
	 * The constructor for the class. This instantiates the
	 * list and count parameters. The size of the array is set to 10
	 * and the count is set to 0;
	 */
	public SimpleList(){
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds an element to the head of list. In doing so, it pushes
	 * all other array elements are pushed to the right of the array.
	 * If the list is full, the method increases the list's size by 50%
	 * 
	 * @param value	The value that is added to the array.
	 */
	public void add(int value) {
		if(count == list.length) {
			list = Arrays.copyOf(list, (int)(list.length*1.5));
		}
		for(int increment = count - 1; increment >= 0; increment--) {
			list[increment + 1] = list[increment];
		}
		list[0] = value;
		count++;
	}
	
	/**
	 * similar to add(), but instead of inserting the value at the head of
	 * the list, it is inserted at the tail. Also increases the list's size 
	 * by 50% if the list is full.
	 * 
	 * @param value	The value appended to the array.
	 */
	public void append(int value) {
		if(count == list.length) {
			list = Arrays.copyOf(list, (int)(list.length*1.5));
		}
		list[count] = value;
		count++;
	}
	
	/**
	 * Removes the specified element from the array if it exists.
	 * If a value is removed, all values ahead of the removed
	 * element are moved back to fill the gap left.
	 * 
	 * It should be noted that this method doesn't delete old data.
	 * It's assumed that because the count parameter defines the
	 * size of the list, any values past the count will be unreachable.
	 * However, if 25% of the list is not in use, that 25% will be truncated.
	 * the list cannot be smaller than 1.
	 * 
	 * @param value	Value to be removed if it exists in the list
	 * @return	does not return a value. Return is used as a method
	 * 			to escape the method.
	 */
	public void remove(int value) {
		int pos = search(value);
		if(pos == -1) {
			return;
		}
		for(int increment = pos + 1; increment < count; increment++) {
			list[increment] = list[increment - 1];
		}
		count--;
		if((list.length - count) >= (int)list.length*0.25) {
			int new_length = (int)(list.length - list.length*0.25);
			if(new_length > 1) {
				list = Arrays.copyOf(list, new_length);
			}		
		}
	}
	
	/**
	 * Method that returns the number of elements in the list.
	 * 
	 * @return count, which is the number of elements in the list.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Method that returns the first element in the list.
	 * 
	 * @return the first element in the list, which is at index 0.
	 */
	public int first() {
		return list[0];
	}
	
	/**
	 * Method that gives the size of the list. Different from count()
	 * in that it returns the number of possible values, not the amount
	 * of values currently in the array.
	 * 
	 * @return list.length, which is the size of the array.
	 */
	public int size() {
		return list.length;
	}
	
	/**
	 * A method that outputs the list as a string. The string cannot
	 * end in a space, so trim() is used to remove unnecessary spaces.
	 */
	public String toString() {
		String outString = "";
		
		for(int increment = 0; increment < count; increment++) {
			outString += list[increment] + " ";
		}
		
		outString = outString.trim();
		
		return outString;
	}
	
	/**
	 * Searches for a given value in the list and returns the index 
	 * of the value in the list if it is found. Returns -1 otherwise.
	 * 
	 * @param value	The value this method searches for
	 * @return	returns the index of the value or -1
	 */
	int search(int value) {
		int pos = -1;
		int increment = count - 1;
		while(increment >= 0) {
			if(list[increment] == value) {
				pos = increment;
			}
			increment--;
		}
		return pos;
	}
	
}

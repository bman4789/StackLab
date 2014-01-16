//Brian Mitchell and Kristin Rachor

package umm.softwaredesign.stacklab;

import java.util.ArrayList;
import java.util.List;

import umm.softwaredesign.stacklab.StackIF;

/**
 * Implementation of the StackIF interface for a basic stack.
 * 
 * @author Nic McPhee, last changed by $Author: prodgera $ on $Date: 2006/01/25
 *         19:26:03 $
 * @version $Revision: 1.16 $
 */
public class Stack<T> implements StackIF<T> {
	//height of stack
	private int count = 0;
	//initialize an arraylist as the stack
	private ArrayList<T> stack;
	
	/**
	 * Construct an empty stack.
	 */
	public Stack() {
		stack = new ArrayList<T>();
	}

	/**
	 * Makes a new stack containing the given items.
	 * 
	 * We use this to construct specific stacks to use in testing.
	 * 
	 * @param items
	 *            the list of items to initialize the stack
	 */
	public Stack(List<T> items) {
		stack = new ArrayList<T>();
		//after stack is declared, add the items from the list to the stack
		for (T item : items) {
			stack.add(item);
			count++;
		}
	}

	/**
	 * Computes the size of the stack.
	 * 
	 * @return the number of elements on the stack
	 */
	public int size() {
		return count;
	}

	/**
	 * Determines if a stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Push the specified value onto the stack.
	 * 
	 * @param value
	 *            the value to be pushed.
	 */
	public void push(T value) {
		//add the value to the stack
		stack.add(value);
		//add 1 to the height so it is up-to-date
		count++;
	}

	/**
	 * Removes and returns the top value from the stack. If the stack is empty a
	 * StackUnderflowException is thrown.
	 * 
	 * @return the element removed from the stack
	 * @throws StackUnderflowException
	 *             if the stack is empty
	 */
	public T pop() {
		//cannot pop/remove from an empty stack
		if(count == 0) {
			throw new StackUnderflowException();
		} else {
			//use a temp variable to hold the last item
			T temp = stack.get(count - 1);
			//remove the last item and update height
			stack.remove(count - 1);
			count--;
			return temp;
		}
	}

	/**
	 * Return the value on top of the stack. This does not change the stack in
	 * any way. If the stack is empty a StackUnderflowException is thrown.
	 * 
	 * @return the top value on the stack
	 * @throws StackUnderflowException
	 *             if the stack is empty
	 */
	public T top() {
		//cannot get the top item if there are no items
		if(count == 0) {
			throw new StackUnderflowException();
		} else {
			return stack.get(count - 1);
		}
	}

	/**
	 * Determines if this stack contains the given items in the given order.
	 * 
	 * @param items
	 *            is a list of items to check against the items in this stack
	 * @return a boolean value indicating whether this stack has the specified
	 *         elements
	 */
	public boolean hasElements(List<T> items) {
		//checks to see if the heights/lengths are the same size
		if (items.size() != count) {
			return false;
		}
		int index = 0;
		for (T item : items) {
			//returns false if any item from the list does not equal
			//the corresponding item from the stack
			if(!(item.equals(stack.get(index)))){
				return false;
			}
			index++;
		}
		return true;
	}

	/**
	 * Generate a string representation of our stack. A stack containing
	 * elements [x0, x1, x2, ..., xn] (where x0 is the bottom of the stack and
	 * xn is the top) is represented by the string "Stack[s0, s1, s2, ..., sn]",
	 * where the si are the string (printed) representations of the elements xi.
	 * 
	 * @return a string representation of this stack
	 */
	@Override
	public String toString() {
		String str = "Stack[";
		for (int i = 0; i < count; i++) {
			//add the item to the string
			str = str + stack.get(i);
			//if not the last item, add a comment and a space
			if (i != count - 1)
				str = str + ", ";
		}
		str = str + "]";
		return str;
	}
}

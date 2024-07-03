package main.java.lesson_04;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {
	private static class Entry {
		int value;
		IntLinkedList.Entry previous;
		IntLinkedList.Entry next;

		public Entry(int value) {
			this.value = value;
		}
	}

	private int size = 0;
	private IntLinkedList.Entry first = null;
	private IntLinkedList.Entry last = null;

	public IntLinkedList(IntLinkedList list) {
		if(list!=null) {
			for (int i = 0; i < list.size; i++) {
				this.add(list.get(i));
			}
		}
	}

	public IntLinkedList() {
		
	}

	@Override
	// Used in IntQueue and IntList
	public void add(int element) {
		Entry newEntry = new Entry(element);
		if (this.size == 0) {
			first = newEntry;
		} else {
			last.next = newEntry;
			newEntry.previous = last;
		}
		last = newEntry;
		this.size++;
	}

	@Override
	public boolean add(int index, int element) {
		boolean answer = false;
		Entry tmp = null;
		Entry newEntry = new Entry(element);
		Entry rightElement = null;
		Entry leftElement = null;
		if (index < 0 || index > size) {
//			System.err.println("Index out of bounds");
			return answer;
		}

		if (index == size) {
			add(element);
		} else if (index == 0) {
			newEntry.next = first;
			newEntry.previous = null;
			first = newEntry;
			size++;
		} else {
			tmp = first;
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			leftElement = tmp;
			rightElement = tmp.next;
			newEntry.previous = leftElement;
			newEntry.next = rightElement;
			leftElement.next = newEntry;
			rightElement.previous = newEntry;
			size++;
		}
		answer = true;
		return answer;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;

	}

	@Override
	public int get(int index) {
		Entry tmp = first;
		if (index < 0 || index >= size) {
			return -1;
		}

		for (int i = 0; i <index; i++) {
			tmp = tmp.next;
		}
		return tmp.value;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	@Override
	// For IntList return removed value
	public boolean remove(int index) {
		Entry tmp = first;
		boolean answer = false;
		if (index < 0 || index >= size) {
//			System.err.println("Index out of bounds");
			return false;
		} else if (index == 0) {
			first = first.next;
			first.previous = null;
			size--;
			answer = true;
		} else if (index == size - 1) {
			last = last.previous;
			last.next = null;
			size--;
			answer = true;
		} else {
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			Entry left = tmp.previous;
			Entry right = tmp.next;
			left.next = right;
			right.previous = left;
			size--;
			answer = true;
		}

		return answer;
	}


	@Override
	public boolean removeByValue(int value) {
		if (size > 0) {
			Entry tmp = first;
			for (int i = 0; i < size; i++) {
				if (tmp.value == value) {
					remove(i);
					return true;
				} else {
					tmp = tmp.next;
				}
			}
		}
		return false;
	}

	@Override
	public boolean set(int index, int element) {
		if (index < 0 || index > size) {
//			System.err.println("Index out of bounds");
			return false;
		}

		Entry tmp = first;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.value = element;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public IntList subList(int fromIndex, int toIndex) {
		IntLinkedList toReturn = new IntLinkedList();
		if ((fromIndex > -1 && fromIndex < size) && (toIndex > fromIndex && toIndex < size)) {
			for (int i = fromIndex; i < toIndex; i++) {
				toReturn.add(get(i));
			}
		}
		return toReturn;
	}

	@Override
	public int[] toArray() {
		int[] result = new int[size];
		Entry tmpEntry = first;
		for (int i = 0; i < size; i++) {
			result[i] = tmpEntry.value;
			tmpEntry = tmpEntry.next;
		}

		return result;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

//IntStack methods

	@Override
	public boolean push(int value) {
		add(value);
		return true;
	}

	@Override
	public int pop() {
		int answer = get(size-1);
		remove(size - 1);
		return answer;
	}

	@Override
	public int peek() {
		return last.value;
	}

//IntQueue methods

	@Override
	public int element() {	
// return first in Queue but not remove it
		return peek();
	}

	@Override
// For IntQueue return removed value
	public int remove() {
		return pop();
	}

}

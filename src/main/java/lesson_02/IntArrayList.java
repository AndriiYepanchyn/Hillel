package main.java.lesson_02;

import java.util.Arrays;

public class IntArrayList implements IntList {

	private int[] arr = new int[10];
	private int size = 0;

	public IntArrayList(IntList myList) {
		size = myList.size();
		arr = myList.toArray();
	}

	public IntArrayList() {

	}

	@Override
	public void add(int element) {
		if (size >= arr.length) {
			int newSize = arr.length * 3 / 2 + 1;
			int[] newArr = new int[newSize];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		}
		arr[size] = element;
		size++;
	}

	@Override
	public boolean add(int index, int element) {
		boolean answer = false;
		int[] newArr = new int[size + 1];
//		System.out.println("index=" + index + ";  size=" + size);
		if (index >= 0 && index <= size) {
			for (int i = 0; i < index; i++) {
				newArr[i] = arr[i];
			}
			newArr[index] = element;
			for (int j = index + 1; j <= size; j++) {
				newArr[j] = arr[j - 1];
			}

			arr = newArr;
			size = arr.length;
			answer = true;
		}
		return answer;
	}

	@Override
	public void clear() {
		int[] clearArr = new int[0];
		arr = clearArr;
		size = 0;
	}

	@Override
	public int get(int index) {
		if (index >= 0 && index < size) {
			return arr[index];
		} else
			return 0;
	}

	@Override
	public boolean isEmpty() {
		// In this case Empty then array has 0 length
		boolean answer;
		if (size == 0) {
			answer = true;
		} else
			answer = false;
		return answer;
	}

	@Override
	public boolean remove(int index) {
		// Removes element at set index and scretch arraylist
		boolean answer;
		int[] newArr = new int[size - 1];
		if (index >= 0 && index < size) {
			for (int i = 0; i < index; i++) {
				newArr[i] = arr[i];
			}
			for (int j = index; j < size - 1; j++) {
				newArr[j] = arr[j + 1];
			}
			arr = newArr;
			size = size - 1;
			answer = true;
		} else
			answer = false;
		return answer;
	}

	@Override
	public boolean removeByValue(int value) {
		boolean answer = false;
		int checkSumm = 0;
		int newArrIndex = 0;

		// считаем ячейки с елементом
		for (int i = 0; i < size; i++) {
			if (arr[i] == value) {
				checkSumm++;
			}
		}

		int[] newArr = new int[size - checkSumm];
		for (int i = 0; i < size; i++) {
			if (arr[i] != value) {
				newArr[newArrIndex] = arr[i];
				newArrIndex++;
			}
		}
		arr = newArr;
		size = newArr.length;
		answer = (checkSumm > 0);
		return answer;
	}

	@Override
	public boolean set(int index, int element) {
		boolean answer;
		if ((index > size) || (index < 0)) {
			answer = false;
		} else {
			arr[index] = element;
			answer = true;
		}
		return answer;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public IntList subList(int fromIndex, int toIndex) {
		if(fromIndex<0 || fromIndex>size-1 || toIndex<0 || toIndex>size-1) {
			return new IntArrayList();
		}
		IntArrayList answer = new IntArrayList();
		int start = fromIndex>toIndex? toIndex: fromIndex;
		int finish = fromIndex<toIndex? toIndex: fromIndex;
		
		for(int i=start; i<=finish; i++) {
			answer.add(arr[i]);
		}
		
		return answer; 
	}

	@Override
	public int[] toArray() {
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

}
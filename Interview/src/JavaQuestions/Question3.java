//remove duplicates from the arraylist
package JavaQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question3 {

	public static void main(String[] args) {

		ArrayList<Integer> intArrayList = new ArrayList<>();
		ArrayList<Integer> newList = new ArrayList<>();

		intArrayList.add(10);
		intArrayList.add(10);
		intArrayList.add(30);
		intArrayList.add(30);
		

		for (Integer element : intArrayList) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}

		for (Integer element : newList) {
			System.out.println(element);
		}

		// or
		Set<Integer> set = new HashSet<>(intArrayList);
		intArrayList.clear();
		intArrayList.addAll(set);

		System.out.println(intArrayList);

	}
}

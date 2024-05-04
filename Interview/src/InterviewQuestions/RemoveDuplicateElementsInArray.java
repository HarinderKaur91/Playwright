package InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

//
public class RemoveDuplicateElementsInArray {

	public static void main(String[] args) {

		int[] numberArray = { 2, 4, 5, 7, 2, 4, 8 };
		replaceDuplicateElementWithZero(numberArray);

	}

	static void replaceDuplicateElementWithZero(int[] numberArray) {
		for (int i = 0; i < numberArray.length; i++) {
			for (int j = i + 1; j < numberArray.length; j++) {
				if (numberArray[i] == numberArray[j]) {
					numberArray[j] = 0;
				}
			}
		}
		for (int element : numberArray) {
			System.out.print(element + " ");
		}
	}

}

package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//Java program to print all non repeating character in string.
public class NonRepeatingCharsInString {

	public static void main(String[] args) {

		String string = "Ketake";
		string = string.toLowerCase();
		int charCounter = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>(charCounter);
		char[] charArray = string.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					charCounter++;
				}
			}
		}
		System.out.println("Count = " + charCounter);

	}

}

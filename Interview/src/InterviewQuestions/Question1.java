
//Write a program to check if String has all unique characters in java
package InterviewQuestions;

public class Question1 {

	public static void main(String[] args) {

		String name = "Ketaki";
		
		String  name1 = name.toLowerCase();
		char[] charArray = name1.toCharArray();
		boolean isStringUnique = true;

		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					isStringUnique = false;
				}
			}
		}

		if (isStringUnique) {
			System.out.println(name + " is a unique string");
		} else {
			System.out.println(name + " is not unique");
		}
	}

}

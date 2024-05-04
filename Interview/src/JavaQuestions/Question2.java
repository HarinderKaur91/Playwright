//remove words containing 'a'
package JavaQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {

	public static void main(String[] args) {

		String[] arrString = { "Deny","Rm", "Sham", "Jahn", "Robert" };
		
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arrString));

		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).contains("a"))) {
				list.remove(i);
				--i;
				System.out.println(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//or
		

		String name = "Aana";
		String newName = name.replaceAll("a", "");
		System.out.println(newName);

	}

}

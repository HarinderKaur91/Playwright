//find second largest element in arraylist 

package JavaQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class InterviewQuestion {

	public static void main(String[] args) {

		List<Integer> intArrayList = new ArrayList<Integer>();
		intArrayList.add(10);
		intArrayList.add(5);
		intArrayList.add(15);
		intArrayList.add(7);

		for (int i = 0; i < intArrayList.size(); i++) {
			for (int j = (i + 1); j < intArrayList.size(); j++) {
				if (intArrayList.get(i)>intArrayList.get(j)) {
					int temp= intArrayList.get(i);
					intArrayList.set(i,intArrayList.get(j));
					intArrayList.set(j,temp);
				}
			}
		}
		
		
		
	//	Collections.sort(intArrayList);
		for(int i=intArrayList.size()-1;i>=0;i--) {
			System.out.println(intArrayList.get(i));
		}

		int index = intArrayList.size() - 1;
		
		System.out.println("Second largest element: " + intArrayList.get(index - 1));
			
		

	}
}

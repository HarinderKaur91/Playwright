
//Find a pair whose sum is closest to zero in the array?
package InterviewQuestions;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numArray = { 2, 4, -5, -30, -35, 25 };
		int arraySize = numArray.length;
		findSumClosestToZero(numArray);

	}

	public static void findSumClosestToZero(int[] numberArray) {

		int sum = numberArray[0] + numberArray[1];
		int firstIndex = 0;
		int secondIndex = 1;

		for (int i = 0; i < numberArray.length - 1; i++) {
			for (int j = i + 1; j < numberArray.length; j++) {
				int sumOfElements = numberArray[i] + numberArray[j];
				if (Math.abs(sum) > Math.abs(sumOfElements)) {
					sum = sumOfElements;
					firstIndex = i;
					secondIndex = j;
					System.out.println(i+" "+j);
				}
			}
		}

		System.out.println("sum of " + numberArray[firstIndex] + "and" + numberArray[secondIndex] + "is : " + sum
				+ " is closet to zero ");
	}

}

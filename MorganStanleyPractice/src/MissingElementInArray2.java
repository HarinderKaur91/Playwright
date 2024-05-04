import java.util.Arrays;

public class MissingElementInArray2 {

	static int missingNumber(int array[], int n) {
		// Your Code Here
		int res = 0;

		Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				res = i + 1;
				break;
			}
		}

		if (res == 0) {
			res = n;
		}

		return res;
	}
	public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5 };
        int N = arr.length;
        System.out.println(missingNumber(arr, N));
    }
}

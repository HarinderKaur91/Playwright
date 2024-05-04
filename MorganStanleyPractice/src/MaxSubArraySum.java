
public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -5 };
		System.out.println(maxSubArray(arr));
	}

	 public static int maxSubArray(int[] nums) {

		int n = nums.length;
		int maximumSubArraySum = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;

		for (int i = 0; i < n; i++) {

			int runningWindowSum = 0;

			for (int j = i; j < n; j++) {
				runningWindowSum += nums[j];

				if (runningWindowSum > maximumSubArraySum) {
					maximumSubArraySum = runningWindowSum;
					start = i;
					end = j;
				}
			}
		}
		System.out.println("Found Maximum Subarray between" + start + " and " + end);
		return maximumSubArraySum;
	}

}

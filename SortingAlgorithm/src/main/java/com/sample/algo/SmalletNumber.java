/**
 * Given a sorted array (sorted in increasing order) of positive numbers, find
 * the smallest positive integer value that cannot be represented as sum of
 * elements of any subset of given set. Expected time complexity is O(n). Assume
 * a subset can have number of elements >=1.
 * Examples: Input: arr[] = {1, 3, 6,10, 11, 15}; Output: 2
 * Input: arr[] = {1, 1, 1, 1}; Output: 5
 * Input: arr[] = {1, 1, 3, 4}; Output: 10
 * Input: arr[] = {1, 2, 5, 10, 20, 40}; Output: 4
 *
 */
public class SmalletNumber {

	// assumption : input is sorted array
	private static int findSmallestNumberNotRepresetableByAnySum(int[] input) {
		int result = 1;
		for (final int j : input) {
			if (j > result) {
				return result;
			}
			result = result  + j;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findSmallestNumberNotRepresetableByAnySum(new int[] { 1, 3, 6, 10, 11, 15 }));
		System.out.println(findSmallestNumberNotRepresetableByAnySum(new int[] { 1, 1, 1, 1 }));
		System.out.println(findSmallestNumberNotRepresetableByAnySum(new int[] { 1, 1, 3, 4 }));
		System.out.println(findSmallestNumberNotRepresetableByAnySum(new int[] { 1, 2, 5, 10, 20, 40 }));

	}
}

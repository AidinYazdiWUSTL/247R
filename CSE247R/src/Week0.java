import java.util.Arrays;

public class Week0 {

	public static void main(String[] args) {
		System.out.println("Two Sum:");
		int[] arr = { 5, 7, 6, 4, 2, 3 };
		int target = 13;
		int[] answer = twoSum(arr, target);
		StringBuilder stringAnswer = new StringBuilder();
		stringAnswer.append("[");
		for (int i = 0; i < answer.length; i++) {
			stringAnswer.append(answer[i]);
			if (i != (answer.length - 1)) {
				stringAnswer.append(", ");
			}
		}
		stringAnswer.append("]");
		System.out.println(stringAnswer.toString());

		System.out.println("Valid Palindrome:");
		System.out.println(validPalindrome("rccar"));

		System.out.println("Reverse words in string:");
		System.out.println(reverse("help me"));

		System.out.println("Repeated words in a string:");
		System.out.println(replace("help me help me new words"));

		System.out.println("Merge two sorted arrays:");
		int[] arr1 = { 1, 3, 7, 9, 100 };
		int[] arr2 = { 1, 2, 4, 7, 8, 30 };
		int[] merged = merge(arr1, arr2);
		StringBuilder stringMerged = new StringBuilder();
		stringMerged.append("[");
		for (int i = 0; i < merged.length; i++) {
			stringMerged.append(merged[i]);
			if (i != (merged.length - 1)) {
				stringMerged.append(", ");
			}
		}
		stringMerged.append("]");
		System.out.println(stringMerged.toString());
	}

	public static int[] twoSum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if ((i != j) && ((arr[i] + arr[j]) == target)) {
					int[] newArr = { i, j };
					return newArr;
				}
			}
		}
		int[] newArr = { -1, -1 };
		return newArr;
	}

	public static boolean validPalindrome(String str) {
		boolean bool = true;
		String[] strings = str.toLowerCase().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
		}
		char[] chars = sb.toString().toCharArray();
		int length = chars.length;
		for (int i = 0; i < length / 2; i++) {
			if (chars[i] != chars[length - 1 - i]) {
				bool = false;
			}
		}
		return bool;
	}

	public static String reverse(String str) {
		// split up the string
		String[] strings = str.split(" ");
		// run through each word in the string
		for (int i = 0; i < strings.length; i++) {
			// reverse the given word
			char[] chars = strings[i].toCharArray();
			int length = chars.length;
			for (int j = 0; j < length / 2; j++) {
				char char1 = chars[j];
				chars[j] = chars[length - 1 - j];
				chars[length - 1 - j] = char1;
			}
			StringBuilder charString = new StringBuilder();
			for (int j = 0; j < chars.length; j++) {
				charString.append(chars[j]);
			}
			strings[i] = charString.toString();
		}

		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			finalString.append(strings[i]);
			if (i != (strings.length - 1)) {
				finalString.append(" ");
			}
		}
		return finalString.toString();
	}

	public static String replace(String str) {
		String[] strings = str.split(" ");
		boolean[] bools = new boolean[strings.length];
		for (int i = 0; i < bools.length; i++) {
			bools[i] = true;
		}

		for (int i = 0; i < strings.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if ((i != j) && (strings[i].equals(strings[j]))) {
					bools[i] = false;
				}
			}
		}

		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			if (bools[i]) {
				finalString.append("N");
			} else {
				finalString.append("Y");
			}

			if (i != (strings.length - 1)) {
				finalString.append(" ");
			}
		}
		return finalString.toString();
	}

	// I'm assuming that arrays are sorted smallest to biggest values
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] finalarr = new int[arr1.length + arr2.length];
		int arr1Counter = 0;
		int arr2Counter = 0;
		for (int i = 0; i < finalarr.length; i++) {
			if (arr1Counter >= arr1.length) {
				finalarr[i] = arr2[arr2Counter];
				arr2Counter++;
			} else if (arr2Counter >= arr2.length) {
				finalarr[i] = arr1[arr1Counter];
				arr1Counter++;
			} else if (arr1[arr1Counter] <= arr2[arr2Counter]) {
				finalarr[i] = arr1[arr1Counter];
				arr1Counter++;
			} else {
				finalarr[i] = arr2[arr2Counter];
				arr2Counter++;
			}
			System.out.println(Arrays.toString(finalarr));
		}
		return finalarr;
	}

}

public class TestSort {
	/**  Tests the sort method of the Sort class */
	public static void testSort() {
		String[] input = {"i", "have", "an", "apple"};
		String[] output = {"apple", "an", "have", "i"};

		Sort.sort(input);
		org.junit.Assert.assertArrayEquals(output, input);
		// for (int i = 0; i < input.length; i++) {
		// 	if (!input[i].equals(output[i])) {
		// 		System.out.println("Mismatch in position " + i + " expected: " + output[i] + " but got " + input[i] + ".");
		// 		break;
		// 	}
		// }
	}

	public static void main(String[] args) {
		testSort();
	}
}
public class Flatten {
	public static int[] flatten(int[][] x) {
		int totalLength = 0;
		for (int[] x1 : x) {
			totalLength += x1.length;
		}


		int[] a = new int[totalLength];
		int aIndex = 0;

		for (int[] x1 : x) {
			for (int x2 : x1) {
				a[aIndex++] = x2;
			}
		}

		return a;
	}
	public static void main(String[] args) {
		int[][] x = {{1, 2, 3}, {}, {7, 8}};
		int[] a = flatten(x);
		System.out.println(java.util.Arrays.toString(a));
	}
}
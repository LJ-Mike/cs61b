public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}

	private IntNode first;

	public void addFirst(int x) {
		first = new IntNode(x, first);
	}

	public void insert(int x, int position) {
		if (position == 0 && first == null) {
			addFirst(x);
		} else {
			IntNode prev = first;
			IntNode next = first;
			while (position > 0 && next != null) {
				prev = next;
				next = next.next;
				position--;
			}
			IntNode n = new IntNode(x, next);
			prev.next = n;
		}
	}

	/* Recursively */
	public void reverseR() {
		first = reverse(first, null);
	}

	/* helper method, using recursive*/
	private IntNode reverse(IntNode p, IntNode last) {
		if (p == null) {
			return last;
		} else {
			IntNode next = p.next;
			p.next = last;
			return reverse(next, p);
		}
	}

	/* Iteratively */
	public void reverseI() {
		IntNode prev = null;
		IntNode current = first;
		IntNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		first = prev;
	}

	/* Print SLList in console one by one in a line */
	public void print() {
		IntNode p = first;
		while (p != null) {
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.println();
	}

	/**
	 * Insert a item at position in arr
	 * If position is past by end of the arr
	 * add item at the end of the arr
	 * */
	public static int[] insert(int[] arr, int item, int position) {
		int[] ret = new int[arr.length + 1];
		int j = 0;
		for (int i = 0; i < arr.length + 1; i++) {
			if (position == i || (j >= arr.length)) {
				ret[i] = item;
			} else {
				ret[i] = arr[j++];
			}
		}
		return ret;
	}

	/**
	 * Non-destructive function
	 * Replace the number at index i with arr[i]
	 * copies of itself
	 * 
	 * [3, 2, 1] => [3, 3, 3, 2, 2, 1]
	 * 
	 * */
	public static int[] replicate(int[] arr) {
		int newSize = sum(arr);
		int[] ret = new int[newSize];
		int j = 0;
		for (int i = 0, k = arr[j]; i < newSize; i++, k--) {
			if (k == 0) {
				j++;
				k = arr[j];
			}
			ret[i] = arr[j];
		}
		return ret;
	}

	/**
	 * Sum all elements of the array
	 * 
	 * All elements is positive
	 * */
	private static int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3};
		int[] b = SLList.replicate(a);
	}
}
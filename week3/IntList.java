public class IntList {
	public int first;
	public IntList rest;

	public IntList(int first_, IntList rest_) {
		first = first_;
		rest = rest_;
	}

	public void skippify() {
		IntList p = this;
		int n = 1;
		while (p != null) {
			IntList next = p.rest;

			for (int i = 0; i < n; i++) {
				if (next == null) {
					break;
				}
				next = next.rest;
			}
			p.rest = next;
			n++;
			p = p.rest;
		}
	}

	/** Non-destructively creates a copy of x that contains no occurences of y.*/
	public static IntList ilsans(IntList x, int y) {
		if (x == null) {
			return null;
		}
		if (x.first == y) {
			return ilsans(x.rest, y);
		}
		return new IntList(x.first, ilsans(x.rest, y));
	}

	/** Destructively modify and return x to contain no occurences of y,
	without using the keyword "new". */
	public static IntList dilsans(IntList x, int y) {
		if (null) {
			return null;
		}
		x.rest = dilsans(x.rest, y);
		if (x.first == y) {
			return x.rest;
		}
		return x;
	}

	public void print() {
		System.out.print("[");
		IntList p = this;
		while (p != null) {
			System.out.print(p.first + ", ");
			p = p.rest;
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		IntList p1 = new IntList(2, null);
		p1.rest = new IntList(2, null);
		p1.rest.rest = new IntList(3, null);
		p1.rest.rest.rest = new IntList(4, null);
		p1.rest.rest.rest.rest = new IntList(2, null);
		p1.rest.rest.rest.rest.rest = new IntList(6, null);
		p1.rest.rest.rest.rest.rest.rest = new IntList(2, null);
		p1.rest.rest.rest.rest.rest.rest.rest = new IntList(8, null);
		p1.rest.rest.rest.rest.rest.rest.rest.rest = new IntList(2, null);
		p1.rest.rest.rest.rest.rest.rest.rest.rest.rest = new IntList(2, null);

		p1.print();
		IntList p = ilsans(p1, 2);
		p1.print();
		p.print();


		// IntList p2 = new IntList(9, null);
		// p2.rest = new IntList(8, null);
		// p2.rest.rest = new IntList(7, null);
		// p2.rest.rest.rest = new IntList(6, null);
		// p2.rest.rest.rest.rest = new IntList(5, null);
		// p2.rest.rest.rest.rest.rest = new IntList(4, null);
		// p2.rest.rest.rest.rest.rest.rest = new IntList(3, null);
		// p2.rest.rest.rest.rest.rest.rest.rest = new IntList(2, null);
		// p2.rest.rest.rest.rest.rest.rest.rest.rest = new IntList(1, null);
		// p2.print();
		// p2.skippify();
		// p2.print();
	}
}
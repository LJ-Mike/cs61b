public class Main {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		Integer a1 = i;
		Integer a2 = j;
		if (a1 == a2)
			System.out.println(a1 + ";" + a2);
		i = -129;
		j = -129;
		a1 = i;
		a2 = j;
		if (a1 == a2)
			System.out.println(a1 + ";" + a2);
	}
}
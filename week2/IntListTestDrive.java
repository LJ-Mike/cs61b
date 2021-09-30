public class IntListTestDrive {
    public static void main(String[] args) {
        IntList L = new IntList(10, null);
        L = new IntList(5, L);
        L = new IntList(0, L);
        System.out.println("Size: " + L.iterativeSize());

        System.out.println("First: " + L.iterativeGet(2).first);
    }
}

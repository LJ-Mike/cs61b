public class AListTest {
    public static void main(String[] args) {
        AList l = new AList();
        for (int i = 0; i < 100000; i++) {
            l.addLast(i);
        }
    }
}
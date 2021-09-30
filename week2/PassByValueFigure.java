public class PassByValueFigure {
    public static void main(String[] args) {
        Walrus walrus = new Walrus(3500, 10.5);
        int x = 9;

        doStuff(walrus, x);
        System.out.println(walrus);
        System.out.println(x);
    }
    public static void doStuff(Walrus walrus, int x) {
        walrus.weight = walrus.weight - 100;
        x = x - 5;
    }
}
/**
 * Does the call to doStuff have an effect on walrus and/or x?
 * 
 * + Walrus: Yes. The walrus is passed to doStuff by value of address of walrus object.
 * It means walrus object in main() and walrus in doStuff() are same. Any change to walrus in doStuff() will modify walrus in main()
 * + x: no. The value is passed is the value of x variable, and follow Gloden Rule of Equals (GRoE), Two variables is not related to each other.
 */
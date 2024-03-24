package rodeo.o2craft.Utils;

public class Pair<A, B> {
    public A first;
    public B second;

    public Pair(A first, B second) {}

    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }
}

public class Tuple<A, B> {
    private A first;
    private B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }


    //setter and getter for A/first
    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    //setter and getter for B/second
    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}